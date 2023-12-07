package back_end.add_expense;

import java.time.Month;

public class AddExpenseInputData{
    final String name;
    final String category;
    final double expenseAmt;
    final Month month;


    public AddExpenseInputData(String name, String category, double expenseAmt, Month month){
        this.name = name;
        this.category = category;
        this.expenseAmt = expenseAmt;
        this.month = month;
    }

    public String getCategory(){return this.category;}
    public double getAmount(){return this.expenseAmt;}
    }
