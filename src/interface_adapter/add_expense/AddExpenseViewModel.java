package interface_adapter.add_expense;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Class implementation of ViewModel for addExpense.
 */
public class AddExpenseViewModel extends ViewModel {

    public static final String TITLE = "Add Expense";
    public static final String ADD_BUTTON_LABEL = "Add";
    public static final String NAME_TEXT_LABEL = "Name";
    public static final String CATEGORY_TEXT_LABEL = "Category";
    public static final String AMT_TEXT_LABEL = "Amount";
    public static final String  CANCEL_BUTTON_LABEL = "Cancel";
    public static final String MONTH_LABEL = "Select Month of Expense: ";

    public static final String[] MONTH_COMBO = {"Current Month", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "December"};
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private AddExpenseState state = new AddExpenseState();

    /**
     * Constructs an instance of AddExpenseViewModel
     * @param viewName String
     */
    public AddExpenseViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }

    /**
     * Gets the current state
     * @return AddExpenseState
     */
    public AddExpenseState getState(){return this.state;}

    /**
     * Sets the current state to input
     * @param state AddExpenseState
     */
    public void setState(AddExpenseState state){this.state = state;}
}
