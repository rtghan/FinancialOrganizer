package back_end.chart_visualisation;

import java.util.ArrayList;
import java.util.HashMap;

public class ChartOutputData {
    private final HashMap<String, Double> data;

    public ChartOutputData(HashMap<String, Double> data){
        this.data = data;
    }

    public HashMap<String, Double> getData() {
        return this.data;
    }
}
