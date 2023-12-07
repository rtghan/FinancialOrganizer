package back_end.add_budget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AddBudgetOutputDataTest {
    Month month = LocalDateTime.now().getMonth();
    AddBudgetOutputData addBudgetOutputData;

    @BeforeEach
    void setUp() {
        addBudgetOutputData = new AddBudgetOutputData(month, 123, 456);
    }

    @Test
    void getBudgetMonth() {
        assertEquals(month, addBudgetOutputData.getBudgetMonth());
    }

    @Test
    void getSavAmt() {
        assertEquals(123, addBudgetOutputData.getSavAmt());
    }

    @Test
    void getSpdAmt() {
        assertEquals(456, addBudgetOutputData.getSpdAmt());
    }
}