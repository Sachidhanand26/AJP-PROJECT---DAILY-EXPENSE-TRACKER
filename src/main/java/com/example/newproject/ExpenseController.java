package com.example.newproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/expenses")
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @PostMapping("/addExpense")
    public Expense addExpense(@RequestParam String category, @RequestParam double amount) {
        Expense expense = new Expense();
        expense.setCategory(category);
        expense.setAmount(amount);
        return expenseRepository.save(expense);
    }
}
