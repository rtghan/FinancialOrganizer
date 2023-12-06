package add_expense.back_end;

import add_budget.back_end.AddBudgetInputData;

import java.time.LocalDateTime;

public class AddExpenseInputData{
    final String name;
    final String category;
    final double expenseAmt;


    public AddExpenseInputData(String name, String category, double expenseAmt){
        this.name = name;
        this.category = category;
        this.expenseAmt = expenseAmt;
    }

    public String getCategory(){return this.category;}
    public double getAmount(){return this.expenseAmt;}
    }
