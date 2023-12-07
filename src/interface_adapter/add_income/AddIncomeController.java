package interface_adapter.add_income;

import back_end.add_income.AddIncomeInputBoundary;
import back_end.add_income.AddIncomeInputData;
import java.time.Month;

/**
 * used to produce input data for the interactor
 */
public class AddIncomeController {
    final AddIncomeInputBoundary addIncomeInteractor;

    /**
     * constructor for the class
     * @param interactor AddIncomeInputBoundary
     */
    public AddIncomeController(AddIncomeInputBoundary interactor){this.addIncomeInteractor = interactor;}

    /**
     * creates a new input data using the given parameters and passes it to the execute method in the interactor
     * @param incomeSource String
     * @param ammount Double
     */
    public void execute(String incomeSource, double amount, Month month){
        AddIncomeInputData inputData = new AddIncomeInputData(incomeSource, amount, month);
        addIncomeInteractor.execute(inputData);
    }

    /**
     * calls the cancel method from the interactor
     */
    public void cancel() {addIncomeInteractor.cancel();}
}
