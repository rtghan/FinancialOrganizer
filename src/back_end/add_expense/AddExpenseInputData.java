package back_end.add_expense;

import java.time.Month;

/**
 * Represents an Expense.
 */
public class AddExpenseInputData{
    final String name;
    final String category;
    final double expenseAmt;
    final Month month;

    /**
     * Constructs Input Data Instance
     * @param name String
     * @param category String
     * @param expenseAmt double
     * @param month Month
     */
    public AddExpenseInputData(String name, String category, double expenseAmt, Month month){
        this.name = name;
        this.category = category;
        this.expenseAmt = expenseAmt;
        this.month = month;
    }

    /**
     * Returns Instance Category
     * @return instance category string
     */
    public String getCategory(){return this.category;}

    /**
     * Returns Instance amount
     * @return instance expense amound double.
     */
    public double getAmount(){return this.expenseAmt;}
    }
