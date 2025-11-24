package com.microserviceexample.expenseservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    private Long id;
    private String budgetCategory;
    private Double budgetAmount;
    private String expenseDescription;
    private Double expenseAmount;
}
