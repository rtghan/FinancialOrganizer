package interface_adapter.add_budget;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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

    public AddBudgetViewModel() {
        super("AddBudget");
    }

    public void setState(AddBudgetState state) {
        this.state = state;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public AddBudgetState getState() {
        return state;
    }
}
