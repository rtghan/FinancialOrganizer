package back_end.add_expense;

import back_end.add_budget.*;
import data_access.MemoryDAO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AddExpenseInteractorTest {
    double amount = 123.;
    Month month = LocalDateTime.now().getMonth();
    MemoryDAO memoryDAO = new MemoryDAO();
    AddExpenseDataAccessInterface addExpDAO = memoryDAO;
    AddExpenseOutputBoundary presenter = new AddExpenseOutputBoundary() {
        @Override
        public void prepareSuccessView(AddExpenseOutputData addBudgetOutputData) {
            assertEquals(amount, addBudgetOutputData.getAmount());
            assertEquals(amount, addExpDAO.getBudgetByMonth(month).totalExpenses());
        }

        @Override
        public void cancel() {
        }

        @Override
        public void noBudget() {
            assertTrue(true);
        }
    };

    @Test
    void failTest(){
        AddExpenseInputData inputData = new AddExpenseInputData("KFC", "food", amount, month);
        AddExpenseInteractor interactor = new AddExpenseInteractor(presenter, addExpDAO);
        interactor.execute(inputData);
    }
    @Test
    void successTest(){
        AddBudgetDataAccessInterface addBudDAO = memoryDAO;
        AddBudgetOutputBoundary budPresenter = new AddBudgetOutputBoundary() {
            @Override
            public void prepareSuccessView(AddBudgetOutputData addBudgetOutputData) {
            }

            @Override
            public void cancel() {
            }
        };
        AddBudgetInputData budInputData = new AddBudgetInputData(month, 123, 456);
        AddBudgetInputBoundary budInteractor = new AddBudgetInteractor(addBudDAO, budPresenter);
        budInteractor.execute(budInputData);
        AddExpenseInputData expInputData = new AddExpenseInputData("KFC", "food", amount, month);
        AddExpenseInteractor expInteractor = new AddExpenseInteractor(presenter, addExpDAO);
        expInteractor.execute(expInputData);

    }
}