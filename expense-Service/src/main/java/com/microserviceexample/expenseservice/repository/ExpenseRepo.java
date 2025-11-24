package com.microserviceexample.expenseservice.repository;

import com.microserviceexample.expenseservice.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Long> {

    public List<Expense> findByExpenseTitle(String expenseTitle);


}
