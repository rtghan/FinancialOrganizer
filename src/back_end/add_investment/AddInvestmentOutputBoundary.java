package back_end.add_investment;

public interface AddInvestmentOutputBoundary {
    void prepareSuccessView(AddInvestmentOutputData outputData);
    void cancel();
}
