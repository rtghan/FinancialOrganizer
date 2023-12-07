package view;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddInvestmentView extends JPanel implements ActionListener, PropertyChangeListener {
    private JDatePicker datePicker;

    public AddInvestmentView() {
        UtilDateModel model = new UtilDateModel();
        JDatePanel datePanel = new JDatePanel(model);
        datePicker = new JDatePicker();
        this.add(datePicker);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
