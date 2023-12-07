package interface_adapter.add_income;

import java.time.Month;
import java.time.LocalDateTime;

/**
 * represents the state for add income has getters and setters for all the instance attributes
 */
public class AddIncomeState {
    private String incomeSource = "";
    private double amount;
    private Month month = LocalDateTime.now().getMonth();
    private boolean creationSuccess = false;
    public AddIncomeState(AddIncomeState copy) {
        incomeSource = copy.incomeSource;
        amount = copy.amount;
        month = copy.month;
    }
    public AddIncomeState() {}
    public String getIncome_source() {return incomeSource;}
    public double getAmount() {return amount;}
    public Month getMonth() {return month;}

    public void setMonth(String input) {
        if(input == "Current Month"){
            this.month = LocalDateTime.now().getMonth();
        }
        else {
            this.month = Month.valueOf(input.toUpperCase());
        }
    }

    public boolean isCreationSuccess() {return creationSuccess;}
    public void setCreationSuccess(boolean creationSuccess) {
        this.creationSuccess = creationSuccess;
    }
    public void setIncome_source(String incomeSource) {this.incomeSource = incomeSource;}
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
