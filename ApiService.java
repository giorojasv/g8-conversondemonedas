import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class ApiService {
    private static final String API_KEY = "2c90df4be2069258c9cffddf";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static double obtenerTasaCambio(String monedaBase, String monedaDestino) {
        try {
            URL url = new URL(BASE_URL + API_KEY + "/pair/" + monedaBase + "/" + monedaDestino);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner scanner = new Scanner(new InputStreamReader(conn.getInputStream()));
            String json = scanner.useDelimiter("\\A").next();
            scanner.close();

            JSONObject obj = new JSONObject(json);
            return obj.getDouble("conversion_rate");

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio.");
            return 0;
        }
    }
}