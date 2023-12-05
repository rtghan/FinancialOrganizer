package interface_adapter.home_screen;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HomeScreenViewModel extends ViewModel {

    public static final String HOME_SCREEN_LABEL = "Financial Calendar";
    public static final String ADD_EDIT_BUDGET_LABEL = "Add/Edit Budget";
    public static final String ADD_INCOME_LABEL = "Add Income";
    public static final String ADD_EXPENSE_LABEL = "Add Expense";
    public static final String[] TIME_OPTIONS = {"Current Month", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "December"};

    private HomeScreenState state = new HomeScreenState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public HomeScreenViewModel() {
        super("HomeScreen");
    }

    public void setState(HomeScreenState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public HomeScreenState getState() {
        return state;
    }
}
