package back_end.add_income;

import java.time.Month;

public class AddIncomeOutputData {
    final private String incomeSource;
    final private double amount;
    final private Month month;

    public AddIncomeOutputData(String incomeSource, double amount, Month month) {
        this.incomeSource = incomeSource;
        this.amount = amount;
        this.month = month;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    double getAmount(){
        return amount;
    }

    public Month getMonth() {
        return month;
    }
}
