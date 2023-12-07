package interface_adapter.add_budget;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * A class that holds the contents of what the view should be displaying. Listens to the AddBudgetState, so that when
 * there are changes in state, the VM can update accordingly so the viewer can see in the view what is going on.
 */
public class AddBudgetViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Add Budget View";
    public static final String[] TIME_OPTIONS = {"Current Month", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "December"};
    public static final String TIME_LABEL = "Budget for the Month of: ";
    public static final String SAVE_LABEL = "Saving Target ($): ";
    public static final String INVESTMENT_LABEL = "Investment Target ($): ";
    public static final String SPEND_LABEL = "Spending Target ($): ";

    public static final String ADD_BUDGET_BUTTON_LABEL = "Add!";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private AddBudgetState state = new AddBudgetState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Contructor for a new AddBudgetViewModel with a name of AddBudget
     */
    public AddBudgetViewModel() {
        super("AddBudget");
    }

    /**
     * Updates the state held by the viewModel to a new one
     * @param state     The new state that the viewMoel will hold
     */
    public void setState(AddBudgetState state) {
        this.state = state;
    }

    /**
     * When called, will prompt all the listeners to do something, such as the view updating itself to reflect the changed
     * viewmodel.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Add listeners to this class
     * @param listener  A listener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieve the state currently held by the viewmodel.
     * @return
     */
    public AddBudgetState getState() {
        return state;
    }
}
