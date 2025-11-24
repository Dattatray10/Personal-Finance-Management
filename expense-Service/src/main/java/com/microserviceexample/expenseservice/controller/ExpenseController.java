package com.microserviceexample.expenseservice.controller;


import com.microserviceexample.expenseservice.entity.Expense;
import com.microserviceexample.expenseservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;


    @PostMapping("/create")
    public Expense createExpense(@RequestBody Expense expense) {

        return expenseService.addExpence(expense);
    }

    @GetMapping("/getAll")
    public List<Expense> getAllExpenses() {

        return expenseService.findAllExpense();

    }
}
