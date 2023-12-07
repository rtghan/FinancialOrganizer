package back_end.home_screen;

import back_end.chart_visualisation.ChartOutputData;

import java.time.Month;

/**
 * interface for preparing the success view with output data for home screen
 */
public interface HomeScreenOutputBoundary {

    /**
     * prepares the success view with the specified output data
     * @param homeScreenOutputData  output data
     */
    void prepareSuccessView(HomeScreenOutputData homeScreenOutputData) throws Exception;
    void prepareFailView();

    void preparePopup(ChartOutputData outputData);
}