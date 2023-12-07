package back_end.chart_visualisation.helpers;

import back_end.chart_visualisation.api.ChartQuery;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.HashMap;

public class ChartBuilderFacade {
    /**
     * Takes in the given input, requests ParamBuilder to construct string representation of Parameter
     * and queries the API
     * @param type String
     * @param labels String[]
     * @param dataSet Hashmap<>
     * @param width int
     * @param height int
     * @return BufferedImage
     * @throws Exception
     */
    public static BufferedImage build(String type, Object[] labels, HashMap<String, ?> dataSet, int width, int height) throws Exception {
        String param = ParamBuilder.build(type, labels, dataSet,width,height);
        if(type.equals("doughnut")){
            HashMap<String,?> data = DoughnutChart.build(dataSet);
            param = ParamBuilder.build(type, labels, data,width,height);
            return ChartQuery.executeGet(param);
        }
        return ChartQuery.executeGet(param);
    }

    /**
     * Function Overloading for default values
     * @param type String
     * @param labels String[]
     * @param dataSet Hashmap<>
     * @return BufferedImage
     * @throws Exception
     */
    public static BufferedImage build(String type, Object[] labels, HashMap<String, ?> dataSet) throws Exception {
        return build(type, labels, dataSet, 500, 300);
    }
    /**
     * Function Overloading for only two inputs.
     * @param type String
     * @param expense double
     * @param income double
     * @return BufferedImage
     * @throws Exception
     */
    public static BufferedImage build(String type, double expense, double income) throws Exception {
        String[] labels = new String[]{"Expense Amount","Income Amount"};
        HashMap<String, Serializable> dataset = new HashMap<>();
        dataset.put("Dollars", new double[]{expense, income});
        String param = ParamBuilder.build(type, labels, dataset, 500, 300);
        return ChartQuery.executeGet(param);
    }
}
