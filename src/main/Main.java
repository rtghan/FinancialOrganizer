package main;

import back_end.add_budget.AddBudgetDataAccessInterface;
import back_end.add_expense.AddExpenseDataAccessInterface;
import back_end.add_income.AddIncomeDataAccessInterface;
import back_end.add_investment.AddInvestmentDataAccessInterface;
import back_end.home_screen.HomeScreenDataAccessInterface;
import back_end.investment_value.InvestmentValueDataAccessInterface;
import data_access.MemoryDAO;
import data_access.api.StockQuery;
import entity.Investment;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_budget.*;
import interface_adapter.add_expense.AddExpenseViewModel;
import interface_adapter.add_income.AddIncomeViewModel;
import interface_adapter.add_investment.AddInvestmentViewModel;
import interface_adapter.home_screen.*;
// TODO: change this for the property data access object
import interface_adapter.investment_value.InvestmentValueViewModel;
import view.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String args[]) {

        JFrame app = new JFrame("Financial Organizer");
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        app.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        /*
         * don't need to save this into an object because it whenever ViewManagerModel does something, it will
         * automatically activate propertyChanged and change the view
         */
        new ViewManager(views, cardLayout, viewManagerModel);

        // initialize viewmodels
        AddBudgetViewModel addBudVM = new AddBudgetViewModel();
        AddIncomeViewModel addIncVM = new AddIncomeViewModel();
        AddInvestmentViewModel addInvVM = new AddInvestmentViewModel("AddInvestment");
        AddExpenseViewModel expenseVM = new AddExpenseViewModel("AddExpense");
        HomeScreenViewModel homeScreenVM = new HomeScreenViewModel(); //removed parameter in hs vm
        InvestmentValueViewModel invValVM = new InvestmentValueViewModel();

        // intialize data access objects required for each of the views, polymorphism, as MemoryDAO implements all their interfaces
        MemoryDAO dataAccess = new MemoryDAO();
        InvestmentValueDataAccessInterface stockDAO = new StockQuery("ayODBObam0Um8BBlk3EZ7_F4Tgx0JpR7");
        AddIncomeDataAccessInterface addIncDAO = dataAccess;
        AddBudgetDataAccessInterface addBudDAO = dataAccess;
        AddExpenseDataAccessInterface addExpDAO = dataAccess;
        HomeScreenDataAccessInterface homeDAO = dataAccess;
        AddInvestmentDataAccessInterface addInvDAO = dataAccess;


        // create the views
        AddBudgetView addBudgetView = AddBudgetBuilder.create(addBudVM, viewManagerModel, addBudDAO, homeScreenVM);
        HomeScreenView homeScreenView = HomeScreenBuilder.create(homeScreenVM, viewManagerModel, homeDAO);
        AddExpenseView addExpenseView = AddExpenseBuilder.create(expenseVM, viewManagerModel, homeScreenVM, addExpDAO);
        AddIncomeView addIncomeView =  AddIncomeBuilder.create(addIncVM, viewManagerModel, addIncDAO, homeScreenVM);
        AddInvestmentView addInvestmentView = AddInvestmentBuilder.create(addInvVM, viewManagerModel, addInvDAO, homeScreenVM);
        InvestmentValueView investmentValueView = InvestmentValueBuilder.create(invValVM, viewManagerModel, addInvDAO, stockDAO, homeScreenVM);

        // add them to the card layout so that we can switch between them, and label each one by the name given by its viewModel
        views.add(addBudgetView, addBudVM.getViewName());
        views.add(homeScreenView, homeScreenVM.getViewName());
        views.add(addExpenseView,expenseVM.getViewName());
        views.add(addIncomeView,addIncVM.getViewName());
        views.add(addInvestmentView, addInvVM.getViewName());
        views.add(investmentValueView, invValVM.getViewName());

        app.pack();
        app.setVisible(true);
    }
}
