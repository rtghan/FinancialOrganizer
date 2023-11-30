package data_access;

import entity.Budget;

import java.time.Month;
public interface BudgetDataAccessInterface {
    Budget getBudgetByMonth(Month month);
}

