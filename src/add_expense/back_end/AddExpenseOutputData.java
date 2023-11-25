package add_expense.back_end;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddExpenseOutputData {
    final private String category;
    final private double amount;
    final private LocalDateTime creationTime;
    public AddExpenseOutputData(String category, double amount, LocalDateTime creationTime){
        this.category = category;
        this.amount = amount;
        this.creationTime = creationTime;
    }
}
