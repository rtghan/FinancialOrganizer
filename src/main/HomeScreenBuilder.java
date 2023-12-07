package main;

import back_end.chart_visualisation.ChartInputBoundary;
import back_end.chart_visualisation.ChartInteractor;
import back_end.home_screen.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenController;
import interface_adapter.home_screen.HomeScreenPresenter;
import interface_adapter.home_screen.HomeScreenViewModel;
import view.HomeScreenView;

/**
 * builder class that creates the home screen interfaces
 */
public class HomeScreenBuilder {

    /**
     * creates the view by calling the controller
     * @param homeVM            home screen view manager
     * @param viewManagerModel  view manager model
     * @param homeDAO           home screen data access object
     * @return home screen view
     */
    public static HomeScreenView create(
            HomeScreenViewModel homeVM, ViewManagerModel viewManagerModel,
            HomeScreenDataAccessInterface homeDAO){

        HomeScreenController homeController = createHomeScreenUseCase(
                homeVM, viewManagerModel, homeDAO);
        return new HomeScreenView(homeVM, viewManagerModel, homeController);
    }

    /**
     * creates the home screen use case / controller
     * @param homeVM            home screen view model
     * @param viewManagerModel  view model manager
     * @param homeDAO           home screen data access object
     * @return                  home screen controller
     */
    private static HomeScreenController createHomeScreenUseCase(
            HomeScreenViewModel homeVM, ViewManagerModel viewManagerModel,
            HomeScreenDataAccessInterface homeDAO) {

        HomeScreenOutputBoundary homeScreenOutputBoundary = new HomeScreenPresenter(
                homeVM, viewManagerModel);
        HomeScreenInputBoundary homeScreenInputBoundary = new HomeScreenInteractor(
                homeScreenOutputBoundary, homeDAO);
        ChartInputBoundary inputBoundary = new ChartInteractor(
                homeDAO, homeScreenOutputBoundary);

        return new HomeScreenController(homeScreenInputBoundary, inputBoundary);
    }

}
