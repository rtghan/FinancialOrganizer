package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TestViewModel extends ViewModel{

    private TestState state = new TestState();


    public TestViewModel(){super("test");}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void setState(TestState state){ this.state = state;}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public TestState getState(){
        return this.state;
    }
}
