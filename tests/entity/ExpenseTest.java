package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {
    Expense expense;
    //LocalDateTime date = LocalDateTime.now();
    Month month = LocalDateTime.now().getMonth();

    @BeforeEach
    void setUp() {
        expense = new Expense("Groceries", 100, month);
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
        assertEquals(month, expense.getMonth());
    }
}