package home_screen;

import data_access.BudgetDataAccessInterface;
import data_access.IncomeDataAccessInterface;

import entity.Budget;
import entity.Income;

import java.time.LocalDateTime;
import java.time.Month;

public class HomeScreenInteractor implements HomeScreenInputBoundary {

    private final HomeScreenOutputBoundary outputBoundary;
    private final BudgetDataAccessInterface budgetDAO;
    private final IncomeDataAccessInterface incomeDAO;

    public HomeScreenInteractor(HomeScreenOutputBoundary outputBoundary, BudgetDataAccessInterface budgetDAO, IncomeDataAccessInterface incomeDAO) {
        this.outputBoundary = outputBoundary;
        this.budgetDAO = budgetDAO;
        this.incomeDAO = incomeDAO;
    }

    @Override
    public void execute(HomeScreenInputData homeScreenInputData) {

        LocalDateTime time_now = LocalDateTime.now();
        Month currentMonth = time_now.getMonth();

        Budget currentBudget = budgetDAO.getBudgetByMonth(currentMonth);
        Income currentIncome = incomeDAO.getIncomeByMonth(currentMonth);
        double remainingBudget = currentBudget.getRemaining();

        HomeScreenOutputData outputData = new HomeScreenOutputData(remainingBudget, currentIncome);
        outputBoundary.prepareSuccessView(outputData);
    }
}