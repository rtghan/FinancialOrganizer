package interface_adapter.add_expense;

import back_end.add_expense.AddExpenseInputBoundary;
import back_end.add_expense.AddExpenseInputData;

import java.time.Month;

/**
 * Constructs input data for addExpense
 */
public class AddExpenseController{
    final AddExpenseInputBoundary expenseIB;

    /**
     * Creates an instance of AddExpense Controller
     * @param expenseIB
     */
    public AddExpenseController(AddExpenseInputBoundary expenseIB){
        this.expenseIB = expenseIB;
    }

    /**
     * Takes in relevant data and packages it as AddExpenseInputData
     * then send data to AddExpenseInputBoundary
     *
     * @param name String
     * @param cate String
     * @param amt double
     * @param month Month
     */
    public void execute(String name, String cate, double amt, Month month){
        AddExpenseInputData inputData = new AddExpenseInputData(name, cate, amt, month);
        expenseIB.execute(inputData);
    }

    /**
     * Ignores any input.
     */
    public void cancel(){
        expenseIB.cancel();
    }
}
