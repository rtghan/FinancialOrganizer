package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class ViewManagerModel {
    private String activeView;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public String getActiveView() {
        return activeView;
    }

    /**
     * Use this to change the current displayed view
     */
    public void setActiveView(String newView) {
        this.activeView = newView;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeView);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
