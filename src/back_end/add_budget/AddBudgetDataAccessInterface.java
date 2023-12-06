package back_end.add_budget;
import entity.Budget;
import java.time.Month;
public interface AddBudgetDataAccessInterface {
    void save(Month month, Budget budget);

}
