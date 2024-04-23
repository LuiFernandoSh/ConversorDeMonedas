package conversordemonedas;

public class ExchangeRateAPIException extends Exception {
    // Constructor que recibe un mensaje de error
    public ExchangeRateAPIException(String message) {
        // Llama al constructor de la superclase (Exception) con el mensaje proporcionado
        super(message);
    }
}
