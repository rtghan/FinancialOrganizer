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
    private final JButton addEditBudgetButton;
    private final JButton addIncomeButton;
    private final JButton addExpenseButton;
    private final JComboBox monthSelectionList;
    private final JLabel selectedMonthLabel;

    public HomeScreenView(HomeScreenViewModel homeScreenVM, ViewManagerModel viewManagerModel) {
        this.homeScreenViewModel = homeScreenVM;
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
        JLabel month_label = new JLabel(HomeScreenViewModel.MONTH_LABEL);
        selectedMonthLabel = new JLabel();

        JPanel buttons = new JPanel();
        buttons.add(addEditBudgetButton);
        buttons.add(addIncomeButton);
        buttons.add(addExpenseButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(monthSelectionList);
        this.add(month_label);
        this.add(selectedMonthLabel);
        this.add(buttons);

        homeScreenViewModel.addPropertyChangeListener(this);
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
            homeScreenViewModel.viewMonthSelection(selectedMonthStr);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            selectedMonthLabel.setText(homeScreenViewModel.getState().getMonthSelection());
        }
    }
}