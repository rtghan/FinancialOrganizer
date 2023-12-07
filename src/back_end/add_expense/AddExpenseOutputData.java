package back_end.add_expense;

import java.time.LocalDateTime;
import java.time.Month;

public class AddExpenseOutputData {
    final private String category;
    final private double amount;

    final private Month creationMonth;
    public AddExpenseOutputData(String category, double amount, Month creationMonth){
        this.category = category;
        this.amount = amount;
        this.creationMonth = creationMonth;
    }

    public double getAmount() {
        return amount;
    }
}
