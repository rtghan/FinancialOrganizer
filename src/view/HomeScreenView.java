package view;

import back_end.home_screen.HomeScreenInputData;
import interface_adapter.add_budget.AddBudgetState;
import interface_adapter.home_screen.HomeScreenController;
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
    private final HomeScreenController homeController;
    private final JButton addEditBudgetButton;
    private final JButton addIncomeButton;
    private final JButton addExpenseButton;
    private final JComboBox monthSelectionList;
    private final JLabel selectedMonthLabel;

    private final JLabel remainingBudgetLabel; // "Remaining Budget: "
    private final JLabel totalIncomeLabel; // "Total Income: "
    private final JLabel totalExpensesLabel; // "Total Expenses: "

    public HomeScreenView(HomeScreenViewModel homeVM, ViewManagerModel viewManagerModel, HomeScreenController homeController) {
        this.homeVM = homeVM;
        this.viewManagerModel = viewManagerModel;
        this.homeController = homeController;

        addEditBudgetButton = new JButton(HomeScreenViewModel.ADD_EDIT_BUDGET_LABEL);
        addEditBudgetButton.addActionListener(this);

        addIncomeButton = new JButton(HomeScreenViewModel.ADD_INCOME_LABEL);
        addIncomeButton.addActionListener(this);

        addExpenseButton = new JButton(HomeScreenViewModel.ADD_EXPENSE_LABEL);
        addExpenseButton.addActionListener(this);

        monthSelectionList = new JComboBox(HomeScreenViewModel.TIME_OPTIONS);
        monthSelectionList.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt){
                        if (evt.getSource().equals(monthSelectionList)){
                            System.out.println("Month dropdown changed");
                            HomeScreenState currState = homeVM.getState();
                            String selection = (String) monthSelectionList.getSelectedItem();
                            currState.setMonthSelection(selection);
                            homeVM.setState(currState);

                            // call the controller to retrieve the new stats and display them
                            HomeScreenInputData inputData = new HomeScreenInputData(currState.getMonth());
                            homeController.execute(inputData);
                        }
                    }
                }
        );

        JLabel title = new JLabel(HomeScreenViewModel.HOME_SCREEN_LABEL);

        // add month after selection
        selectedMonthLabel = new JLabel("Selected Month: ");

        // add value after month selection
        remainingBudgetLabel = new JLabel("Remaining Budget: ");
        totalIncomeLabel = new JLabel("Total Income: ");
        totalExpensesLabel = new JLabel("Total Expenses: ");

        JPanel buttons = new JPanel();
        buttons.add(addEditBudgetButton);
        buttons.add(addIncomeButton);
        buttons.add(addExpenseButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(monthSelectionList);
        this.add(selectedMonthLabel);
        this.add(remainingBudgetLabel);
        this.add(totalIncomeLabel);
        this.add(totalExpensesLabel);

        this.add(buttons);

        homeVM.addPropertyChangeListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventSource = e.getSource();
        if (eventSource == addEditBudgetButton) {
            System.out.println("Add / Edit Budget Button clicked");
            this.viewManagerModel.setActiveView("AddBudget");
            this.viewManagerModel.firePropertyChanged();
        } else if (eventSource == addIncomeButton) {
            System.out.println("Add Income button clicked");
        } else if (eventSource == addExpenseButton) {
            System.out.println("Add Expense button clicked");
            this.viewManagerModel.setActiveView("AddExpense");
            this.viewManagerModel.firePropertyChanged();
        } else if (eventSource == monthSelectionList){
            System.out.println("Month dropdown changed");
            String selectedMonthStr = (String) monthSelectionList.getSelectedItem();
            homeVM.viewMonthSelection(selectedMonthStr);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object response = evt.getNewValue();

        // update if the property change was a homescreen state change
        if (response.getClass() == HomeScreenState.class) {
            HomeScreenState state = (HomeScreenState) response;
            // update displayed month
            String monthText = "Selected Month: ";
            String monthTextLabel = monthText + state.getMonth();
            selectedMonthLabel.setText(monthTextLabel);

            // by default, assume there no budget exists for that month
            String budgetText = "Remaining Budget: N/A";
            String incomeText = "Total Income: N/A";
            String expensesText = "Total Expenses: N/A";

            // if the budget is not null, update the relevant financial amounts
            if (state.isCreationSuccess()) {
                // update relevant financial amounts
                double budgetRemainingAmt = state.getRemainingBudget();
                budgetText = "Remaining Budget: " + budgetRemainingAmt;


                double totalIncomeAmt = state.getTotalIncome();
                incomeText = "Total Income: " + totalIncomeAmt;


                double totalExpensesAmt = state.getTotalExpenses();
                expensesText = "Total Expenses: " + totalExpensesAmt;

            }
            // update the labels to reflect it
            remainingBudgetLabel.setText(budgetText);
            totalIncomeLabel.setText(incomeText);
            totalExpensesLabel.setText(expensesText);

        }
    }
}