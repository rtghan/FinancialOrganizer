package interface_adapter.home_screen;

import back_end.chart_visualisation.ChartInputBoundary;
import back_end.chart_visualisation.ChartInputData;
import back_end.home_screen.HomeScreenInputBoundary;
import back_end.home_screen.HomeScreenInputData;

/**
 * controller for home screen - interacts with input data/chart
 */
public class HomeScreenController{

    private final HomeScreenInputBoundary homeScreenInteractor;
    private final ChartInputBoundary chartInteractor;

    /**
     * constructor for home screen controller with specification:
     * @param homeScreenInteractor  home screen interactor
     * @param chartInteractor       chart interactor
     */
    public HomeScreenController(HomeScreenInputBoundary homeScreenInteractor, ChartInputBoundary chartInteractor) {
        this.homeScreenInteractor = homeScreenInteractor;
        this.chartInteractor = chartInteractor;
    }

    /**
     * executes home screen interactor with specified input data
     * @param homeScreenInputData   input data
     * @throws Exception
     */
    public void execute(HomeScreenInputData homeScreenInputData) throws Exception {
        homeScreenInteractor.execute(homeScreenInputData);
    }

    /**
     * executes chart interactor with specified input data
     * @param chartInputData    input data
     */
    public void chart(ChartInputData chartInputData){
        chartInteractor.execute(chartInputData);
    }
}
