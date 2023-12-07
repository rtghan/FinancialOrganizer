package interface_adapter.add_income;

import back_end.add_income.AddIncomeInputBoundary;
import back_end.add_income.AddIncomeInputData;
import java.time.Month;

public class AddIncomeController {
    final AddIncomeInputBoundary addIncomeInteractor;

    public AddIncomeController(AddIncomeInputBoundary interactor){this.addIncomeInteractor = interactor;}

    public void execute(String incomeSource, double amount, Month month){
        AddIncomeInputData inputData = new AddIncomeInputData(incomeSource, amount, month);
        addIncomeInteractor.execute(inputData);
    }
    public void cancel() {addIncomeInteractor.cancel();}
}
