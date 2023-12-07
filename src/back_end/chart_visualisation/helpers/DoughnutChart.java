package back_end.chart_visualisation.helpers;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public abstract class DoughnutChart {
    public static BufferedImage build(HashMap<String, Double> data) throws Exception {
        String[] labels = new String[]{"Expense"};
        return ChartBuilder.build("doughnut",labels, data);
    }

}
