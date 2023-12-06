package interface_adapter.add_income;

import back_end.add_income.AddIncomeInputBoundary;
import back_end.add_income.AddIncomeInputData;

public class AddIncomeController {
    final AddIncomeInputBoundary addIncomeInteractor;

    public AddIncomeController(AddIncomeInputBoundary interactor){this.addIncomeInteractor = interactor;}

    public void execute(String incomeSource, double ammount){
        AddIncomeInputData inputData = new AddIncomeInputData(incomeSource, ammount);
        addIncomeInteractor.execute(inputData);
    }
}