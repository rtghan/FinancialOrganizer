package interface_adapter.add_expense;

import java.time.LocalDateTime;
import java.time.Month;

public class AddExpenseState {
    private String name;
    private String category;
    private double amt;
    private boolean popup = false;
    private Month month;

    public void setMonth(String input){
        if(input == "Current Month"){
            this.month = LocalDateTime.now().getMonth();
        }
        else {
            this.month = Month.valueOf(input.toUpperCase());
        }
        System.out.println(this.month.toString());
    }
    public void setName(String input){
        this.name = input;
    }
    public void setCategory(String input){
        this.category = input;
    }
    public void setAmt(double input){
        this.amt = input;
    }

    public Month getMonth(){return this.month;}
    public String getName(){
        return this.name;
    }

    public double getAmt() {
        return amt;
    }

    public String getCategory() {
        return category;
    }

    public boolean popup(){
        return this.popup;
    }
    public void setPopup(boolean popup){this.popup = popup;}
}
