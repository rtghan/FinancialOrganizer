package back_end.chart_visualisation.helpers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Abstract Class to clean Information for ChartBuilder
 */
public abstract class DoughnutChart {
    /**
     * Takes in hashmap, packages it for use with Chartbuilder
     * @param data Hashmap<>
     * @return Buffered Image
     * @throws Exception
     */
    public static HashMap<String,?> build(HashMap<String, ?> data) throws Exception {
        System.out.println(data);
        String[] labels = data.keySet().toArray(new String[0]);
        HashMap<String, Collection> dataSet = new HashMap<>();
        dataSet.put("Expense", data.values());
        return dataSet;
    }

}
