package back_end.add_income;

import back_end.add_budget.*;
import data_access.MemoryDAO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AddIncomeInteractorTest {
    String incomeSource = "paycheck";
    double amount = 123.;
    Month month = LocalDateTime.now().getMonth();
    MemoryDAO memoryDAO = new MemoryDAO();
    AddIncomeDataAccessInterface addIncDAO = memoryDAO;
    AddIncomeOutputBoundary presenter = new AddIncomeOutputBoundary() {
        @Override
        public void prepareSuccessView(AddIncomeOutputData addIncomeOutputData) {
            assertEquals(incomeSource, addIncomeOutputData.getIncomeSource());
            assertEquals(amount, addIncomeOutputData.getAmount());
            assertEquals(month, addIncomeOutputData.getMonth());
            assertEquals(amount, addIncDAO.getBudgetByMonth(month).totalIncome());
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
        AddIncomeInputData inputData = new AddIncomeInputData(incomeSource, amount, month);
        AddIncomeInteractor interactor = new AddIncomeInteractor(addIncDAO, presenter);
        interactor.execute(inputData);
    }
    @Test
    void successTest() {
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
        AddIncomeInputData inputData = new AddIncomeInputData(incomeSource, amount, month);
        AddIncomeInteractor interactor = new AddIncomeInteractor(addIncDAO, presenter);
        interactor.execute(inputData);
    }
}