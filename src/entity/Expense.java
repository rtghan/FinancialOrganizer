package entity;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Expense {
    private static ArrayList<String> categoryList = new ArrayList<String>();
    private String category;
    private double amount;
    private LocalDateTime date;

    public Expense(String category, double amount, LocalDateTime date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        /*
        // if the category has never been used, adds it to the list of categories
        if (!categoryList.contains(category)) {
            categoryList.add(category);
        }*/
    }

    //to get a full list of all categories used, call Expense.getCategoryList()
    public static ArrayList<String> getCategoryList() {
        return categoryList;
    }

    //for when the user changes the category
    public void setCategory(String category) {
        this.category = category;
        /*
        if (!categoryList.contains(category)) {
            categoryList.add(category);
        }*/
    }

    public String getCategory() {
        return category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}