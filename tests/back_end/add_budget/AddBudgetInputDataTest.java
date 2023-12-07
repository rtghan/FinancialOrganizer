package back_end.add_budget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AddBudgetInputDataTest {
    private AddBudgetInputData inputData;
    private Month month = LocalDateTime.now().getMonth();
    @BeforeEach
    void setUp() {

        inputData = new AddBudgetInputData(month, 12, 13);
    }

    @Test
    void getSelectedMonth() {
        assertEquals(month, inputData.getSelectedMonth());
    }

    @Test
    void getSavingAmt() {
        assertEquals(12, inputData.getSavingAmt());
    }

    @Test
    void getSpendingAmt() {
        assertEquals(13, inputData.getSpendingAmt());
    }
}