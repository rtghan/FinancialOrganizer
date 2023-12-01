package interface_adapter.home_screen;

import home_screen.HomeScreenOutputBoundary;
import home_screen.HomeScreenOutputData;

public class HomeScreenPresenter implements HomeScreenOutputBoundary {

    private final HomeScreenViewModel homescreenVM;

    public HomeScreenPresenter(HomeScreenViewModel homescreenVM) {
        this.homescreenVM = homescreenVM;
    }

    @Override
    public void prepareSuccessView(HomeScreenOutputData outputData) {

    }

}


