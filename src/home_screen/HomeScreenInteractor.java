package home_screen;

import data_access.BudgetDataAccessInterface;
import data_access.ExpenseDataAccessInterface;
import data_access.IncomeDataAccessInterface;

import entity.Budget;

import java.time.Month;

public class HomeScreenInteractor implements HomeScreenInputBoundary {

    private final HomeScreenOutputBoundary outputBoundary;
    private final BudgetDataAccessInterface budgetDAO;
    private final IncomeDataAccessInterface incomeDAO;
    private final ExpenseDataAccessInterface expenseDAO;

    public HomeScreenInteractor(
            HomeScreenOutputBoundary outputBoundary,
            BudgetDataAccessInterface budgetDAO,
            IncomeDataAccessInterface incomeDAO,
            ExpenseDataAccessInterface expenseDAO) {
        this.outputBoundary = outputBoundary;
        this.budgetDAO = budgetDAO;
        this.incomeDAO = incomeDAO;
        this.expenseDAO = expenseDAO;
    }

    @Override
    public void execute(HomeScreenInputData homeScreenInputData) {

        Month currentMonth = homeScreenInputData.getMonth();

        Budget currentBudget = budgetDAO.getBudgetByMonth(currentMonth);
        double remainingBudget = currentBudget.getRemaining();
        double totalIncome = incomeDAO.getIncomeByMonth(currentMonth).getAmount();
        double totalExpenses = expenseDAO.getExpensesByMonth(currentMonth).getAmount();

        HomeScreenOutputData outputData = new HomeScreenOutputData(
                remainingBudget, totalIncome, totalExpenses);
        outputBoundary.prepareSuccessView(outputData);
    }
}