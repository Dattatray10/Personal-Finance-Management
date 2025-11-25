package com.microserviceexample.expenseservice.controller;


import com.microserviceexample.expenseservice.entity.Expense;
import com.microserviceexample.expenseservice.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;


    @PostMapping("/create")
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) {

        Expense expense1 =expenseService.addExpence(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(expense1);
    }

    @GetMapping("/getAll")
    public List<Expense> getAllExpenses() {

        return expenseService.findAllExpense();

    }
}
