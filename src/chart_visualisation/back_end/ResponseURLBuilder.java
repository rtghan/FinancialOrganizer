package chart_visualisation.back_end;
import org.json.*;

import java.net.URLEncoder;
import java.util.ArrayList;

abstract class ResponseURLBuilder {

    public static String build(double spendingamt, double savingamt, double investamt){
        // Array Setups
        String[] labels = {"Spending Amount", "Saving Amount", "Investment Amount"};
        Double[] amt = {spendingamt, savingamt, investamt};
        // Json Setup
        JSONObject outerData = new JSONObject();
        outerData.put("labels", labels);

        JSONObject dataSets = new JSONObject();
        dataSets.put("label", "Dollar");

        ArrayList dataSetsArray = new ArrayList();
        dataSetsArray.add(dataSets);
        dataSets.put("data", amt);
        outerData.put("datasets",dataSetsArray);

        JSONObject outputJson = new JSONObject();
        outputJson.put("type", "bar");
        outputJson.put("data", outerData);

        return "?c=" + URLEncoder.encode(outputJson.toString());
    }

}
