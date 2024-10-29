import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ClienteAPI {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/07852a949d192b369eb6707a/latest/USD";
    private HashMap<String, Double> tasas;

    public ClienteAPI() {
        this.tasas = new HashMap<>();
    }

    public HashMap<String, Double> obtenerTasas() {
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(new URI(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(respuesta.body()).getAsJsonObject();
            JsonObject tasasJSON = json.getAsJsonObject("conversion_rates");

            String[] monedas = {"USD", "ARS", "BOB", "BRL", "CLP", "COP"};
            for (String codigo : monedas) {
                if (tasasJSON.has(codigo)) {
                    tasas.put(codigo, tasasJSON.get(codigo).getAsDouble());
                }
            }

        } catch (Exception e) {
            System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
        return tasas;
    }
}
