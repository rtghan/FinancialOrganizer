package data_access.api;

import back_end.investment_value.InvestmentValueDataAccessInterface;
import org.json.JSONObject;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * A class which allows you to retrieve stock prices given the name of the stock, and the purchase date of the stock.
 * Must have an approparite API key.
 */
public class StockQuery implements InvestmentValueDataAccessInterface {
    private String key;

    /**
     * Creates a new instance of a StockQuery object, with the API key specified in the constructor
     * @param key       A valid API key that allows the HTTP requests to go through
     */
    public StockQuery(String key) {
        this.key = key;
    }

    /**
     * Returns the price of a stock (specified by its name) at a given point in time.
     * @param stockName     The name of the stock whose value will be queried
     * @param purchaseDate  The date of the stock whose value will be queried
     * @return
     */
    public Double getPrice(String stockName, LocalDate purchaseDate) {
        String query = stockName + "/" + purchaseDate.toString() + "?adjusted=true&apiKey=" + this.key;
        String urlBase = "https://api.polygon.io/v1/open-close/" + query;
        String response = "";
        BigDecimal price = new BigDecimal(0);
        try{
            response = getURLResponse(urlBase);
            System.out.println("Response for " + purchaseDate.toString() + " " + response);
            JSONObject data = new JSONObject(response);
            price = (BigDecimal) data.get("close");
        }
        catch (Exception e) {
            System.out.println("Something went wrong, output: " + response);
        }

        return price.doubleValue();
    }
    private String getURLResponse(String requestURL) throws Exception {
        URL url = new URL(requestURL);

        // connect
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();

        // write the response to a string
        String response = "";
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()) {
            response += scanner.nextLine();
        }

        scanner.close();
        return response;
    }
    public static void main(String[] args) throws Exception {
        StockQuery priceGetter = new StockQuery("ayODBObam0Um8BBlk3EZ7_F4Tgx0JpR7");
        System.out.println(priceGetter.getPrice("AAPL", LocalDate.of(2023,1,9)));
        // expect 130.15, with proper key
    }
}
