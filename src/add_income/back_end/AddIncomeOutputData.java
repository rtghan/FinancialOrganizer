package add_income.back_end;

import java.time.LocalDateTime;

public class AddIncomeOutputData {
    final private String incomeSource;
    final private double amount;
    final private LocalDateTime date;

    public AddIncomeOutputData(String incomeSource, double amount, LocalDateTime date) {
        this.incomeSource = incomeSource;
        this.amount = amount;
        this.date = date;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    double getAmount(){
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
