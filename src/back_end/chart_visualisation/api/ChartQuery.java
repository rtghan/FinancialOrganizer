package back_end.chart_visualisation.api;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * An abstract class for sending GET request to api
 */
public abstract class ChartQuery {
    /**
     * Takes in preconstructed param and requests the API
     * @param param String
     * @return BufferedImage
     * @throws Exception
     */
    public static BufferedImage executeGet(String param) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        String test = "https://quickchart.io/chart?c=" + param;
        System.out.println(test);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(test))
                .setHeader("Content-type", "application/json")
                .GET()
                .build();
        InputStream inStream = client.send(request, HttpResponse.BodyHandlers.ofInputStream()).body();
        BufferedImage in = ImageIO.read(inStream);
        File file = new File("./test.png");
        ImageIO.write(in, "png", file);
        return in;
        }
}
