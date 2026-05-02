import java.util.ArrayList;
import java.util.Collections;

public class main_pruebas {
    public static void main(String[] args) {
        /**
         * Inicializacion del Expendedor con 2 unidades por producto
         */
        Expendedor exp = new Expendedor(2);[cite: 1]
        Comprador c = null;

        System.out.println("pruebas de funcionamiento");
        try {
            /**
             * Compra exitosa: Moneda de 1000 para un producto barato
             * Suponiendo que usas la Enumeración para elegir el producto
             */
            c = new Comprador(new Moneda1000(), Enumeracion.COCA_COLA, exp);[cite: 1]
            System.out.println("Consumí: " + c.queConsumiste() + " | Vuelto: $" + c.cuantoVuelto());[cite: 1]

            c = new Comprador(new Moneda500(), Enumeracion.SUPER8, exp);
            System.out.println("Consumí: " + c.queConsumiste() + " | Vuelto: $" + c.cuantoVuelto());
        } catch (Exception e) {
            System.out.println("Error inesperado en prueba exitosa: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBAS DE EXCEPCIONES ---");

        /**
         * Prueba 1: Pago Incorrecto (Moneda null)
         */
        try {
            c = new Comprador(null, Enumeracion.FANTA, exp);[cite: 1]
        } catch (PagoIncorrectoException e) {
            System.out.println("Capturada: " + e.getMessage());[cite: 1]
        } catch (Exception e) { e.printStackTrace(); }

        /**
         * Prueba 2: Pago Insuficiente
         */
        try {
            c = new Comprador(new Moneda100(), Enumeracion.COCA_COLA, exp);[cite: 1]
        } catch (PagoInsuficienteException e) {
            System.out.println("Capturada: " + e.getMessage());[cite: 1]
        } catch (Exception e) { e.printStackTrace(); }

        // Prueba 3: No Hay Producto (Vaciando el depósito)
        try {
            // Ya compramos 2 Coca Colas antes, la tercera debería fallar
            c = new Comprador(new Moneda1000(), Enumeracion.COCA_COLA, exp);[cite: 1]
        } catch (NoHayProductoException e) {
            System.out.println("Capturada: " + e.getMessage());[cite: 1]
        } catch (Exception e) { e.printStackTrace(); }

        System.out.println("\n--- PRUEBA DE ORDENAMIENTO DE MONEDAS ---");
        ArrayList<Moneda> inventarioMonedas = new ArrayList<>();
        inventarioMonedas.add(new Moneda100());
        inventarioMonedas.add(new Moneda1000());
        inventarioMonedas.add(new Moneda500());
        inventarioMonedas.add(new Moneda100());

        System.out.println("Antes de ordenar: " + inventarioMonedas);
        Collections.sort(inventarioMonedas);[cite: 1]
        System.out.println("Después de ordenar: " + inventarioMonedas);[cite: 1]
    }
}
