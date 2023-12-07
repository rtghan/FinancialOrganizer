package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InvestmentTest {
    Investment investment;
    LocalDate date = LocalDateTime.now().toLocalDate();
    @BeforeEach
    void setUp() {
        investment = new Investment("AAPL", 120, date);
    }

    @Test
    void getStockName() {
        assertEquals("AAPL", investment.getStockName());
    }

    @Test
    void setStockName() {
        investment.setStockName("AMZN");
        assertEquals("AMZN", investment.getStockName());
    }

    @Test
    void getQty() {
        assertEquals(120, investment.getQty());
    }

    @Test
    void setQty() {
        investment.setQty(200);
        assertEquals(200, investment.getQty());
    }

    @Test
    void getDate() {
        assertEquals(date, investment.getDate());
    }

    @Test
    void setDate() {
        LocalDate tomorrow = date.plusDays(1);
        investment.setDate(tomorrow);
        assertEquals(tomorrow, investment.getDate());
    }
}