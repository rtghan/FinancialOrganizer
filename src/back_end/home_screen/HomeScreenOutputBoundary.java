package back_end.home_screen;

/**
 * interface for preparing the success view with output data for home screen
 */
public interface HomeScreenOutputBoundary {

    /**
     * prepares the success view with the specified output data
     * @param homeScreenOutputData  output data
     */
    void prepareSuccessView(HomeScreenOutputData homeScreenOutputData);
    void prepareFailView();
}