package view;

import back_end.home_screen.HomeScreenInputData;
import interface_adapter.home_screen.HomeScreenController;
import interface_adapter.home_screen.HomeScreenState;
import interface_adapter.home_screen.HomeScreenViewModel;
import interface_adapter.ViewManagerModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.image.BufferedImage;

public class HomeScreenView extends JPanel implements ActionListener, PropertyChangeListener {

    private final HomeScreenViewModel homeVM;
    private final ViewManagerModel viewManagerModel;
    private final HomeScreenController homeController;
    private final JButton addEditBudgetButton;
    private final JButton addIncomeButton;
    private final JButton addExpenseButton;
    private final JComboBox monthSelectionList;

    private final JLabel selectedMonthLabel;

    // changed to buttons.
    private final JButton remainingBudgetButton;
    private final JButton totalIncomeButton;
    private final JButton totalExpensesButton;

    private JLabel statGraphImg;

    public HomeScreenView(HomeScreenViewModel homeVM, ViewManagerModel viewManagerModel, HomeScreenController homeController) {
        this.setPreferredSize(new Dimension(1200, 800));
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
        monthSelectionList.addActionListener(this);

        JLabel title = new JLabel(HomeScreenViewModel.HOME_SCREEN_LABEL);

        remainingBudgetButton = new JButton("Remaining Budget Statistics: ");
        remainingBudgetButton.addActionListener(this);

        totalIncomeButton = new JButton("Total Income Statistics: ");
        totalIncomeButton.addActionListener(this);

        totalExpensesButton = new JButton("Total Expenses Statistics: ");
        totalExpensesButton.addActionListener(this);

        // add month after selection
        selectedMonthLabel = new JLabel("Selected Month: ");

        JPanel buttons = new JPanel();
        buttons.add(addEditBudgetButton);
        buttons.add(addIncomeButton);
        buttons.add(addExpenseButton);
        buttons.add(remainingBudgetButton);
        buttons.add(totalIncomeButton);
        buttons.add(totalExpensesButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(monthSelectionList);
        this.add(selectedMonthLabel);
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
            this.viewManagerModel.setActiveView("AddIncome");
            this.viewManagerModel.firePropertyChanged();
        } else if (eventSource == addExpenseButton) {
            System.out.println("Add Expense button clicked");
            this.viewManagerModel.setActiveView("AddExpense");
            this.viewManagerModel.firePropertyChanged();
        } else if (eventSource == monthSelectionList){
            System.out.println("Month dropdown changed");
            HomeScreenState currState = homeVM.getState();
            String selection = (String) monthSelectionList.getSelectedItem();
            currState.setMonthSelection(selection);
            homeVM.setState(currState);
            // call the controller to retrieve the new stats and display them
            HomeScreenInputData inputData = new HomeScreenInputData(currState.getMonth());
            try {
                homeController.execute(inputData);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object response = evt.getNewValue();
        // view changed to home view, update the stats using the controller
        if (evt.getPropertyName().equals("viewUpdate")) {
            HomeScreenState currState = homeVM.getState();
            String selection = (String) monthSelectionList.getSelectedItem();
            currState.setMonthSelection(selection);
            homeVM.setState(currState);

            // call the controller to retrieve the new stats and display them
            HomeScreenInputData inputData = new HomeScreenInputData(currState.getMonth());
            try {
                homeController.execute(inputData);
            } catch (Exception e) {

            }
        }

        // update if the property change was a homescreen state change
        if (evt.getPropertyName().equals("state")) {

            System.out.println("Homescreen state change");
            HomeScreenState state = (HomeScreenState) response;
            // update displayed month
            String monthText = "Selected Month: ";
            String monthTextLabel = monthText + state.getMonth();
            selectedMonthLabel.setText(monthTextLabel);

            // by default, assume there no budget exists for that month
            String budgetText = "Remaining Budget: N/A";
            String incomeText = "Total Income: N/A";
            String expensesText = "Total Expenses: N/A";

            // add image
            BufferedImage statGraph = homeVM.getState().getStatGraph();
            if (statGraph != null) {
                Image scaledGraph = statGraph.getScaledInstance(800, 450, Image.SCALE_DEFAULT);
                statGraphImg.setIcon(new ImageIcon(scaledGraph));
            }

            // if the budget is not null, update the relevant financial amounts
            if (state.isBudgetNull()) {
                // update relevant financial amounts
                double budgetRemainingAmt = state.getRemainingBudget();
                budgetText = "Remaining Budget: " + budgetRemainingAmt;


                double totalIncomeAmt = state.getTotalIncome();
                incomeText = "Total Income: " + totalIncomeAmt;


                double totalExpensesAmt = state.getTotalExpenses();
                expensesText = "Total Expenses: " + totalExpensesAmt;

            }
            remainingBudgetButton.setText("Remaining Budget Statistics: " + budgetText);
            totalIncomeButton.setText("Total Income Statistics: " + incomeText);
            totalExpensesButton.setText("Total Expenses Statistics: " + expensesText);

            /*
            // update the labels to reflect it
            remainingBudgetLabel.setText(budgetText);
            totalIncomeLabel.setText(incomeText);
            totalExpensesLabel.setText(expensesText);*/

        }
    }
}