package com.microserviceexample.expenseservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "expense title should not be null")
    @NotBlank(message = "expense title should not be blank")
    private String expenseTitle;
    @NotNull(message = "expenseDescription title should not be null")
    @NotBlank(message = "expenseDescription title should not be null")
    private String expenseDescription;
    @NotNull(message = "Expense amount is required")
    @Positive(message = "Expense amount must be greater than 0")
    private double expenseAmount;
}
