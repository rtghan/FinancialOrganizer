package main;

import home_screen.HomeScreenDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenViewModel;
import view.HomeScreenView;

public class HomeScreenFactory {

    public static HomeScreenView create(
            HomeScreenViewModel homeVM, ViewManagerModel viewManagerModel){
        return new HomeScreenView(homeVM, viewManagerModel);
    }

}
