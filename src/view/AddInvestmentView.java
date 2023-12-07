package view;

import interface_adapter.add_investment.AddInvestmentController;
import interface_adapter.add_investment.AddInvestmentState;
import interface_adapter.add_investment.AddInvestmentViewModel;
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
import java.util.Calendar;

public class AddInvestmentView extends JPanel implements ActionListener, PropertyChangeListener {
    private JDatePicker datePicker;
    public final String viewName = "AddInvestment";
    private final AddInvestmentViewModel addInvVM;
    private final JTextField qtyField = new JTextField(20);
    private final JTextField nameField = new JTextField(20);
    private final JButton add;
    private final JButton cancel;
    private final AddInvestmentController addInvController;
    public AddInvestmentView(AddInvestmentController addInvestmentController, AddInvestmentViewModel addInvestmentVM) {
        this.addInvController = addInvestmentController;
        this.addInvVM = addInvestmentVM;
        addInvVM.addPropertyChangeListener(this);

        JLabel title = new JLabel(AddInvestmentViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        datePicker = new JDatePicker();
        datePicker.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(datePicker)) {
                            System.out.println("Date has been chosen");
                            AddInvestmentState currState = addInvVM.getState();
                            Calendar selectedValue = (Calendar) datePicker.getModel().getValue();
                            LocalDate selectedDate = selectedValue.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            currState.setDate(selectedDate);
                            addInvVM.setState(currState);
                        }
                    }
                }
        );

        LabelPanel dateInfo = new LabelPanel(new JLabel(AddInvestmentViewModel.DATE_LABEL), datePicker);
        LabelPanel qtyInfo = new LabelPanel(new JLabel(AddInvestmentViewModel.QTY_LABEL), qtyField);
        LabelPanel nameInfo = new LabelPanel(new JLabel(AddInvestmentViewModel.NAME_LABEL), nameField);

        JPanel buttons = new JPanel();
        add = new JButton(AddInvestmentViewModel.ADD_BUTTON);
        cancel = new JButton(AddInvestmentViewModel.CANCEL_BUTTON);
        buttons.add(add);
        buttons.add(cancel);

        add.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(add)) {
                            System.out.println("Add Investment clicked");
                            AddInvestmentState currState = addInvVM.getState();
                            addInvController.execute(currState.getStockName(), currState.getQty(), currState.getDate());
                        }
                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("AddIncome Cancel");
                        AddInvestmentState currState = addInvVM.getState();
                        addInvController.cancel();
                    }
                }
        );

        qtyField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddInvestmentState currState = addInvVM.getState();
                        String text = qtyField.getText() + e.getKeyChar();
                        currState.setQty(Double.parseDouble(text));
                        addInvVM.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        nameField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddInvestmentState currState = addInvVM.getState();
                        String text = nameField.getText() + e.getKeyChar();
                        currState.setStockName(text);
                        addInvVM.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(dateInfo);
        this.add(qtyInfo);
        this.add(nameInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object response = evt.getNewValue();

        if (response.getClass() == AddInvestmentState.class) {
            AddInvestmentState state = (AddInvestmentState) response;
            String popup = "Could not save the stock!";
            if (state.getError() == null) {
                popup = "Successfully added " + Double.toString(state.getQty()) + " shares of " + state.getStockName() + " purchased\n"
                + " on " + state.getDate().toString();
            }
            JOptionPane.showMessageDialog(this, popup);
        }
    }
}
