package back_end.chart_visualisation;

import back_end.add_budget.AddBudgetDataAccessInterface;
import back_end.add_budget.AddBudgetOutputBoundary;
import back_end.home_screen.HomeScreenDataAccessInterface;
import back_end.home_screen.HomeScreenOutputBoundary;
import entity.Budget;
import entity.Expense;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

public class ChartInteractor implements ChartInputBoundary {
    final private HomeScreenDataAccessInterface DAO;
    final private HomeScreenOutputBoundary chartPresenter;
    public ChartInteractor(HomeScreenDataAccessInterface DAO, HomeScreenOutputBoundary chartPresenter) {
        this.DAO = DAO;
        this.chartPresenter = chartPresenter;
    }
    @Override
    public void execute(ChartInputData chartInputData) {
        // Get Current Month's Budget
        Budget currBudget = DAO.getBudgetByMonth(chartInputData.getMonth());

        // Get List of Expenses of Budget
        ArrayList<Expense> expenseList = currBudget.getExpensesList();

        // Outdata construction
        HashMap<String, Double> outMap = new HashMap<>();

        for(Expense entry:expenseList){
            String category = entry.getCategory();
            System.out.println(entry.getCategory());
            double amount = entry.getAmount();
            if(!outMap.containsKey(category)){
                outMap.put(category, amount);
            }
            double newAmt = outMap.get(category) + amount;
            outMap.put(category, newAmt);
        }
        ChartOutputData outputData = new ChartOutputData(outMap);
        chartPresenter.preparePopup(outputData);
    }
}
