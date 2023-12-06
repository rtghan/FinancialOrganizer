package chart_visualisation;

import java.awt.image.BufferedImage;

public class ChartBuilder {
    public static BufferedImage build(double spendingamt, double savingamt, double investamt) throws Exception {
        String param = ResponseURLBuilder.build(spendingamt,savingamt,investamt);
        return ChartQuery.executeGet(param);
    }

    public static void main(String[] args) throws Exception {
        BufferedImage test = build(1,2,3);
    }
}
