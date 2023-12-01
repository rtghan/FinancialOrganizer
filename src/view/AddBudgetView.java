package view;

import interface_adapter.add_budget.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class AddBudgetView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "AddBudget";
    private final AddBudgetViewModel addBudViewModel;
    private final JComboBox monthSelection;
    private final JTextField saveAmtField = new JTextField(15);
    private final JTextField invAmtField = new JTextField(15);
    private final JTextField spendAmtField = new JTextField(15);
    private final JButton add;
    private final JButton cancel;
    private final AddBudgetController addBudController;
    public AddBudgetView(AddBudgetController abController, AddBudgetViewModel abVM) {
        this.addBudController = abController;
        this.addBudViewModel = abVM;
        addBudViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(AddBudgetViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // dropdown menu for month selection
        this.monthSelection = new JComboBox(AddBudgetViewModel.TIME_OPTIONS);
        // add a listener so that when someone selects a month, it is reflected in the state
        monthSelection.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt){
                        if (evt.getSource().equals(monthSelection)){
                            System.out.println("Month dropdown changed");
                            AddBudgetState currState = addBudViewModel.getState();
                            String selection = (String) monthSelection.getSelectedItem();
                            currState.setMonthSelection(selection);
                            addBudViewModel.setState(currState);
                        }
                    }
                }
        );
        LabelPanel monthSelectionInfo = new LabelPanel(new JLabel(AddBudgetViewModel.TIME_LABEL), monthSelection);
        LabelPanel saveInfo = new LabelPanel(new JLabel(AddBudgetViewModel.SAVE_LABEL), saveAmtField);
        LabelPanel invInfo = new LabelPanel(new JLabel(AddBudgetViewModel.INVESTMENT_LABEL), invAmtField);
        LabelPanel spendInfo = new LabelPanel(new JLabel(AddBudgetViewModel.SPEND_LABEL), spendAmtField);

        JPanel buttons = new JPanel();
        add = new JButton(AddBudgetViewModel.ADD_BUDGET_BUTTON_LABEL);
        cancel = new JButton(AddBudgetViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(add);
        buttons.add(cancel);

        add.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(add)) {
                            System.out.println("Add budget clicked");
                            AddBudgetState currentState = addBudViewModel.getState();
                            addBudController.execute(currentState.getMonth(), currentState.getSaveAmt(),
                                    currentState.getInvAmt(), currentState.getSpendAmt()
                            );
                        }
                    }
                }
        );

        // TODO: cancel's actionlistener and other stuff needs to be implemented

        saveAmtField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddBudgetState currState = addBudViewModel.getState();
                        String text = saveAmtField.getText() + e.getKeyChar();
                        // convert the string to a double
                        currState.setSaveAmt(Double.parseDouble(text));
                        addBudViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        invAmtField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddBudgetState currState = addBudViewModel.getState();
                        String text = invAmtField.getText() + e.getKeyChar();
                        // convert the string to a double
                        currState.setInvAmt(Double.parseDouble(text));
                        addBudViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        spendAmtField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddBudgetState currState = addBudViewModel.getState();
                        String text = spendAmtField.getText() + e.getKeyChar();
                        // convert the string to a double
                        currState.setSpendAmt(Double.parseDouble(text));
                        addBudViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        // add all components to the view
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(monthSelectionInfo);
        this.add(saveInfo);
        this.add(invInfo);
        this.add(spendInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object response = evt.getNewValue();

        // popup if the add budget went through successfully
        if (response.getClass() == AddBudgetState.class) {
            AddBudgetState state = (AddBudgetState) response;
            String popup = "Something went wrong! :(";
            if (state.isCreationSuccess()) {
                popup = "Successfully created a budget for the month of " + state.getMonth().toString() + ",\n with a " +
                        "savings target of $" + Double.toString(state.getSaveAmt()) + ", an investment target of $" +
                        Double.toString(state.getInvAmt()) + ",\nand a spending limit target of $" +
                        Double.toString(state.getSaveAmt());
            }
            JOptionPane.showMessageDialog(this, popup);
        }
    }
}
