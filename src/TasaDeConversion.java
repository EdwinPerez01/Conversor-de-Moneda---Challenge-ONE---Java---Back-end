import java.time.LocalDateTime;

public class TasaDeConversion {
    private Moneda monedaOrigen;
    private Moneda monedaDestino;
    private double tasa;
    private LocalDateTime marcaTiempo;

    public TasaDeConversion(Moneda monedaOrigen, Moneda monedaDestino, double tasa) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tasa = tasa;
        this.marcaTiempo = LocalDateTime.now();
    }

    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }

    public Moneda getMonedaDestino() {
        return monedaDestino;
    }

    public double getTasa() {
        return tasa;
    }

    public LocalDateTime getMarcaTiempo() {
        return marcaTiempo;
    }
}
