package interface_adapter.add_expense;

import back_end.add_expense.AddExpenseOutputBoundary;
import back_end.add_expense.AddExpenseOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenState;
import interface_adapter.home_screen.HomeScreenViewModel;
import view.AddExpenseView;

public class AddExpensePresenter implements AddExpenseOutputBoundary {
    private final ViewManagerModel viewMM;
    private final AddExpenseViewModel expenseVM;
    private final HomeScreenViewModel HSVM;

    public AddExpensePresenter(AddExpenseViewModel expenseVM, ViewManagerModel viewMM, HomeScreenViewModel HSVM) {
        this.expenseVM = expenseVM;
        this.viewMM = viewMM;
        this.HSVM = HSVM;
    }

    @Override
    public void prepareSuccessView(AddExpenseOutputData addExpenseOutputData) {
        AddExpenseState state = expenseVM.getState();
        state.setPopup(true);
        this.expenseVM.setState(state);
        expenseVM.firePropertyChanged();

        // update the values on the home screen
        HomeScreenState homeState = HSVM.getState();
        homeState.setCreationSuccess(true);
        homeState.setTotalExpenses(homeState.getTotalExpenses() + addExpenseOutputData.getAmount());
        homeState.setRemainingBudget(homeState.getRemainingBudget() - addExpenseOutputData.getAmount());
        HSVM.setState(homeState);
        HSVM.firePropertyChanged();

        this.viewMM.setActiveView(HSVM.getViewName());
        this.viewMM.firePropertyChanged();
    }
    @Override
    public void cancel(){
        this.viewMM.setActiveView(HSVM.getViewName());
        this.viewMM.firePropertyChanged();
    }
}
