package back_end.home_screen;

import back_end.add_budget.*;
import back_end.add_expense.*;
import back_end.add_income.AddIncomeDataAccessInterface;
import back_end.chart_visualisation.ChartOutputData;
import data_access.MemoryDAO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class HomeScreenInteractorTest {
    String incomeSource = "paycheck";
    double expense = 123.;
    double spending = 456.;

    Month month = LocalDateTime.now().getMonth();
    MemoryDAO memoryDAO = new MemoryDAO();
    HomeScreenDataAccessInterface hmDAO = memoryDAO;
    HomeScreenOutputBoundary presenter = new HomeScreenOutputBoundary() {
        @Override
        public void prepareSuccessView(HomeScreenOutputData homeScreenOutputData) throws Exception {
            assertEquals(spending- expense, homeScreenOutputData.getRemainingBudget());
            assertEquals(0, homeScreenOutputData.getTotalIncome());
            assertEquals(expense, homeScreenOutputData.getTotalExpenses());
        }

        @Override
        public void prepareFailView() {
            assertTrue(true);
        }

        @Override
        public void preparePopup(ChartOutputData outputData) {

        }
    };
    @Test
    void failTest(){
        HomeScreenInputData homeScreenInputData = new HomeScreenInputData(month);
        HomeScreenInteractor interactor = new HomeScreenInteractor(presenter, hmDAO);
        try {
            interactor.execute(homeScreenInputData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

        AddExpenseDataAccessInterface addExpDAO = memoryDAO;
        AddExpenseOutputBoundary expPresenter = new AddExpenseOutputBoundary() {
            @Override
            public void prepareSuccessView(AddExpenseOutputData addBudgetOutputData) {
            }

            @Override
            public void cancel() {
            }

            @Override
            public void noBudget() {
            }
        };
        AddExpenseInputData expInputData = new AddExpenseInputData("KFC", "food", expense, month);
        AddExpenseInteractor expInteractor = new AddExpenseInteractor(expPresenter, addExpDAO);
        expInteractor.execute(expInputData);

        HomeScreenInputData hmInputData = new HomeScreenInputData(month);
        HomeScreenInteractor hmInteractor = new HomeScreenInteractor(presenter, hmDAO);
        try {
            hmInteractor.execute(hmInputData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}