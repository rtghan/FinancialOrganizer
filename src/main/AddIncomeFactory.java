package main;

import back_end.add_income.AddIncomeDataAccessInterface;
import back_end.add_income.AddIncomeInputBoundary;
import back_end.add_income.AddIncomeInteractor;
import back_end.add_income.AddIncomeOutputBoundary;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomePresenter;
import interface_adapter.add_income.AddIncomeViewModel;
import interface_adapter.home_screen.HomeScreenViewModel;
import view.AddIncomeView;

public class AddIncomeFactory {
    public static AddIncomeView create(AddIncomeViewModel addIncVM, ViewManagerModel viewManagerModel,
                                       AddIncomeDataAccessInterface addIncDAO, HomeScreenViewModel homeScreenVM){

        AddIncomeController addIncomeController = createAddIncUseCase(viewManagerModel, addIncDAO, addIncVM, homeScreenVM);
        return new AddIncomeView(addIncomeController, addIncVM);
    }
    public static AddIncomeController createAddIncUseCase(
            ViewManagerModel viewManagerModel, AddIncomeDataAccessInterface addIncDAO,
            AddIncomeViewModel addIncVM, HomeScreenViewModel homeScreenVM) {

        AddIncomeOutputBoundary addIncomeOutputBoundary = new AddIncomePresenter(addIncVM, viewManagerModel, homeScreenVM);
        AddIncomeInputBoundary addIncInteractor = new AddIncomeInteractor(addIncDAO, addIncomeOutputBoundary);

        return new AddIncomeController(addIncInteractor);
    }
}
