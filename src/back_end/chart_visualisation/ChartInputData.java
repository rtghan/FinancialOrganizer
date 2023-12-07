package back_end.chart_visualisation;

import java.time.Month;

public class ChartInputData {
    Month month;
    public ChartInputData(Month month){
        this.month = month;
    }

    public Month getMonth(){
        return this.month;
    }

}
