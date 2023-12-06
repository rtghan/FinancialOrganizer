package interface_adapter.home_screen;

import back_end.home_screen.HomeScreenInputBoundary;
import back_end.home_screen.HomeScreenInputData;
import back_end.home_screen.HomeScreenInteractor;

public class HomeScreenController{

    private final HomeScreenInputBoundary homeScreenInteractor;

    public HomeScreenController(HomeScreenInputBoundary homeScreenInteractor) {
        this.homeScreenInteractor = homeScreenInteractor;
    }

    public void execute(HomeScreenInputData homeScreenInputData) throws Exception {
        homeScreenInteractor.execute(homeScreenInputData);
    }
}
