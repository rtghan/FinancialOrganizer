package back_end.home_screen;

/**
 * interface for executing home screen with the input data
 */
public interface HomeScreenInputBoundary {
    /**
     * executes home screen with specified input data
     * @param homeScreenInputData   input data
     */
    void execute(HomeScreenInputData homeScreenInputData) throws Exception;
}
