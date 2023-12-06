package back_end.home_screen;

import java.time.Month;

/**
 * represents input data (month) for the home screen
 */
public class HomeScreenInputData {
    private final Month month;

    /**
     * constructs input data object for home screen
     * @param month     month
     */
    public HomeScreenInputData(Month month) {
        this.month = month;
    }

    /**
     * gets the current month for home screen
     * @return month
     */
    public Month getMonth() {
        return month;
    }
}
