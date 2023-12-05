package interface_adapter.home_screen;

import java.time.LocalDateTime;
import java.time.Month;

public class HomeScreenState {

    private Month selectedMonth;

    public HomeScreenState() {
        this.selectedMonth = LocalDateTime.now().getMonth();
    }

    public Month getSelectedMonth() {
        return selectedMonth;
    }


}
