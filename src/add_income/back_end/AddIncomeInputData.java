package add_income.back_end;

public class AddIncomeInputData {
    final private String incomeSource;
    final private double amount;

    public AddIncomeInputData(String incomeSource, double amount) {
        this.incomeSource = incomeSource;
        this.amount = amount;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    double getAmount(){
        return amount;
    }
}
