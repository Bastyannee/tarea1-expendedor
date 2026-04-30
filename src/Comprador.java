import NoHayProductoException;
import PagoIncorrectoException;
import PagoInsuficienteException;

/**
 * Nota importante:
 * Los nombres de métodos y clases utilizadas (por ejemplo, getVuelto(), queConsumiste(), entre otros) deberán ser verificados y ajustados para coincidir con la versión final del proyecto.
 */

public class Comprador {
    private String producto;
    private int vuelto = 0;

    /**
     * El comprador intenta adquirir un producto desde el expendedor, ingresando una moneda y seleccionando un producto. El expendedor puede lanzar excepciones en caso de error.
     */

    public Comprador(Moneda mon, Productos p, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Producto prod = exp.comprarProducto(mon, p):

        if (prod != null) {
            this.producto = prod.consumir();
        }
        else {
            this.producto = null;
        }
        /**
         * Se obtiene el vuelto.
         */
        Moneda m;
        while ((m = exp.getVuelto()) != null) {
            vuelto = vuelto + m.getValor();
        }
    }

    /*
    * Retorna el total de dinero recibido como vuelto.
     */
    public int cuantoVuelto() {
        return vuelto;
    }

    /*
    * Retorna el producto consumido.
     */
    public String queConsumiste(){
        return producto;
    }
}
