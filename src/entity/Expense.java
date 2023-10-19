package entity;

import java.time.LocalDateTime;

public class Expense implements FinancialEvent{
    private String category = null;
    private double amount = 0;
    private LocalDateTime date;

    public Expense(LocalDateTime date){
        this.date = date;
    }

    @Override
    public void setAmount(double amount){
        this.amount = amount;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public double getAmount(){
        return this.amount;
    }

    @Override
    public String getCategory() {
        return this.category;
    }
}
