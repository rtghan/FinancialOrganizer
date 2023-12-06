package view;

import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomeState;
import interface_adapter.add_income.AddIncomeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddIncomeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "AddIncome";
    private final AddIncomeViewModel addIncomeViewModel;
    private final JTextField incomeSourceField = new JTextField(20);
    private final JTextField amountField = new JTextField(20);
    private final JButton add;
    private final JButton cancel;
    private final AddIncomeController addIncomeController;
    public AddIncomeView(AddIncomeController addIncController, AddIncomeViewModel addIncViewModel) {
        this.addIncomeController = addIncController;
        this.addIncomeViewModel = addIncViewModel;
        addIncomeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(AddIncomeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelPanel incomeSourceInfo = new LabelPanel(new JLabel(AddIncomeViewModel.INCOME_SOURCE_LABEL), incomeSourceField);
        LabelPanel amountInfo = new LabelPanel(new JLabel(AddIncomeViewModel.AMOUNT_LABLE), amountField);

        JPanel buttons = new JPanel();
        add = new JButton(AddIncomeViewModel.ADD_INCOME_BUTTON_LABEL);
        cancel = new JButton(AddIncomeViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(add);
        buttons.add(cancel);

        add.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(add)) {
                            System.out.println("Add Income clicked");
                            AddIncomeState currentState = addIncomeViewModel.getState();
                            addIncomeController.execute(currentState.getIncome_source(), currentState.getAmount());
                        }
                    }
                }
        );

        incomeSourceField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddIncomeState currState = addIncomeViewModel.getState();
                        String text = incomeSourceField.getText() + e.getKeyChar();
                        currState.setIncome_source(text);
                        addIncomeViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        amountField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddIncomeState currState = addIncomeViewModel.getState();
                        String text = amountField.getText() + e.getKeyChar();
                        currState.setAmount(Double.parseDouble(text));
                        addIncomeViewModel.setState(currState);
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
        this.add(incomeSourceInfo);
        this.add(amountInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

    }

    public void propertyChange(PropertyChangeEvent evt) {
        Object response = evt.getNewValue();

        if (response.getClass() == AddIncomeState.class) {
            AddIncomeState state = (AddIncomeState) response;
            String popup = "Something went wrong!";
            if (state.isCreationSuccess()) {
                popup = "Successfully added an income of " + state.getAmount() + "from " + state.getIncome_source();
            }
            JOptionPane.showMessageDialog(this, popup);
        }
    }
}
