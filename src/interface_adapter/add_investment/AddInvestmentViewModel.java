package interface_adapter.add_investment;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class AddInvestmentViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Add Investment";
    public static final String DATE_LABEL = "Date of Purchase: ";
    public static final String QTY_LABEL = "Quantity Purchased: ";
    public static final String NAME_LABEL = "Stock Name: ";
    private AddInvestmentState state = new AddInvestmentState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public AddInvestmentViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }
    public AddInvestmentState getState(){return this.state;}

    public void setState(AddInvestmentState state){this.state = state;}
}
