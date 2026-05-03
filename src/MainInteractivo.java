import java.util.Scanner;
/**
 * Clase principal que ejecuta la interfaz interactiva de la máquina.
 * Permite la compra sucesiva de productos hasta que el usuario sale.
 */
public class MainInteractivo {
    /**
     * Punto de entrada para las pruebas unitarias y de lógica.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //se inicia con 5 productos
        Expendedor exp = new Expendedor(5);

        while (true) {
            System.out.println("\n--- git MÁQUINA EXPENDEDORA ---");
            System.out.println("1) Comprar Producto");
            System.out.println("2) Salir");

            if (!sc.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido.");
                sc.next();
                continue;
            }

            int eleccion = sc.nextInt();

            if (eleccion == 2) {
                System.out.println("Gracias por usar la máquina");
                break;
            }

            //seleccion de la moneda
            System.out.println("Seleccione su moneda: 1) $100  2) $500  3) $1000");
            int tipoMoneda = sc.nextInt();
            Moneda monedaEntregada = null;

            if (tipoMoneda == 1) monedaEntregada = new Moneda100();
            else if (tipoMoneda == 2) monedaEntregada = new Moneda500();
            else if (tipoMoneda == 3) monedaEntregada = new Moneda1000();


            //Selección de Producto (Usando TipoPodructo))

            System.out.println("Seleccione producto: 1) CocaCola  2) Sprite  3) Fanta  4) Snickers  5) Super8");
            int seleccionProd = sc.nextInt();

            // Aquí se usa la enumeracion para elegir el producto
            TipoProducto productoElegido = null;

            switch (seleccionProd) {
                case 1 -> productoElegido = TipoProducto.COCA_COLA;
                case 2 -> productoElegido = TipoProducto.SPRITE;
                case 3 -> productoElegido = TipoProducto.FANTA;
                case 4 -> productoElegido = TipoProducto.SNICKERS;
                case 5 -> productoElegido = TipoProducto.SUPER8;
            }

            //manejo de errores
            try {
                Comprador cliente = new Comprador(monedaEntregada, productoElegido, exp);
                System.out.println("Consumiste: " + cliente.queConsumiste());
                System.out.println("Tu vuelto total es: $" + cliente.cuantoVuelto());
            } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
                System.out.println("Error en la compra: " + e.getMessage());
            }
        }
    }
}