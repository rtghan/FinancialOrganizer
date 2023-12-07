package interface_adapter.add_income;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * class that extends view model to work for the add income usecase
 */
public class AddIncomeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Add Income View";
    public static final String INCOME_SOURCE_LABEL = "Source of Income: ";
    public static final String AMOUNT_LABLE = "Amount ($): ";
    public static final String ADD_INCOME_BUTTON_LABEL = "Add!";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    private AddIncomeState state = new AddIncomeState();

    /**
     * constructor that calls the super class constructor
     */
    public AddIncomeViewModel() {
        super("AddIncome");
    }

    /**
     * setter for the state
     * @param state AddIncomeState
     */
    public void setState(AddIncomeState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * getter for the state of this view model
     * @return the state
     */
    public AddIncomeState getState() {return state;}
}
