package interface_adapter.add_income;

import java.time.LocalDateTime;

public class AddIncomeState {
    private String incomeSource = "";
    private double amount = 0;
    private LocalDateTime date;
    private boolean creationSuccess = false;
    public AddIncomeState(AddIncomeState copy) {
        incomeSource = copy.incomeSource;
        amount = copy.amount;
        date = copy.date;
    }
    public AddIncomeState() {}
    public String getIncome_source() {return incomeSource;}
    public double getAmount() {return amount;}
    public LocalDateTime getDate() {return date;}
    public boolean isCreationSuccess() {return creationSuccess;}
    public void setCreationSuccess(boolean creationSuccess) {
        this.creationSuccess = creationSuccess;
    }
    public void setIncome_source(String incomeSource) {this.incomeSource = incomeSource;}
    public void setAmount(double Amount) {this.amount = amount;}

}
