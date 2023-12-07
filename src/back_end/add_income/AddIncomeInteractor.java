package back_end.add_income;

import java.time.LocalDateTime;
import java.time.Month;
import entity.Budget;
import entity.Income;

public class AddIncomeInteractor implements AddIncomeInputBoundary{
    final private AddIncomeDataAccessInterface incomeDAO;
    final private AddIncomeOutputBoundary incomePresenter;
    public AddIncomeInteractor(AddIncomeDataAccessInterface incomeDAO, AddIncomeOutputBoundary incomePresenter){
        this.incomeDAO = incomeDAO;
        this.incomePresenter = incomePresenter;
    }

    @Override
    public void execute(AddIncomeInputData inputData){
        // get the day this income was input
        // LocalDateTime date = LocalDateTime.now();
        Month month = inputData.getMonth();
        Budget budget = incomeDAO.getBudgetByMonth(month);
        Income newIncome = new Income(inputData.getIncomeSource(), inputData.getAmount(), month);

        if (budget != null){
            budget.addIncome(newIncome);
            AddIncomeOutputData outputData = new AddIncomeOutputData(
                    inputData.getIncomeSource(), inputData.getAmount(), month);
            incomePresenter.prepareSuccessView(outputData);
        }
        else {
            System.out.println("Error! No budget was found to add this income to.");
            incomePresenter.noBudget();
        }
    }
    @Override
    public void cancel() {incomePresenter.cancel();}
}
