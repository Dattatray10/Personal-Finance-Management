package com.microserviceexample.budget_service.controller;

import com.microserviceexample.budget_service.entity.Budget;
import com.microserviceexample.budget_service.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;

    @PostMapping("/create")
    public Budget createBudget(@RequestBody Budget budget) {
        return budgetService.createBudget(budget);
    }

    @PutMapping("/update")
    public Budget updateBudget(@RequestBody Budget budget) {
     return budgetService.updateBudget(budget);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }

    @GetMapping("/get")
    public Budget findBudgetById(@RequestParam Long id) {

       return  budgetService.getBudgetdetails(id);
    }

    @GetMapping("/getbyCategory")
    public Budget findBudgetById(@PathVariable String category) {

        return  budgetService.getBudgetdetails(category);
    }
}
