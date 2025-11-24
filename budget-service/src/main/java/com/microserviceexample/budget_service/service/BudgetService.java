package com.microserviceexample.budget_service.service;

import com.microserviceexample.budget_service.entity.Budget;
import com.microserviceexample.budget_service.repository.BudgetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepo budgetRepo;

    public Budget createBudget(Budget budget) {

        return budgetRepo.save(budget);


    }

    public Budget updateBudget(Budget budget) {

        Budget existingBudget = budgetRepo.findById(budget.getId()).orElse(null);

        if (existingBudget != null) {

            existingBudget.setAmount(budget.getAmount());
            existingBudget.setCategory(budget.getCategory());

        }

        return budgetRepo.save(existingBudget);
    }

    public void deleteBudget(Long id) {

        budgetRepo.deleteById(id);
    }

    public Budget getBudgetdetails(Long id) {

        return budgetRepo.findById(id).orElse(null);
    }

    public Budget getBudgetdetails(String category) {

        return budgetRepo.findByCategory(category);
    }
}
