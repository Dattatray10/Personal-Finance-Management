package com.microserviceexample.expenseservice.service;


import com.microserviceexample.expenseservice.entity.Budget;
import com.microserviceexample.expenseservice.entity.Expense;
import com.microserviceexample.expenseservice.entity.Notification;
import com.microserviceexample.expenseservice.repository.ExpenseRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private RestTemplate restTemplate;

    private final String BUDGET_SERVICE_URL = "http://localhost:8082/budget/getbyCategory/";
    private final String NOTIFICATION_SERVICE_URL = "http://localhost:8084/noitfy/create/";

    @Transactional
    public Expense addExpence(Expense expense) {

        Expense newExpense = expenseRepo.save(expense);

        Double totalexpenseAmt = expenseRepo.findByExpenseTitle(expense.getExpenseTitle()).stream()
                .mapToDouble(Expense::getExpenseAmount).sum();

        try {

            Budget budget = restTemplate.getForObject(BUDGET_SERVICE_URL + newExpense.getExpenseTitle(), Budget.class);

            if (budget != null && totalexpenseAmt > budget.getAmount()) {

                Notification notification = new Notification();

                notification.setExpenseDescription(newExpense.getExpenseDescription());
                notification.setBudgetCategory(budget.getCategory());
                notification.setExpenseAmount(expense.getExpenseAmount());
                notification.setBudgetAmount(budget.getAmount());

                restTemplate.postForObject(NOTIFICATION_SERVICE_URL , notification, String.class);
            }
        } catch (Exception e) {
            System.err.println("Error in calling the service : " + e.getMessage());
        }
        return newExpense;

    }

    public List<Expense> findAllExpense() {

        return expenseRepo.findAll();
    }
}
