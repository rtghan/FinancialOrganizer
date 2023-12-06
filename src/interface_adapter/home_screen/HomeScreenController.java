package interface_adapter.home_screen;

import home_screen.HomeScreenInputBoundary;
import home_screen.HomeScreenInputData;
import home_screen.HomeScreenInteractor;

public class HomeScreenController implements HomeScreenInputBoundary {

    private final HomeScreenInteractor homeScreenInteractor;

    public HomeScreenController(HomeScreenInteractor homeScreenInteractor) {
        this.homeScreenInteractor = homeScreenInteractor;
    }

    @Override
    public void execute(HomeScreenInputData homeScreenInputData) {
        homeScreenInteractor.execute(homeScreenInputData);
    }
}
