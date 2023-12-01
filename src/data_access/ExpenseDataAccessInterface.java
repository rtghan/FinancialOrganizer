package data_access;

import entity.Expense;
import java.time.Month;

public interface ExpenseDataAccessInterface {
    Expense getExpensesByMonth(Month month);
}
