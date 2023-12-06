package back_end.add_expense;

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
