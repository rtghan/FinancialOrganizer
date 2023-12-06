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
        LocalDateTime date = LocalDateTime.now();
        Month monthName = LocalDateTime.now().getMonth();
        Budget budget = incomeDAO.getBudgetByMonth(monthName);
        Income newIncome = new Income(inputData.getIncomeSource(), inputData.getAmount(), date);

        if (budget != null){
            budget.addIncome(newIncome);
            AddIncomeOutputData outputData = new AddIncomeOutputData(
                    inputData.getIncomeSource(), inputData.getAmount(), date
            );
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
