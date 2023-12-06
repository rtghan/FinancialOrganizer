package entity;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Entity that represents expense
 */
public class Expense {
    private static ArrayList<String> categoryList = new ArrayList<String>();
    private String category;
    private double amount;
    private LocalDateTime date;

    /**
     * construct entity expense with specified:
     * @param category  expense category
     * @param amount    expense amount
     * @param date      date of expense
     */
    public Expense(String category, double amount, LocalDateTime date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    /**
     * gets the category of the expense
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * gets the amount of the expense
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

}