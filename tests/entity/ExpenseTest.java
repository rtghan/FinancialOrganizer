package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {
    Expense expense;
    @BeforeEach
    void setUp() {
        expense = new Expense("Groceries", 100, LocalDateTime.now());
    }

    @Test
    void getCategory() {
        assertEquals("groceries", expense.getCategory());
    }

    @Test
    void getAmount() {
        assertEquals(100, expense.getAmount());
    }

    @Test
    void getDate() {
        assertEquals(LocalDateTime.now(), expense.getDate());
    }
}