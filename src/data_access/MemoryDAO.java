package data_access;
import entity.Budget;
import add_budget.back_end.AddBudgetDataAccessInterface;
import java.util.HashMap;
import java.util.Map;
import java.time.Month;
public class MemoryDAO implements AddBudgetDataAccessInterface{
    private final Map<Month, Budget> budgets = new HashMap<>();

    // can use default constructor, so don't need to write a specific one

    @Override
    public void save(Month month, Budget budget){
        budgets.put(month, budget);
    }
}
