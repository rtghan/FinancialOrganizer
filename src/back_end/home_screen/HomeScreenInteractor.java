package back_end.home_screen;

import back_end.add_budget.AddBudgetDataAccessInterface;
import back_end.add_expense.AddExpenseDataAccessInterface;
import back_end.add_income.AddIncomeDataAccessInterface;
import entity.Budget;
import java.time.Month;

/**
 * interactor for home screen
 * implements HomeScreenInputBoundary and executes the home screen
 */
public class HomeScreenInteractor implements HomeScreenInputBoundary {

    private final HomeScreenOutputBoundary outputBoundary;
    private final HomeScreenDataAccessInterface DAO;

    /**
     * constructs the interactor with the specified:
     * @param outputBoundary    home screen output boundary
     * @param homeScreenDAO     data access object required to get the budget to display stats
     */
    public HomeScreenInteractor(
            HomeScreenOutputBoundary outputBoundary,
            HomeScreenDataAccessInterface homeScreenDAO) {
        this.outputBoundary = outputBoundary;
        this.DAO = homeScreenDAO;
    }

    /**
     * executes home screen with specified input data
     * gets the current budget, total income & expense for the specified month
     * prepares output data and success view
     * @param homeScreenInputData   input data
     */
    @Override
    public void execute(HomeScreenInputData homeScreenInputData) {

        Month currentMonth = homeScreenInputData.getMonth();


        Budget currentBudget = DAO.getBudgetByMonth(currentMonth);

        if (currentBudget != null) {
            double remainingBudget = currentBudget.getRemaining();
            double totalIncome = currentBudget.totalIncome();
            double totalExpenses = currentBudget.totalExpenses();

            HomeScreenOutputData outputData = new HomeScreenOutputData(
                    remainingBudget, totalIncome, totalExpenses);
            outputBoundary.prepareSuccessView(outputData);
        }
        else {
            outputBoundary.prepareFailView();
        }

    }
}