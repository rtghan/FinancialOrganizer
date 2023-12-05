package interface_adapter.home_screen;

import java.time.LocalDateTime;
import java.time.Month;

public class HomeScreenState {

    private Boolean creationSuccess = false;
    private String selectedMonthStr = "";
    private Month month;

    public HomeScreenState() {
        this.month = LocalDateTime.now().getMonth();
    }

    public HomeScreenState(HomeScreenState copy) {
        selectedMonthStr = copy.selectedMonthStr;
    }

    public Month getMonth() {
        return this.month;
    }

    public String getMonthSelectionStr() {
        return this.selectedMonthStr;
    }

    public void setMonthSelection(String monthSelectionStr) {
        this.selectedMonthStr = monthSelectionStr;
        if (this.selectedMonthStr.equals("Current Month")) {
            this.month = LocalDateTime.now().getMonth();
        }
        else {
            this.month = Month.valueOf(this.selectedMonthStr.toUpperCase());
        }
    }

    public boolean isCreationSuccess() {
        return creationSuccess;
    }

    public void setCreationSuccess(boolean creationSuccess) {
        this.creationSuccess = creationSuccess;
    }

}
