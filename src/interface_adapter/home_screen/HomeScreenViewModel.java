package interface_adapter.home_screen;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;

public class HomeScreenViewModel extends ViewModel {

    public static final String HOME_SCREEN_LABEL = "Financial Calendar";
    public static final String ADD_BUDGET_LABEL = "Add Budget";
    public static final String EDIT_BUDGET_LABEL = "Edit Budget";
    public static final String ADD_INCOME_LABEL = "Add Income";
    public static final String ADD_EXPENSE_LABEL = "Add Expense";
    public static final String VIEW_STATISTICS_LABEL = "View Statistics";

    public HomeScreenViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {
        //
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        //
    }
}
