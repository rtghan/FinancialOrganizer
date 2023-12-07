package back_end.add_income;

/**
 * An interface that helps process user inputs
 */
public interface AddIncomeInputBoundary {
    void execute(AddIncomeInputData addIncomeInputData);
    void cancel();
}
