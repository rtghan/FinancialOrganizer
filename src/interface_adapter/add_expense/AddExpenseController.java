package interface_adapter.add_expense;

import back_end.add_budget.AddBudgetInputData;
import back_end.add_expense.AddExpenseInputBoundary;
import back_end.add_expense.AddExpenseInputData;

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
