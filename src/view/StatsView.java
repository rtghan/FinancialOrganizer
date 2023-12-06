package view;

import chart_visualisation.StatsViewModel;
import interface_adapter.ViewManagerModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StatsView extends JPanel implements ActionListener, PropertyChangeListener{
    private final StatsViewModel statsViewModel;
    private final ViewManagerModel viewManagerModel;
    public StatsView(StatsViewModel statsViewModel, ViewManagerModel viewModelManager){
        this.statsViewModel = statsViewModel;
        this.viewManagerModel = viewModelManager;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
