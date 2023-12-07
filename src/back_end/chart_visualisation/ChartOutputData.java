package back_end.chart_visualisation;

import java.util.ArrayList;
import java.util.HashMap;

public class ChartOutputData {
    private final HashMap<String, ?> data;

    public ChartOutputData(HashMap<String, ?> data){
        this.data = data;
    }

    public HashMap<String, ?> getData() {
        return this.data;
    }
}
