package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {
    Budget budget;
    Income income1;
    Income income2;
    Expense expense1;
    Expense expense2;
    Expense expense3;

    @BeforeEach
    void setUp() {
        Month month = LocalDateTime.now().getMonth();
        budget = new Budget(123, 456, month);
        income1 = new Income("paycheck", 300, month);
        income2 = new Income("paycheck", 350, month);
        expense1 = new Expense("Food", 120, month);
        expense2 = new Expense("Groceries", 200, month);
        expense3 = new Expense("Food", 60, month);
    }


    @Test
    void totalExpenses() {
        budget.addExpense(expense1);
        assertEquals(120, budget.totalExpenses());
        budget.addExpense(expense2);
        assertEquals(320, budget.totalExpenses());
        budget.addExpense(expense3);
        assertEquals(380, budget.totalExpenses());
    }

    @Test
    void totalIncome() {
        budget.addIncome(income1);
        assertEquals(300, budget.totalIncome());
        budget.addIncome(income2);
        assertEquals(650, budget.totalIncome());
    }

    @Test
    void getRemaining() {
        budget.addExpense(expense1);
        budget.addExpense(expense2);
        assertEquals(456- budget.totalExpenses(), budget.getRemaining());
    }

    @Test
    void disposableIncome() {
        budget.addIncome(income1);
        budget.addIncome(income2);
        budget.addExpense(expense1);
        budget.addExpense(expense2);
        assertEquals(budget.totalIncome() - budget.totalExpenses() - 123, budget.disposableIncome());
    }
}