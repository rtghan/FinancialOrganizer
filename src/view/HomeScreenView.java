package view;

import interface_adapter.add_budget.AddBudgetViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HomeScreenView extends JPanel implements ActionListener, PropertyChangeListener {

    private JButton addBudgetButton;
    private JButton editBudgetButton;
    private JButton addIncomeButton;
    private JButton addExpenseButton;
    private JButton viewStatisticsButton;

    public HomeScreenView() {
        addBudgetButton = new JButton("Add Budget");
        editBudgetButton = new JButton("Edit Budget");
        addIncomeButton = new JButton("Add Income");
        addExpenseButton = new JButton("Add Expense");
        viewStatisticsButton = new JButton("View Statistics");

        addBudgetButton.addActionListener(this);
        editBudgetButton.addActionListener(this);
        addIncomeButton.addActionListener(this);
        addExpenseButton.addActionListener(this);
        viewStatisticsButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventSource = e.getSource();

        if (eventSource == addBudgetButton) {
            System.out.println("Add Budget Button clicked");
        } else if (eventSource == editBudgetButton) {
            System.out.println("Edit Budget button clicked");
        } else if (eventSource == addIncomeButton) {
            System.out.println("Add Income button clicked");
        } else if (eventSource == addExpenseButton) {
            System.out.println("Add Expense button clicked");
        } else if (eventSource == viewStatisticsButton) {
            System.out.println("View Statistics button clicked");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}