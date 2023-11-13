package add_budget.data_access;
import entity.Budget;
import add_budget.back_end.AddBudgetDataAccessInterface;
import java.util.HashMap;
import java.util.Map;
public class MemoryDAO implements AddBudgetDataAccessInterface{
    private final Map<String, Budget> budgets = new HashMap<>();

    // can use default constructor, so don't need to write a specific one

    @Override
    public void save(String monthName, Budget budget){
        budgets.put(monthName, budget);
    }
}
