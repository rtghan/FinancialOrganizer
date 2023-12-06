package main;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_budget.*;
import interface_adapter.home_screen.*;
// TODO: change this for the property data access object
import data_access.MemoryDAO;
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
        HomeScreenViewModel homeScreenVM = new HomeScreenViewModel(); //removed parameter in hs vm

        // intialize data access objects required for each of the views
        MemoryDAO addBudDAO = new MemoryDAO();

        // create the views
        AddBudgetView addBudgetView = AddBudgetFactory.create(addBudVM, viewManagerModel, addBudDAO, homeScreenVM);
        HomeScreenView homeScreenView = new HomeScreenView(homeScreenVM, viewManagerModel);

        // add them to the card layout so that we can switch between them, and label each one by the name given by its viewModel
        views.add(addBudgetView, addBudVM.getViewName());
        views.add(homeScreenView, homeScreenVM.getViewName());

        app.pack();
        app.setVisible(true);
    }
}
