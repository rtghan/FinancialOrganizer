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
        Month inputMonth = chartInputData.getMonth();
        Budget currBudget = DAO.getBudgetByMonth(chartInputData.getMonth());
        ArrayList<Expense> expenseList = currBudget.getExpensesList();
        HashMap<String, Double> outMap = new HashMap<String, Double>();
        for(Expense entry:expenseList){
            String category = entry.getCategory();
            if(!outMap.containsKey(category)){
                outMap.put(category, entry.getAmount());
            }else{
                double amt = outMap.get(category) + entry.getAmount();
                outMap.put(category, amt);
            }
        }
        ChartOutputData outputData = new ChartOutputData(outMap);
        chartPresenter.preparePopup(outputData);
    }
}
