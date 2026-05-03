import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase encargada de realizar las pruebas técnicas del sistema expendedor.
 * Evalúa el funcionamiento de las excepciones, el polimorfismo y el ordenamiento de monedas.
 */
public class MainPruebas {

    /**
     * Punto de entrada para las pruebas unitarias y de lógica.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        // 1. Inicialización del Expendedor
        Expendedor exp = new Expendedor(2);
        Comprador c = null;

        System.out.println("PRUEBAS DE FUNCIONAMIENTO EXITOSO");
        try {
            // Se cambió "Enumeracion" por "TipoProducto"
            c = new Comprador(new Moneda1000(), TipoProducto.COCA_COLA, exp);
            System.out.println("Consumí: " + c.queConsumiste() + " | Vuelto: $" + c.cuantoVuelto());

            c = new Comprador(new Moneda500(), TipoProducto.SUPER8, exp);
            System.out.println("Consumí: " + c.queConsumiste() + " | Vuelto: $" + c.cuantoVuelto());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        System.out.println("\n PRUEBAS DE EXCEPCIONES");

        // Prueba: Pago Incorrecto (Moneda null)
        try {
            c = new Comprador(null, TipoProducto.FANTA, exp);
        } catch (PagoIncorrectoException e) {
            System.out.println("Capturada: " + e.getMessage());
        } catch (Exception e) { e.printStackTrace(); }

        // Prueba: Pago Insuficiente
        try {
            c = new Comprador(new Moneda100(), TipoProducto.COCA_COLA, exp);
        } catch (PagoInsuficienteException e) {
            System.out.println("Capturada: " + e.getMessage());
        } catch (Exception e) { e.printStackTrace(); }

        System.out.println("\n PRUEBA DE ORDENAMIENTO");
        ArrayList<Moneda> lista = new ArrayList<>();
        lista.add(new Moneda100());
        lista.add(new Moneda1000());
        lista.add(new Moneda500());

        Collections.sort(lista);

        for (Moneda m : lista) {
            System.out.println(m.toString());
        }
    }
}