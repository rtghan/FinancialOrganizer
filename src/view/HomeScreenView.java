package view;

import interface_adapter.home_screen.HomeScreenState;
import interface_adapter.home_screen.HomeScreenViewModel;
import interface_adapter.ViewManagerModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import entity.Budget;
import data_access.BudgetDataAccessObject;

public class HomeScreenView extends JPanel implements ActionListener, PropertyChangeListener {

    private final HomeScreenViewModel homeVM;
    private final ViewManagerModel viewManagerModel;
    private final JButton addEditBudgetButton;
    private final JButton addIncomeButton;
    private final JButton addExpenseButton;
    private final JComboBox monthSelectionList;
    private final JLabel selectedMonthLabel;

    private final JLabel remainingBudgetLabel; // "Remaining Budget: "

    public HomeScreenView(HomeScreenViewModel homeVM, ViewManagerModel viewManagerModel) {
        this.homeVM = homeVM;
        this.viewManagerModel = viewManagerModel;

        addEditBudgetButton = new JButton(HomeScreenViewModel.ADD_EDIT_BUDGET_LABEL);
        addEditBudgetButton.addActionListener(this);

        addIncomeButton = new JButton(HomeScreenViewModel.ADD_INCOME_LABEL);
        addIncomeButton.addActionListener(this);

        addExpenseButton = new JButton(HomeScreenViewModel.ADD_EXPENSE_LABEL);
        addExpenseButton.addActionListener(this);

        monthSelectionList = new JComboBox(HomeScreenViewModel.TIME_OPTIONS);
        monthSelectionList.addActionListener(this);

        JLabel title = new JLabel(HomeScreenViewModel.HOME_SCREEN_LABEL);

        // add month after selection
        selectedMonthLabel = new JLabel("Selected Month: ");

        // add value after month selection
        remainingBudgetLabel = new JLabel("Remaining Budget: ");

        JPanel buttons = new JPanel();
        buttons.add(addEditBudgetButton);
        buttons.add(addIncomeButton);
        buttons.add(addExpenseButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(monthSelectionList);
        this.add(selectedMonthLabel);
        this.add(remainingBudgetLabel);

        this.add(buttons);

        homeVM.addPropertyChangeListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventSource = e.getSource();
        if (eventSource == addEditBudgetButton) {
            System.out.println("Add / Edit Budget Button clicked");
            // switch to the Add Budget view
            // this comes from the name of the AddBudgetViewModel
            // should match the name of the AddBudgetView
            this.viewManagerModel.setActiveView("AddBudget");
            this.viewManagerModel.firePropertyChanged();
        } else if (eventSource == addIncomeButton) {
            System.out.println("Add Income button clicked");
        } else if (eventSource == addExpenseButton) {
            System.out.println("Add Expense button clicked");
        } else if (eventSource == monthSelectionList){
            System.out.println("Month dropdown changed");
            String selectedMonthStr = (String) monthSelectionList.getSelectedItem();
            homeVM.viewMonthSelection(selectedMonthStr);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {

            String monthText = "Selected Month: ";

            String monthTextLabel = monthText + homeVM.getState().getMonth();
            selectedMonthLabel.setText(monthTextLabel);

            BudgetDataAccessObject budgetDAO = new BudgetDataAccessObject();

            Budget selectedMonthBudget =
                    budgetDAO.getBudgetByMonth(homeVM.getState().getMonth());
            //Budget selectedMonthBudget =
                //budgetDAO.getBudgetByMonth(homeVM.getState().getSelectedMonth());
            if (selectedMonthBudget != null) {
                double budgetRemaining = selectedMonthBudget.getRemaining();
                String budgetText = "Remaining Budget: " + budgetRemaining;
                remainingBudgetLabel.setText(budgetText);
            } else {
                remainingBudgetLabel.setText("Remaining Budget: N/A");
            }

        }
    }
}