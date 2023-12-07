package view;

import interface_adapter.investment_value.InvestmentValueController;
import interface_adapter.investment_value.InvestmentValueState;
import interface_adapter.investment_value.InvestmentValueViewModel;
import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.List;

public class InvestmentValueView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "InvestmentValue";
    private final InvestmentValueViewModel invValVM;
    private final InvestmentValueController invValCont;
    private final JDatePicker datePicker;
    private final JTextField granularityField = new JTextField(15);
    private final JLabel initialValue = new JLabel();
    private final JButton returnHome;
    private final JButton displayValue;
    private final JPanel investmentValueTable = new JPanel();
    public InvestmentValueView(InvestmentValueController invValController, InvestmentValueViewModel invValViewModel) {
        this.invValCont = invValController;
        this.invValVM = invValViewModel;

        JLabel title = new JLabel(InvestmentValueViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // set up input panels
        datePicker = new JDatePicker();
        LabelPanel dateInfo = new LabelPanel(new JLabel(InvestmentValueViewModel.START_DATE_LABEL), datePicker);
        LabelPanel granularityInfo = new LabelPanel(new JLabel(InvestmentValueViewModel.GRANULARITY_LABEL), granularityField);
        LabelPanel initialValueInfo = new LabelPanel(new JLabel(InvestmentValueViewModel.INITIAL_VAL_LABEL), initialValue);

        // add action/key listeners
        datePicker.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().getClass() == JDatePanel.class) {
                            // get the date from the datePicker object, and parse it into a LocalDate object
                            InvestmentValueState currState = invValVM.getState();
                            Calendar selectedValue = (Calendar) datePicker.getModel().getValue();
                            LocalDate selectedDate = selectedValue.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                            // update the state, and save it to the ViewModel
                            System.out.println("Date has been chosen: " + selectedDate.toString());
                            currState.setStartDate(selectedDate);
                            invValVM.setState(currState);
                        }
                    }
                }
        );
        granularityField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        InvestmentValueState currState = invValVM.getState();
                        String text = granularityField.getText() + e.getKeyChar();
                        currState.setGranularity(Integer.parseInt(text));
                        invValVM.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        // configure buttons
        JPanel buttons = new JPanel();
        returnHome = new JButton(InvestmentValueViewModel.RETURN_BUTTON);
        displayValue = new JButton(InvestmentValueViewModel.DISPLAY_BUTTON);
        buttons.add(returnHome);
        buttons.add(displayValue);

        // add actionListeners to buttons
        returnHome.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(returnHome)) {
                            System.out.println("Returning to homescreen.");
                             invValCont.returnHome();
                        }
                    }
                }
        );

        displayValue.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(displayValue)) {
                            System.out.println("Display investment value clicked.");
                            InvestmentValueState currState = invValVM.getState();
                            invValCont.getValueOverTime(LocalDate.now(), currState.getGranularity());
                        }
                    }
                }
        );

        // add all buttons and panels
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(dateInfo);
        this.add(granularityInfo);
        this.add(initialValueInfo);
        this.add(investmentValueTable);
        this.add(buttons);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // write the data to the table
        Object response = evt.getNewValue();
        if (response.getClass() == InvestmentValueState.class) {
            InvestmentValueState state = (InvestmentValueState) response;

            // set default popup message
            String popup = state.getErrorString();

            // update the initial value first
            initialValue.setText(Double.toString(state.getInitialValue()));

            // get the data from the state
            Map<LocalDate, Double> investmentValues = state.getInvestmentValues();
            // first sort by dates
            Set<LocalDate> dates = investmentValues.keySet();
            ArrayList<LocalDate> dateList = new ArrayList<>(dates);
            Collections.sort(dateList);

            // clear old table data
            investmentValueTable.removeAll();

            // create the parameters for table construction
            Object[][] tableData = new Object[dateList.size()][2];
            for (int i = 0; i < dateList.size(); i++) {
                tableData[i][0] = dateList.get(i).toString();
                tableData[i][1] = investmentValues.get(dateList.get(i));
            }
            System.out.println(tableData);
            Object[] columnNames = {"Date", "Value"};

            // create table and add it to the panel
            JTable dataTable = new JTable(tableData, columnNames);
            investmentValueTable.add(dataTable);
            investmentValueTable.revalidate();
        }
    }
}
