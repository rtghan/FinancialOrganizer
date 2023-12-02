package interface_adapter.add_income;

import add_income.back_end.AddIncomeInputBoundary;
import add_income.back_end.AddIncomeInputData;

public class AddIncomeController {
    final AddIncomeInputBoundary addIncomeInteractor;

    public AddIncomeController(AddIncomeInputBoundary interactor){this.addIncomeInteractor = interactor;}

    public void execute(String incomeSource, double ammount){
        AddIncomeInputData inputData = new AddIncomeInputData(incomeSource, ammount);
        addIncomeInteractor.execute(inputData);
    }
}
