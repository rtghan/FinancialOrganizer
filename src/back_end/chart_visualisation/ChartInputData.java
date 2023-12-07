package back_end.chart_visualisation;

import java.time.Month;

/**
 * Data package for Chart usecase
 */
public class ChartInputData {
    Month month;

    /**
     * Constructs an Instance of ChartInputData
     * @param month Month
     */
    public ChartInputData(Month month){
        this.month = month;
    }

    /**
     * Getter for instance month
     * @return Month
     */
    public Month getMonth(){
        return this.month;
    }

}
