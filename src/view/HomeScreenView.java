package view;

import interface_adapter.home_screen.HomeScreenViewModel;
import interface_adapter.ViewManagerModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HomeScreenView extends JPanel implements ActionListener, PropertyChangeListener {

    private final HomeScreenViewModel homeScreenViewModel;
    private final ViewManagerModel viewManagerModel;
    private final JButton addBudgetButton;
    private final JButton editBudgetButton;
    private final JButton addIncomeButton;
    private final JButton addExpenseButton;
    private final JButton viewStatisticsButton;

    public HomeScreenView(HomeScreenViewModel homeScreenVM, ViewManagerModel viewManagerModel) {
        this.homeScreenViewModel = homeScreenVM;
        this.viewManagerModel = viewManagerModel;

        addBudgetButton = new JButton(HomeScreenViewModel.ADD_BUDGET_LABEL);
        addBudgetButton.addActionListener(this);

        editBudgetButton = new JButton(HomeScreenViewModel.EDIT_BUDGET_LABEL);
        editBudgetButton.addActionListener(this);

        addIncomeButton = new JButton(HomeScreenViewModel.ADD_INCOME_LABEL);
        addIncomeButton.addActionListener(this);

        addExpenseButton = new JButton(HomeScreenViewModel.ADD_EXPENSE_LABEL);
        addExpenseButton.addActionListener(this);

        viewStatisticsButton = new JButton(HomeScreenViewModel.VIEW_STATISTICS_LABEL);
        viewStatisticsButton.addActionListener(this);

        JLabel title = new JLabel(HomeScreenViewModel.HOME_SCREEN_LABEL);

        JPanel buttons = new JPanel();
        buttons.add(addBudgetButton);
        buttons.add(editBudgetButton);
        buttons.add(addIncomeButton);
        buttons.add(addExpenseButton);
        buttons.add(viewStatisticsButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventSource = e.getSource();

        if (eventSource == addBudgetButton) {
            System.out.println("Add Budget Button clicked");
            // switch to the Add Budget view

            // this comes from the name of the AddBudgetViewModel
            // should match the name of the AddBudgetView
            this.viewManagerModel.setActiveView("AddBudget");

            this.viewManagerModel.firePropertyChanged();
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
        //
    }
}