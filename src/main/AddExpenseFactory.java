package main;

import back_end.add_expense.AddExpenseDataAccessInterface;
import back_end.add_expense.AddExpenseInputBoundary;
import back_end.add_expense.AddExpenseInteractor;
import back_end.add_expense.AddExpenseOutputBoundary;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_expense.AddExpensePresenter;
import interface_adapter.add_expense.AddExpenseViewModel;
import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_expense.AddExpenseViewModel;
import interface_adapter.home_screen.HomeScreenViewModel;
import view.AddBudgetView;
import view.AddExpenseView;

public class AddExpenseFactory {
    public static AddExpenseView create(AddExpenseViewModel addExpenseVM, ViewManagerModel viewManagerModel,
                                        HomeScreenViewModel homeScreenVM, AddExpenseDataAccessInterface addExpDAO) {

    AddExpenseController controller = createExpenseUsecase(viewManagerModel, addExpenseVM, homeScreenVM, addExpDAO);
    return new AddExpenseView(controller, addExpenseVM, viewManagerModel);
}

    private static AddExpenseController createExpenseUsecase(ViewManagerModel viewManagerModel,
     AddExpenseViewModel expenseVM, HomeScreenViewModel homeScreenVM, AddExpenseDataAccessInterface addExpDAO) {

        AddExpenseOutputBoundary addBudOutputBoundary = new AddExpensePresenter(expenseVM, viewManagerModel, homeScreenVM);
        AddExpenseInputBoundary addBudInteractor = new AddExpenseInteractor(addBudOutputBoundary, addExpDAO);

        return new AddExpenseController(addBudInteractor);
    }

}
