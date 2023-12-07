package view;

import back_end.chart_visualisation.ChartInputData;
import back_end.home_screen.HomeScreenInputData;
import interface_adapter.add_budget.AddBudgetViewModel;
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
import java.nio.Buffer;

/**
 * represents the view for the home screen
 */
public class HomeScreenView extends JPanel implements ActionListener, PropertyChangeListener {

    private final HomeScreenViewModel homeVM;
    private final ViewManagerModel viewManagerModel;
    private final HomeScreenController homeController;
    private final JButton addEditBudgetButton;
    private final JButton addIncomeButton;
    private final JButton addExpenseButton;
    private final JButton addInvestmentButton;
    private final JComboBox monthSelectionList;
    private final LabelPanel monthSelectionInfo;
    private final JButton remainingBudgetButton;
    private final JButton totalIncomeButton;
    private final JButton totalExpensesButton;
    private JLabel statGraphImg;
    private JLabel expenseImg;
    private JDialog popup;

    /**
     * constructor for the home screen view
     * @param homeVM            home screen view model
     * @param viewManagerModel  view manager model
     * @param homeController    home controller
     */
    public HomeScreenView(HomeScreenViewModel homeVM, ViewManagerModel viewManagerModel, HomeScreenController homeController) {
        this.setPreferredSize(new Dimension(1200, 600));
        this.homeVM = homeVM;
        this.viewManagerModel = viewManagerModel;
        this.homeController = homeController;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        addEditBudgetButton = new JButton(HomeScreenViewModel.ADD_EDIT_BUDGET_LABEL);
        addEditBudgetButton.addActionListener(this);

        addIncomeButton = new JButton(HomeScreenViewModel.ADD_INCOME_LABEL);
        addIncomeButton.addActionListener(this);

        addExpenseButton = new JButton(HomeScreenViewModel.ADD_EXPENSE_LABEL);
        addExpenseButton.addActionListener(this);

        addInvestmentButton = new JButton(HomeScreenViewModel.ADD_INVESTMENT_LABEL);
        addInvestmentButton.addActionListener(this);

        monthSelectionList = new JComboBox(HomeScreenViewModel.TIME_OPTIONS);
        monthSelectionList.addActionListener(this);
        monthSelectionInfo = new LabelPanel(new JLabel("Select month: "), monthSelectionList);

        JLabel title = new JLabel(HomeScreenViewModel.HOME_SCREEN_LABEL);

        remainingBudgetButton = new JButton("Remaining Budget Statistics: ");
        remainingBudgetButton.addActionListener(this);

        totalIncomeButton = new JButton("Total Income Statistics: ");
        totalIncomeButton.addActionListener(this);

        totalExpensesButton = new JButton("Total Expenses Statistics: ");
        totalExpensesButton.addActionListener(this);

        BufferedImage statGraph = homeVM.getState().getStatGraph();
        statGraphImg = new JLabel("",SwingConstants.CENTER);
        if (statGraph != null) {
            Image scaledGraph = statGraph.getScaledInstance(320, 180, Image.SCALE_DEFAULT);
            statGraphImg.setIcon(new ImageIcon(scaledGraph));
        }
        statGraphImg.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        buttons.add(addEditBudgetButton);
        buttons.add(addIncomeButton);
        buttons.add(addExpenseButton);
        buttons.add(addInvestmentButton);
        buttons.setPreferredSize(new Dimension(100, 10));


        JPanel stats = new JPanel();
        stats.add(remainingBudgetButton);
        stats.add(totalIncomeButton);
        stats.add(totalExpensesButton);
        stats.setPreferredSize(new Dimension(100, 10));

        this.add(title);
        this.add(statGraphImg, BorderLayout.CENTER);
        this.add(monthSelectionInfo);
        this.add(buttons);
        this.add(stats);



        homeVM.addPropertyChangeListener(this);
    }

    /**
     * actions for button click events in the home screen
     * @param e the event to be processed
     */
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
        } else if (eventSource == addInvestmentButton) {
            this.viewManagerModel.setActiveView("AddInvestment");
            this.viewManagerModel.firePropertyChanged();
        }

        else if (eventSource == monthSelectionList){
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

        else if (eventSource == totalExpensesButton){
            System.out.println("Total Expense Pressed");
            BufferedImage expenseChart;
            HomeScreenState currState = homeVM.getState();
            ChartInputData chartData = new ChartInputData(currState.getMonth());
            try{
                homeController.chart(chartData);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            popup = new JDialog();
            popup.setTitle("Per Category Expense Breakdown:");
            popup.setLocation(this.getWidth()/2, this.getHeight()/2);
            popup.setSize(500,500);
            expenseChart = currState.getExpenseGraph();
            if (expenseChart != null){
                Image scaledExpense = expenseChart.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
                expenseImg = new JLabel();
                expenseImg.setIcon(new ImageIcon(scaledExpense));
            }
            popup.add(expenseImg);
            homeVM.setState(currState);
            popup.setVisible(true);
        }
    }

    /**
     * property change actions for button click events in the home screen
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
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
            monthSelectionInfo.panelText.setText(monthTextLabel);

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
        }
    }
}