package interface_adapter.add_expense;

import back_end.add_expense.AddExpenseOutputBoundary;
import back_end.add_expense.AddExpenseOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenState;
import interface_adapter.home_screen.HomeScreenViewModel;
import view.AddExpenseView;

/**
 * Class implementation of AddExpenseOutputBoundary
 * For moving output data to view.
 */

public class AddExpensePresenter implements AddExpenseOutputBoundary {
    private final ViewManagerModel viewMM;
    private final AddExpenseViewModel expenseVM;
    private final HomeScreenViewModel HSVM;

    /**
     * Creates an instance of AddExpensePresenter
     * @param expenseVM ViewManagerModel
     * @param viewMM AddExpenseViewModel
     * @param HSVM HomeScreenViewModel
     */
    public AddExpensePresenter(AddExpenseViewModel expenseVM, ViewManagerModel viewMM, HomeScreenViewModel HSVM) {
        this.expenseVM = expenseVM;
        this.viewMM = viewMM;
        this.HSVM = HSVM;
    }

    /**
     * Takes in output data and passes it to view model to prepare a success view
     * @param addExpenseOutputData AddExpenseOutputData
     */
    @Override
    public void prepareSuccessView(AddExpenseOutputData addExpenseOutputData) {
        AddExpenseState state = expenseVM.getState();
        state.setPopup(true);
        this.expenseVM.setState(state);
        expenseVM.firePropertyChanged();

        // update the values on the home screen
        HSVM.update();

        this.viewMM.setActiveView(HSVM.getViewName());
        this.viewMM.firePropertyChanged();
    }

    /**
     * Ignores any outdata and return to homescreen
     */
    @Override
    public void cancel(){
        this.viewMM.setActiveView(HSVM.getViewName());
        this.viewMM.firePropertyChanged();
    }

    /**
     * For the event where the selected month has no budget
     * and prepares popup
     */
    @Override
    public void noBudget() {
        AddExpenseState state = expenseVM.getState();
        state.setPopup(false);
        this.expenseVM.setState(state);
        expenseVM.firePropertyChanged();
    }
}
