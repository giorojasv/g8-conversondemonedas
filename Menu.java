import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Conversor de Monedas ===");
            System.out.println("1. Dólar => Peso argentino");
            System.out.println("2. Peso argentino => Dólar");
            System.out.println("3. Dólar => Real brasileño");
            System.out.println("4. Real brasileño => Dólar");
            System.out.println("5. Euro => Dólar");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            if (opcion == 6) break;

            String from = "", to = "";

            switch (opcion) {
                case 1: from = "USD"; to = "ARS"; break;
                case 2: from = "ARS"; to = "USD"; break;
                case 3: from = "USD"; to = "BRL"; break;
                case 4: from = "BRL"; to = "USD"; break;
                case 5: from = "EUR"; to = "USD"; break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            System.out.print("Ingresa el valor a convertir: ");
            double cantidad = scanner.nextDouble();

            double tasa = ApiService.obtenerTasaCambio(from, to);
            double resultado = Conversor.convertir(cantidad, tasa);
            System.out.printf("El valor de %.2f %s equivale a %.2f %s\n", cantidad, from, resultado, to);
        }
    }
}