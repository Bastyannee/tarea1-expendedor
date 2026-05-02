import java.util.Scanner;

public class main_interactivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * // Iniciamos con 5 productos de cada uno
         */
        Expendedor exp = new Expendedor(5);

        while (true) {
            System.out.println("\n--- MÁQUINA EXPENDEDORA ---");
            System.out.println("1) Comprar Producto");
            System.out.println("2) Salir");
            int eleccion = sc.nextInt();

            if (eleccion == 2) {
                System.out.println("Gracias por usar la máquina");
                break;
            }

            // 1. Selección de Moneda
            System.out.println("Seleccione su moneda: 1) $100  2) $500  3) $1000");
            int tipoMoneda = sc.nextInt();
            Moneda monedaEntregada = null;

            if (tipoMoneda == 1) monedaEntregada = new Moneda100();
            else if (tipoMoneda == 2) monedaEntregada = new Moneda500();
            else if (tipoMoneda == 3) monedaEntregada = new Moneda1000();

            // 2. Selección de Producto (Usando tu Enumeración)
            System.out.println("Seleccione producto: 1) CocaCola  2) Sprite  3) Fanta  4) Snickers  5) Super8");
            int seleccionProd = sc.nextInt();

            // Aquí debes convertir el número a tu constante de la Enumeración
            Enumeracion TipoProducto = null;
            switch (seleccionProd) {
                case 1 -> TipoProducto = Enumeracion.COCA_COLA;
                case 2 -> TipoProducto = Enumeracion.SPRITE;
                case 3 -> TipoProducto = Enumeracion.FANTA;
                case 4 -> TipoProducto = Enumeracion.SNICKERS;
                case 5 -> TipoProducto = Enumeracion.SUPER8;
            }

            // 3. Intento de Compra con Manejo de Errores
            try {
                Comprador cliente = new Comprador(monedaEntregada, TipoProducto, exp);[cite: 1]
                System.out.println("¡Éxito! Consumiste: " + cliente.queConsumiste());[cite: 1]
                System.out.println("Tu vuelto total es: $" + cliente.cuantoVuelto());[cite: 1]
            } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
                System.out.println("Error en la compra: " + e.getMessage());[cite: 1]
            }
        }
    }
}