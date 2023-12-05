package home_screen;

import java.time.Month;

public class HomeScreenInputData {
    private final Month month; // current month to be displayed

    public HomeScreenInputData(Month month) {
        this.month = month;
    }

    public Month getMonth() {
        return month;
    }
}
