package add_budget.back_end;
import entity.Budget;
public interface AddBudgetDataAccessInterface {
    void save(String monthName, Budget budget);

}
