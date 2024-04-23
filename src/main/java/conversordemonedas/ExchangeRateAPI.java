package conversordemonedas;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateAPI {
    private final String apiKey;

    // Constructor que recibe la clave de la API
    public ExchangeRateAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    // Método para obtener las tasas de cambio desde la API
    public JsonNode getExchangeRates(String baseCurrency) throws ExchangeRateAPIException {
        try {
            // Construye la URL de la API utilizando la clave y la moneda base
            String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;
            URL url = new URL(apiUrl);

            // Establece una conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Verifica el código de respuesta
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new ExchangeRateAPIException("Error al conectar con la API: " + responseCode);
            }

            // Lee la respuesta de la API y la convierte en un objeto JsonNode
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode response = objectMapper.readTree(connection.getInputStream());
            connection.disconnect();
            return response;
        } catch (IOException e) {
            throw new ExchangeRateAPIException("Error al obtener tasas de cambio: " + e.getMessage());
        }
    }

    // Método para obtener la tasa de cambio para una moneda específica
    public double getExchangeRate(JsonNode exchangeRates, String targetCurrency) throws ExchangeRateAPIException {
        try {
            // Verifica si la respuesta contiene las tasas de cambio
            if (!exchangeRates.has("conversion_rates")) {
                throw new ExchangeRateAPIException("No se encontraron tasas de cambio en la respuesta.");
            }

            // Obtiene las tasas de cambio y verifica si la moneda objetivo está presente
            JsonNode conversionRates = exchangeRates.get("conversion_rates");
            if (!conversionRates.has(targetCurrency)) {
                throw new ExchangeRateAPIException("La moneda " + targetCurrency + " no está disponible en las tasas de cambio.");
            }

            // Retorna la tasa de cambio para la moneda objetivo
            return conversionRates.get(targetCurrency).asDouble();
        } catch (Exception e) {
            throw new ExchangeRateAPIException("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}
