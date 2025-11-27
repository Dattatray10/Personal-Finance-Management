package com.microserviceexample.expenseservice.config;

import com.microserviceexample.expenseservice.entity.Budget;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "budgetClient" ,url = "${budgeturl}")
public interface BudgetClient {

    @GetMapping("/{category}")
    Budget getBudget(@PathVariable String category);
}
