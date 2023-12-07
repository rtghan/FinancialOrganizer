package main;

import back_end.chart_visualisation.ChartInputBoundary;
import back_end.chart_visualisation.ChartInteractor;
import back_end.home_screen.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenController;
import interface_adapter.home_screen.HomeScreenPresenter;
import interface_adapter.home_screen.HomeScreenViewModel;
import view.HomeScreenView;

public class HomeScreenBuilder {

    public static HomeScreenView create(
            HomeScreenViewModel homeVM, ViewManagerModel viewManagerModel, HomeScreenDataAccessInterface homeDAO){
        HomeScreenController homeController = createHomeScreenUseCase(homeVM, viewManagerModel, homeDAO);
        return new HomeScreenView(homeVM, viewManagerModel, homeController);
    }

    private static HomeScreenController createHomeScreenUseCase(HomeScreenViewModel homeVM, ViewManagerModel viewManagerModel,
                                                                HomeScreenDataAccessInterface homeDAO) {
        HomeScreenOutputBoundary homeScreenOutputBoundary = new HomeScreenPresenter(homeVM, viewManagerModel);
        HomeScreenInputBoundary homeScreenInputBoundary = new HomeScreenInteractor(homeScreenOutputBoundary, homeDAO);
        ChartInputBoundary inputBoundary = new ChartInteractor(homeDAO, homeScreenOutputBoundary);

        return new HomeScreenController(homeScreenInputBoundary, inputBoundary);
    }

}
