package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Income {
    private String incomeSource;
    private double amount;
    private LocalDateTime date;

    public Income(String incomeSource, double amount, LocalDateTime date) {
        this.incomeSource = incomeSource;
        this.amount = amount;
        this.date = date;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public String getIncomeSource() {
        return incomeSource;
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
