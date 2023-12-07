package interface_adapter.investment_value;
import interface_adapter.ViewModel;
import interface_adapter.add_investment.AddInvestmentState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InvestmentValueViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Investment Portfolio Value";
    public static final String START_DATE_LABEL = "Pick how far back you want to view your portfolio's value: ";
    public static final String GRANULARITY_LABEL = "Pick how many times you want to see updates in your portfolio value: ";
    public static final String INITIAL_VAL_LABEL = "The cost of your portfolio: ";
    public static final String DISPLAY_BUTTON = "Display Value";
    public static final String RETURN_BUTTON = "Return";
    private InvestmentValueState state = new InvestmentValueState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public InvestmentValueViewModel(){
        super("InvestmentValue");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }

    public InvestmentValueState getState() {
        return this.state;
    }

    public void setState(InvestmentValueState state) {
        this.state = state;
    }

}
