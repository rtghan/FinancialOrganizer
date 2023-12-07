package back_end.chart_visualisation.helpers;

import back_end.chart_visualisation.api.ChartQuery;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.HashMap;

public class ChartBuilder {
    public static BufferedImage build(String type, String[] labels, HashMap<String, ?> dataSet) throws Exception {
        String param = ParamBuilder.build(type, labels, dataSet);
        return ChartQuery.executeGet(param);
    }
    public static BufferedImage build(String type, double expense, double income) throws Exception {
        String[] labels = new String[]{"Expense Amount","Income Amount"};
        HashMap<String, Serializable> dataset = new HashMap<>();
        dataset.put("Dollars", new double[]{expense, income});
        String param = ParamBuilder.build(type, labels, dataset);
        return ChartQuery.executeGet(param);
    }
}
