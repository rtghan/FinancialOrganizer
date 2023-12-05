package interface_adapter.home_screen;

import java.time.LocalDateTime;
import java.time.Month;

public class HomeScreenState {

    private String selectedMonthStr = "";
    private Month selectedMonth;
    private Month currentMonth;

    public HomeScreenState() {
        this.currentMonth = LocalDateTime.now().getMonth();
    }

    public HomeScreenState(HomeScreenState copy) {
        selectedMonthStr = copy.selectedMonthStr;
    }

    public String getMonthSelection() {
        return this.selectedMonthStr;
    }

    public void setMonthSelection(String monthSelection) {
        this.selectedMonthStr = monthSelection;
        if (this.selectedMonthStr.equals("Current Month")) {
            this.selectedMonth = LocalDateTime.now().getMonth();
        }
        else {
            this.selectedMonth = Month.valueOf(this.selectedMonthStr.toUpperCase());
        }
    }g
}
