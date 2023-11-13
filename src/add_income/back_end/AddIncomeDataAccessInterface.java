package add_income.back_end;
import entity.Budget;
import entity.Income;

import java.time.Month;

public interface AddIncomeDataAccessInterface {
    void save(Income incomeSource);
    public Budget getBudget(Month month);
}
