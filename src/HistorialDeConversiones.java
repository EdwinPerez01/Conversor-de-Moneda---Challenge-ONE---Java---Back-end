import java.util.ArrayList;

public class HistorialDeConversiones {
    private ArrayList<TasaDeConversion> historial;

    public HistorialDeConversiones() {
        this.historial = new ArrayList<>();
    }

    public void agregarConversion(TasaDeConversion conversion) {
        historial.add(conversion);
    }

    public ArrayList<TasaDeConversion> getHistorial() {
        return historial;
    }
}
