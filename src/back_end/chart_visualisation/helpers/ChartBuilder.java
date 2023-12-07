package back_end.chart_visualisation.helpers;

import data_access.api.ChartQuery;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.HashMap;

public class ChartBuilder {
    public static BufferedImage build(String type, String[] labels, HashMap<String, ?> dataSet, int width, int height) throws Exception {
        String param = ParamBuilder.build(type, labels, dataSet,width,height);
        return ChartQuery.executeGet(param);
    }
    public static BufferedImage build(String type, String[] labels, HashMap<String, ?> dataSet) throws Exception {
        return build(type, labels, dataSet, 500, 300);
    }
    public static BufferedImage build(String type, double expense, double income) throws Exception {
        String[] labels = new String[]{"Expense Amount","Income Amount"};
        HashMap<String, Serializable> dataset = new HashMap<>();
        dataset.put("Dollars", new double[]{expense, income});
        String param = ParamBuilder.build(type, labels, dataset, 500, 300);
        return ChartQuery.executeGet(param);
    }
}
