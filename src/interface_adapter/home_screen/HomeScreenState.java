package interface_adapter.home_screen;

import java.time.LocalDateTime;
import java.time.Month;

public class HomeScreenState {

    private Month month;

    public HomeScreenState() {
        this.month = LocalDateTime.now().getMonth();
    }


}
