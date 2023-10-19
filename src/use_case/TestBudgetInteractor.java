package use_case;

import entity.Budget;
import entity.Expense;

import java.time.LocalDateTime;

public class TestBudgetInteractor implements TestBudgetBoundry {
    Budget budget;
    @Override
    public void execute(LocalDateTime date) {
        this.budget.addExpense(new Expense(LocalDateTime.now()));
    }
}
