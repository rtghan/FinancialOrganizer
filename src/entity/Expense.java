package entity;

import java.time.Month;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Entity that represents expense
 */
public class Expense {
    private static ArrayList<String> categoryList = new ArrayList<String>();
    private String category;
    private double amount;
    private Month month;

    /**
     * construct entity expense with specified:
     * @param category  expense category
     * @param amount    expense amount
     * @param month      month of expense
     */
    public Expense(String category, double amount, Month month) {
        this.category = category;
        this.amount = amount;
        this.month = month;
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