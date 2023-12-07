package back_end.chart_visualisation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Data Package for use with Presenter
 */
public class ChartOutputData {
    private final HashMap<String, ?> data;

    /**
     * Constucts an instance of Data Package
     * @param data Hashmap<>
     */

    public ChartOutputData(HashMap<String, ?> data){
        this.data = data;
    }

    /**
     * Getter for stored data
     * @return Hashmap<>
     */
    public HashMap<String, ?> getData() {
        return this.data;
    }
}
