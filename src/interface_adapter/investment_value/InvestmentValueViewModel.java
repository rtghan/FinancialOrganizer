package interface_adapter.investment_value;
import interface_adapter.ViewModel;
import interface_adapter.add_investment.AddInvestmentState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Represents the structure of the InvestmentValue view, and once changed, will update the view so that it reflects the
 * model accordingly.
 */
public class InvestmentValueViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Investment Portfolio Value";
    public static final String START_DATE_LABEL = "Pick how far back you want to view your portfolio's value: ";
    public static final String GRANULARITY_LABEL = "Pick how many times you want to see updates in your portfolio value: ";
    public static final String INITIAL_VAL_LABEL = "The cost of your portfolio: ";
    public static final String DISPLAY_BUTTON = "Display Value";
    public static final String RETURN_BUTTON = "Return";
    private InvestmentValueState state = new InvestmentValueState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructor for a new InvestmentValueViewModel
     */
    public InvestmentValueViewModel(){
        super("InvestmentValue");
    }

    /**
     * Prompts any listening classes to change/update, such as the view
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Lets other classes listen to this class, so that when this class updates, they will be notified
     * @param listener  The class that will be added to the listeners of this class
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }

    /**
     * Get the current state held by the model
     * @return
     */
    public InvestmentValueState getState() {
        return this.state;
    }

    /**
     * Set the current state held by the model
     * @param state
     */
    public void setState(InvestmentValueState state) {
        this.state = state;
    }

}
