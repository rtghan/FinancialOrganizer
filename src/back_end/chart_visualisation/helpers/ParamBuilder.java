package back_end.chart_visualisation.helpers;

import org.json.JSONObject;

import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

abstract class ParamBuilder {
    /**
     * Constructs String Representation of parameters with given inputs.
     * @param type String
     * @param labels String[]
     * @param dataSet Hashmap<>
     * @param width int
     * @param height int
     * @return String
     */
    public static String build(String type, String[] labels, HashMap<String, ?> dataSet, int width, int height){
        // Object Instantiation
        JSONObject outJson = new JSONObject();

        // Chart Type Insertion
        outJson.put("type", type);

        // Data Set Insertion
        ArrayList<Object> setsArray = new ArrayList<Object>();
        JSONObject chartData = new JSONObject();
        for(String entry : dataSet.keySet()){
            System.out.println(dataSet.get(entry));
            JSONObject tmp = new JSONObject();
            tmp.put("label", entry);
            tmp.put("data", dataSet.get(entry));
            System.out.println(tmp);
            setsArray.add(tmp);
        }
        // Chart Data Insertion
        chartData.put("labels", labels);
        chartData.put("datasets", setsArray);
        outJson.put("data", chartData);
        System.out.println(outJson.toString()+"&width="+width+"&height="+height);
        return URLEncoder.encode(outJson.toString())+"&width="+width+"&height="+height;
    }
}
