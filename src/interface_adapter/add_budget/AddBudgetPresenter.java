package interface_adapter.add_budget;

import add_budget.back_end.AddBudgetOutputBoundary;
import add_budget.back_end.AddBudgetOutputData;
import interface_adapter.add_budget.AddBudgetViewModel;
import interface_adapter.add_budget.AddBudgetState;

public class AddBudgetPresenter implements AddBudgetOutputBoundary{
    private final AddBudgetViewModel abVM;
    public AddBudgetPresenter(AddBudgetViewModel abVM) {
        this.abVM = abVM;
    }
    @Override
    public void prepareSuccessView(AddBudgetOutputData outputData) {
        AddBudgetState state = abVM.getState();
        state.setCreationSuccess(true);
        this.abVM.setState(state);
        abVM.firePropertyChanged();

        // TODO: on success, switch to the view stats/homescreen panel
    }
}
