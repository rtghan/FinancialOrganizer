package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_expense.AddExpensePresenter;
import interface_adapter.add_expense.AddExpenseState;
import interface_adapter.add_expense.AddExpenseViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddExpenseView extends JPanel implements ActionListener, PropertyChangeListener{
    private final AddExpenseViewModel addExpenseVM;
    private final ViewManagerModel viewManagerModel;
    private final AddExpenseController controller;
    private final JTextField nameField = new JTextField(15);
    private final JTextField categoryField = new JTextField(15);
    private final JTextField amtField = new JTextField(15);
    private final JButton add;
    private final JButton cancel;

    /**
     * Constructs an instance of AddExpenseView
     * @param controller AddExpensController
     * @param addExpenseViewModel AddExpenseViewModel
     * @param viewModelManager ViewModelManager
     */
    public AddExpenseView(final AddExpenseController controller, AddExpenseViewModel addExpenseViewModel, ViewManagerModel viewModelManager){
        // Instance variables setup
        this.addExpenseVM = addExpenseViewModel;
        this.viewManagerModel = viewModelManager;
        this.controller = controller;

        addExpenseVM.addPropertyChangeListener(this);
        // UI elements setup

        // Title
        JLabel title = new JLabel(addExpenseViewModel.TITLE);

        // Month Select
        JComboBox monthSel = new JComboBox(addExpenseViewModel.MONTH_COMBO);
        LabelPanel monthbox = new LabelPanel(new JLabel(AddExpenseViewModel.MONTH_LABEL), monthSel);
        // Text input fields
        LabelPanel namebox = new LabelPanel(new JLabel(AddExpenseViewModel.NAME_TEXT_LABEL), nameField);
        LabelPanel categorybox = new LabelPanel(new JLabel(AddExpenseViewModel.CATEGORY_TEXT_LABEL), categoryField);
        LabelPanel amtbox = new LabelPanel(new JLabel(AddExpenseViewModel.AMT_TEXT_LABEL), amtField);

        add = new JButton(addExpenseViewModel.ADD_BUTTON_LABEL);
        cancel = new JButton(addExpenseViewModel.CANCEL_BUTTON_LABEL);
        JPanel buttons = new JPanel();

        //Buttons
        buttons.add(add);
        buttons.add(cancel);

        // Adding UI element to view
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(monthbox);
        this.add(namebox);
        this.add(categorybox);
        this.add(amtbox);
        this.add(buttons);

        monthSel.addActionListener(
                e -> {
                    System.out.println("Expense Month Changed");
                    AddExpenseState currState = addExpenseVM.getState();
                    String selection = (String) monthSel.getSelectedItem();
                    currState.setMonth(selection);
                }
        );

        add.addActionListener(
                e -> {
                    System.out.println("AddExpense Add");
                    AddExpenseState currState = addExpenseVM.getState();
                    controller.execute(currState.getName(), currState.getCategory(), currState.getAmt(), currState.getMonth());
                }
        );
        cancel.addActionListener(
                e -> {
                    System.out.println("AddExpense Cancel");
                    clear();
                    controller.cancel();
                });
        nameField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddExpenseState currState = addExpenseVM.getState();
                        String text = nameField.getText() + e.getKeyChar();
                        currState.setName(text);
                        addExpenseVM.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        categoryField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddExpenseState currState = addExpenseVM.getState();
                        String text = categoryField.getText() + e.getKeyChar();
                        currState.setCategory(text);
                        addExpenseVM.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
        amtField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddExpenseState currState = addExpenseVM.getState();
                        String text = amtField.getText() + e.getKeyChar();
                        currState.setAmt(Double.parseDouble(text));
                        addExpenseVM.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object response = evt.getNewValue();
        if (response.getClass() == AddExpenseState.class){
            AddExpenseState state = (AddExpenseState) response;
            String popup = "Sorry, no budget has been created for this month!\n Could not add expense.";
            if (state.popup()){
                popup = "Succesfully added the expense named " + state.getName() + " categorised as " + state.getCategory() + " of $"
                        + state.getAmt() + "!";
            }
            JOptionPane.showMessageDialog(this, popup);
            clear();
        }

    }
    private void clear(){
        this.nameField.setText("");
        this.amtField.setText("");
        this.categoryField.setText("");

        AddExpenseState state = addExpenseVM.getState();
        state.setAmt(0);
        state.setName("");
        state.setCategory("");
        addExpenseVM.setState(state);
    }
}
