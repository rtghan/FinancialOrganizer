package back_end.chart_visualisation.api;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChartQuery {
    HttpURLConnection connection = null;
    public static BufferedImage executeGet(String param) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        String test = "https://quickchart.io/chart?c=" + param;
        URL url = new URL("https://quickchart.io/chart");
        System.out.println(test);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(test))
                .setHeader("Content-type", "application/json")
                .GET()
                .build();
        InputStream tset = client.send(request, HttpResponse.BodyHandlers.ofInputStream()).body();
        BufferedImage in = ImageIO.read(tset);
        File file = new File("./test.png");
        ImageIO.write(in, "png", file);
        return in;
        }
}
