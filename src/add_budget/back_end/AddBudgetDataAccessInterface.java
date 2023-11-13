package add_budget.back_end;
import entity.Budget;
import java.time.Month;
public interface AddBudgetDataAccessInterface {
    void save(Month month, Budget budget);

}
