package back_end.chart_visualisation.helpers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public abstract class DoughnutChart {
    public static BufferedImage build(HashMap<String, ?> data) throws Exception {
        System.out.println(data);
        String[] labels = data.keySet().toArray(new String[0]);
        HashMap<String, Collection> dataSet = new HashMap<>();
        dataSet.put("Expense", data.values());
        return ChartBuilder.build("doughnut", labels, dataSet);
    }

}
