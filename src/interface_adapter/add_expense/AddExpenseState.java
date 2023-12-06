package interface_adapter.add_expense;

public class AddExpenseState {
    private String name;
    private String category;
    private double amt;
    private boolean popup = false;

    public void setName(String input){
        this.name = input;
    }
    public void setCategory(String input){
        this.category = input;
    }
    public void setAmt(double input){
        this.amt = input;
    }

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
