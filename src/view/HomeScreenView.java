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
    private final JLabel totalIncomeLabel; // "Total Income: "
    private final JLabel totalExpensesLabel; // "Total Expenses: "

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
        if ("state".equals(evt.getPropertyName())) {

            String monthText = "Selected Month: ";

            String monthTextLabel = monthText + homeVM.getState().getMonth();
            selectedMonthLabel.setText(monthTextLabel);

            BudgetDataAccessObject budgetDAO = new BudgetDataAccessObject();
            // this creates a new Budget, I need to get one that was already created
            Budget selectedMonthBudget =
                    budgetDAO.getBudgetByMonth(homeVM.getState().getMonth());
            //System.out.println(homeVM.getState().getMonth());

            // TODO: selectedMonthBudget is always null
            // TODO: after month selection, need to retrieve Budget that was created

            if (selectedMonthBudget != null) {
                double budgetRemainingAmt = selectedMonthBudget.getRemaining();
                String budgetText = "Remaining Budget: " + budgetRemainingAmt;
                remainingBudgetLabel.setText(budgetText);

                double totalIncomeAmt = selectedMonthBudget.totalIncome();
                String incomeText = "Total Income: " + totalIncomeAmt;
                totalIncomeLabel.setText("Total Income: " + incomeText);

                double totalExpensesAmt = selectedMonthBudget.totalExpenses();
                String expensesText = "Total Expenses: " + totalExpensesAmt;
                totalExpensesLabel.setText("Total Expenses: " + expensesText);


            } else {
                remainingBudgetLabel.setText("Remaining Budget: N/A");
                totalIncomeLabel.setText("Total Income: N/A");
                totalExpensesLabel.setText("Total Expenses: N/A");
            }

        }
    }
}