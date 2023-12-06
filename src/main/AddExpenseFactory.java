package main;

import add_expense.back_end.AddExpenseInputBoundary;
import add_expense.back_end.AddExpenseInteractor;
import add_expense.back_end.AddExpenseOutputBoundary;
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
                                        HomeScreenViewModel homeScreenVM) {

    AddExpenseController controller = createExpenseUsecase(viewManagerModel, addExpenseVM, homeScreenVM);
    return new AddExpenseView(controller, addExpenseVM, viewManagerModel);
}

    private static AddExpenseController createExpenseUsecase(
            ViewManagerModel viewManagerModel, AddExpenseViewModel expenseVM, HomeScreenViewModel homeScreenVM) {

        AddExpenseOutputBoundary addBudOutputBoundary = new AddExpensePresenter(expenseVM, viewManagerModel, homeScreenVM);
        AddExpenseInputBoundary addBudInteractor = new AddExpenseInteractor(addBudOutputBoundary);

        return new AddExpenseController(addBudInteractor);
    }

}
