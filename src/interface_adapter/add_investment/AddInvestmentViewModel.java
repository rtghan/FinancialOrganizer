package interface_adapter.add_investment;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Represents the structure of the view of the AddInvestment use case. When modified, updates the view accordingly.
 */
public class AddInvestmentViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Add Investment";
    public static final String DATE_LABEL = "Date of Purchase: ";
    public static final String QTY_LABEL = "Quantity Purchased: ";
    public static final String NAME_LABEL = "Stock Name: ";
    public static final String ADD_BUTTON = "Add Investment";
    public static final String CANCEL_BUTTON = "Cancel";
    private AddInvestmentState state = new AddInvestmentState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructor for a new AddInvestmentViewModel
     * @param viewName  The name of the view
     */
    public AddInvestmentViewModel(String viewName) {
        super(viewName);
    }

    /**
     * If something has changed in the view model (e.g. the state), then this method will let the view know that
     * something has changed and that it needs to update itself.
     */
    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);
    }

    /**
     * Allows the adding of listeners
     * @param listener  A listener to be added
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }

    /**
     * Get the current state held in the view model
     * @return
     */
    public AddInvestmentState getState(){return this.state;}

    /**
     * Set the state of the view model
     * @param state
     */
    public void setState(AddInvestmentState state){this.state = state;}
}
