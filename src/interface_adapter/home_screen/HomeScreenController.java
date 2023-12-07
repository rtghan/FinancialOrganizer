package interface_adapter.home_screen;

import back_end.chart_visualisation.ChartInputBoundary;
import back_end.chart_visualisation.ChartInputData;
import back_end.home_screen.HomeScreenInputBoundary;
import back_end.home_screen.HomeScreenInputData;

public class HomeScreenController{

    private final HomeScreenInputBoundary homeScreenInteractor;
    private final ChartInputBoundary chartInteractor;

    public HomeScreenController(HomeScreenInputBoundary homeScreenInteractor, ChartInputBoundary chartInteractor) {
        this.homeScreenInteractor = homeScreenInteractor;
        this.chartInteractor = chartInteractor;
    }

    public void execute(HomeScreenInputData homeScreenInputData) throws Exception {
        homeScreenInteractor.execute(homeScreenInputData);
    }

    public void chart(ChartInputData chartInputData){
        chartInteractor.execute(chartInputData);
    }
}
