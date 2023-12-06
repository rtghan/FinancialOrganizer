package interface_adapter.add_expense;

import add_budget.back_end.AddBudgetInputData;
import add_expense.back_end.AddExpenseInputBoundary;
import add_expense.back_end.AddExpenseInputData;

public class AddExpenseController{
    final AddExpenseInputBoundary expenseIB;
    public AddExpenseController(AddExpenseInputBoundary expenseIB){
        this.expenseIB = expenseIB;
    }
    public void execute(String name, String cate, double amt){
        AddExpenseInputData inputData = new AddExpenseInputData(name, cate, amt);
        expenseIB.execute(inputData);
    }
    public void cancel(){
        expenseIB.cancel();
    }
}
