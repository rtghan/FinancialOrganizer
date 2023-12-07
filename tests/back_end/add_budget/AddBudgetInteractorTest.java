package back_end.add_budget;

import data_access.MemoryDAO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AddBudgetInteractorTest {
    @Test
    void successTest(){
        Month month = LocalDateTime.now().getMonth();
        AddBudgetDataAccessInterface addBudDAO = new MemoryDAO();
        AddBudgetOutputBoundary successPresenter = new AddBudgetOutputBoundary() {
            @Override
            public void prepareSuccessView(AddBudgetOutputData addBudgetOutputData) {
                assertEquals(month, addBudgetOutputData.getBudgetMonth());
                assertEquals(123, addBudgetOutputData.getSavAmt());
                assertEquals(456, addBudgetOutputData.getSpdAmt());
                assertNotNull(addBudDAO.getBudgetByMonth(month));
            }

            @Override
            public void cancel() {
            }
        };
        AddBudgetInputData inputData = new AddBudgetInputData(month, 123, 456);
        AddBudgetInputBoundary interactor = new AddBudgetInteractor(addBudDAO, successPresenter);
        interactor.execute(inputData);
    }

}