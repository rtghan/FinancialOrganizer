package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class IncomeTest {
    private Income income;
    LocalDateTime date = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        income = new Income("paycheck", 1200, date);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getIncomeSource() {
        assertEquals("paycheck", income.getIncomeSource());
    }

    @Test
    void getAmount() {
        assertEquals(1200, income.getAmount());
    }

    @Test
    void getDate() {
        assertEquals(date, income.getDate());
    }
}