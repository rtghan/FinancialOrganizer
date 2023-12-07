package back_end.add_investment;

public interface AddInvestmentInputBoundary {
    void execute(AddInvestmentInputData addInvestmentInputData);
    void cancel();
}
