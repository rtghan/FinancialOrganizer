package main;

import back_end.add_budget.AddBudgetDataAccessInterface;
import back_end.add_budget.AddBudgetInputBoundary;
import back_end.add_budget.AddBudgetInteractor;
import back_end.add_budget.AddBudgetOutputBoundary;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_budget.*;
import back_end.add_budget.back_end.*;
// TODO: replace homescreen with stats screen
import interface_adapter.home_screen.HomeScreenViewModel;
import view.AddBudgetView;
public class AddBudgetFactory {
    public static AddBudgetView create(AddBudgetViewModel addBudVM, ViewManagerModel viewManagerModel,
                                       AddBudgetDataAccessInterface addBudDAO, HomeScreenViewModel homeScreenVM) {

        AddBudgetController addBudgetController = createAddBudUseCase(viewManagerModel, addBudDAO, addBudVM, homeScreenVM);
        return new AddBudgetView(addBudgetController, addBudVM);
    }

    private static AddBudgetController createAddBudUseCase(
            ViewManagerModel viewManagerModel, AddBudgetDataAccessInterface addBudDAO,
            AddBudgetViewModel addBudVM, HomeScreenViewModel homeScreenVM) {

        AddBudgetOutputBoundary addBudOutputBoundary = new AddBudgetPresenter(addBudVM, viewManagerModel, homeScreenVM);
        AddBudgetInputBoundary addBudInteractor = new AddBudgetInteractor(addBudDAO, addBudOutputBoundary);

        return new AddBudgetController(addBudInteractor);
    }
}
