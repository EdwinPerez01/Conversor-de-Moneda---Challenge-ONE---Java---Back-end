import java.util.HashMap;

public class ConvertidorDeMoneda {
    private HistorialDeConversiones historial;
    private HashMap<String, Double> tasas;

    public ConvertidorDeMoneda(HashMap<String, Double> tasas) {
        this.historial = new HistorialDeConversiones();
        this.tasas = tasas;
    }

    public double convertir(String codigoOrigen, String codigoDestino, double cantidad) {
        if (!tasas.containsKey(codigoOrigen) || !tasas.containsKey(codigoDestino)) {
            throw new IllegalArgumentException("Moneda no soportada");
        }
        double tasa = tasas.get(codigoDestino) / tasas.get(codigoOrigen);
        double cantidadConvertida = cantidad * tasa;

        historial.agregarConversion(new TasaDeConversion(
                new Moneda(codigoOrigen, codigoOrigen),
                new Moneda(codigoDestino, codigoDestino),
                tasa
        ));
        return cantidadConvertida;
    }

    public HistorialDeConversiones getHistorial() {
        return historial;
    }
}
