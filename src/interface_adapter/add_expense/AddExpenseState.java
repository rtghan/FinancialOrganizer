package interface_adapter.add_expense;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Represents the current state of the view and its data
 * with getters and setters
 */
public class AddExpenseState {
    private String name;
    private String category;
    private double amt;
    private boolean popup = false;
    private Month month = LocalDateTime.now().getMonth();

    /**
     * Sets the Instance month to given input
     * @param input String
     */
    public void setMonth(String input){
        if(input == "Current Month"){
            this.month = LocalDateTime.now().getMonth();
        }
        else {
            this.month = Month.valueOf(input.toUpperCase());
        }
        System.out.println(this.month.toString());
    }

    /**
     * Sets the Instance name to given input
     * @param input String
     */
    public void setName(String input){
        this.name = input;
    }

    /**
     * Sets the Instance category to given input
     * @param input String
     */
    public void setCategory(String input){
        this.category = input;
    }


    /**
     * Sets the Instance amt to given input
     * @param input double
     */
    public void setAmt(double input){
        this.amt = input;
    }

    /**
     * Gets the Instance month
     */
    public Month getMonth(){return this.month;}

    /**
     * Gets the Instance name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the Instance amount
     */

    public double getAmt() {
        return amt;
    }

    /**
     * Gets the Instance category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the current popup state
     */
    public boolean popup(){
        return this.popup;
    }

    /**
     * Sets the popup state to given input
     * @param popup boolean
     */
    public void setPopup(boolean popup){this.popup = popup;}
}
