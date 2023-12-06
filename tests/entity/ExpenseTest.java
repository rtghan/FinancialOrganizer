package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {
    Expense expense;
    LocalDateTime date = LocalDateTime.now();
    @BeforeEach
    void setUp() {
        expense = new Expense("Groceries", 100, date);
    }

    @Test
    void getCategory() {
        assertEquals("Groceries", expense.getCategory());
    }

    @Test
    void getAmount() {
        assertEquals(100, expense.getAmount());
    }

    @Test
    void getDate() {
        assertEquals(date, expense.getDate());
    }
}