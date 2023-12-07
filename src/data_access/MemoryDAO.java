package data_access;
import back_end.add_budget.AddBudgetDataAccessInterface;
import back_end.add_income.AddIncomeDataAccessInterface;
import back_end.add_expense.AddExpenseDataAccessInterface;
import back_end.add_investment.AddInvestmentDataAccessInterface;
import back_end.home_screen.HomeScreenDataAccessInterface;
import entity.Budget;
import entity.Expense;
import entity.Investment;
import entity.Investments;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class MemoryDAO implements AddBudgetDataAccessInterface, AddIncomeDataAccessInterface,
        AddExpenseDataAccessInterface, HomeScreenDataAccessInterface, AddInvestmentDataAccessInterface {
    private final Map<Month, Budget> budgetMap;
    private Investments investments;
    /**
     * constructs memory-based DAO with a hashmap
     */
    public MemoryDAO() {
        this.budgetMap = new HashMap<>();
        this.investments = new Investments();
    }

    /**
     * gets the budget by the specified month
     * @param month     month
     * @return          budget for month
     */
    @Override
    public Budget getBudgetByMonth(Month month) {
        //System.out.println(budgetMap.get(month));
        return budgetMap.get(month);
    }

    /**
     * Saves a given budget to the specified month
     * @param month
     * @param budget
     */
    @Override
    public void save(Month month, Budget budget) {
        budgetMap.put(month, budget);
    }

    @Override
    public Investments getInvestments() {
        return investments;
    }

    @Override
    public void save(Investments investments) {
        this.investments = investments;

        String currInvestments = "";
        for (Investment investment: this.investments.investments) {
            currInvestments += investment.getStockName() + " " + investment.getQty() + " ";
        }
        System.out.println("Current saved investments: " + currInvestments);
    }
}
