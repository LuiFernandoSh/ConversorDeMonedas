package conversordemonedas;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ingresa tu API Key aquí
        String apiKey = "";

        // Crea una instancia de ExchangeRateAPI con tu API Key
        ExchangeRateAPI exchangeRateAPI = new ExchangeRateAPI(apiKey);

        // Utilizamos try-with-resources para asegurar que el Scanner se cierre correctamente
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;
            while (!salir) {
                System.out.println("=============================================");
                System.out.println("           Conversor de Monedas");
                System.out.println("=============================================");
                System.out.println("Tasas de conversión disponibles:");
                System.out.println("1. MXN");
                System.out.println("2. EUR");
                System.out.println("3. GBP");
                System.out.println("4. CAD");
                System.out.println("5. JPY");
                System.out.println("6. SALIR");
                System.out.print("Seleccione la moneda de destino (número): ");
                int seleccionDestino = scanner.nextInt();
                if (seleccionDestino == 6) {
                    salir = true;
                    continue;
                }
                System.out.print("Ingrese la cantidad en USD: ");
                double cantidad = scanner.nextDouble();
                String monedaDestino = "";
                switch (seleccionDestino) {
                    case 1:
                        monedaDestino = "MXN";
                        break;
                    case 2:
                        monedaDestino = "EUR";
                        break;
                    case 3:
                        monedaDestino = "GBP";
                        break;
                    case 4:
                        monedaDestino = "CAD";
                        break;
                    case 5:
                        monedaDestino = "JPY";
                        break;
                }
                try {
                    // Obtener tasas de cambio y calcular la cantidad convertida
                    JsonNode exchangeRatesResponse = exchangeRateAPI.getExchangeRates("USD");
                    double tasaDeCambio = exchangeRateAPI.getExchangeRate(exchangeRatesResponse, monedaDestino);
                    double cantidadConvertida = cantidad * tasaDeCambio;
                    // Mostrar resultado
                    System.out.println("=============================================");
                    System.out.println("RESULTADO:");
                    System.out.println(cantidad + " USD equivale a " + cantidadConvertida + " " + monedaDestino);
                    System.out.println("=============================================");
                } catch (ExchangeRateAPIException e) {
                    // Manejar excepciones específicas de ExchangeRateAPI
                    System.err.println("Error al obtener las tasas de cambio: " + e.getMessage());
                } catch (Exception e) {
                    // Manejar otras excepciones
                    System.err.println("Error inesperado: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            // Manejar excepciones en el manejo del Scanner
            System.err.println("Error al utilizar el Scanner: " + e.getMessage());
        }
    }
}

