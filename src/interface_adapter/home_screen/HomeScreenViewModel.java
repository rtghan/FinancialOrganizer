package interface_adapter.home_screen;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * view model representation for home screen
 */
public class HomeScreenViewModel extends ViewModel {

    // label names for buttons, labels, etc. on screen
    public static final String HOME_SCREEN_LABEL = "Financial Calendar";
    public static final String ADD_EDIT_BUDGET_LABEL = "Add/Edit Budget";
    public static final String ADD_INCOME_LABEL = "Add Income";
    public static final String ADD_EXPENSE_LABEL = "Add Expense";
    public static final String ADD_INVESTMENT_LABEL = "Add Investment";
    public static final String[] TIME_OPTIONS = {"Current Month", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "December"};

    private HomeScreenState state = new HomeScreenState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * default constructor for home screen view model
     */
    public HomeScreenViewModel() {
        super("HomeScreen");
    }

    /**
     * sets the state for the view model
     * @param state
     */
    public void setState(HomeScreenState state) {
        HomeScreenState oldState = this.state; //
        this.state = state;
        support.firePropertyChange("state", oldState, state); //
    }

    /**
     * fires property change event to update the view
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * fires property change event to update the view
     */
    public void update() {
        support.firePropertyChange("viewUpdate", null, this.state);
    }

    /**
     * add property change listener
     * @param listener
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * gets the current home state for view model
     * @return
     */
    public HomeScreenState getState() {
        return state;
    }
}
