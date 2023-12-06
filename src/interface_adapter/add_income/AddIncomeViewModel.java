package interface_adapter.add_income;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddIncomeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Add Income View";
    public static final String INCOME_SOURCE_LABEL = "Source of Income: ";
    public static final String AMOUNT_LABLE = "Amount ($): ";
    public static final String ADD_INCOME_BUTTON_LABEL = "Add!";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    private AddIncomeState state = new AddIncomeState();
    public AddIncomeViewModel() {
        super("AddIncome");
    }
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
    public AddIncomeState getState() {return state;}
}
