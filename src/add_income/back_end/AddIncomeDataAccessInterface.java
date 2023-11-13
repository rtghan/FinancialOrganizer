package add_income.back_end;
import entity.Budget;
import entity.Income;

import java.time.Month;

public interface AddIncomeDataAccessInterface {
    public Budget getBudget(Month month);
}
