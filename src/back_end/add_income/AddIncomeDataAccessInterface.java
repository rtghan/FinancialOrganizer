package back_end.add_income;
import entity.Budget;

import java.time.Month;

public interface AddIncomeDataAccessInterface {
    public Budget getBudgetByMonth(Month month);
}
