import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ClienteAPI clienteAPI = new ClienteAPI();
        HashMap<String, Double> tasas = clienteAPI.obtenerTasas();
        ConvertidorDeMoneda convertidor = new ConvertidorDeMoneda(tasas);

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Ver historial de conversiones");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese la cantidad en USD:");
                    double cantidadEnUSD = scanner.nextDouble();

                    System.out.println("Elija la moneda a la que desea convertir:");
                    System.out.println("1. ARS (Peso argentino)");
                    System.out.println("2. BOB (Boliviano boliviano)");
                    System.out.println("3. BRL (Real brasileño)");
                    System.out.println("4. CLP (Peso chileno)");
                    System.out.println("5. COP (Peso colombiano)");
                    int eleccion = scanner.nextInt();

                    String codigoDestino = switch (eleccion) {
                        case 1 -> "ARS";
                        case 2 -> "BOB";
                        case 3 -> "BRL";
                        case 4 -> "CLP";
                        case 5 -> "COP";
                        default -> throw new IllegalArgumentException("Opción no válida");
                    };

                    double cantidadConvertida = convertidor.convertir("USD", codigoDestino, cantidadEnUSD);
                    System.out.println(cantidadEnUSD + " USD es igual a " + cantidadConvertida + " " + codigoDestino);
                }
                case 2 -> {
                    System.out.println("Historial de conversiones:");
                    if (convertidor.getHistorial().getHistorial().isEmpty()) {
                        System.out.println("No hay conversiones registradas.");
                    } else {
                        for (TasaDeConversion conversion : convertidor.getHistorial().getHistorial()) {
                            System.out.println("Conversión de " + conversion.getMonedaOrigen().getCodigo() +
                                    " a " + conversion.getMonedaDestino().getCodigo() +
                                    ", tasa: " + conversion.getTasa() +
                                    ", fecha: " + conversion.getMarcaTiempo());
                        }
                    }
                }
                case 3 -> continuar = false;
                default -> System.out.println("Opción no válida. Inténtelo nuevamente.");
            }
        }
        System.out.println("Programa terminado.");
    }
}
