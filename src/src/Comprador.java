import excepciones.NoHayProductoException;
import excepciones.PagoIncorrectoException;
import excepciones.PagoInsuficienteException;

public class Comprador {
    private String producto;
    private int vuelto;

    /*
    * aquí el comprador intentará comprar en el expendedor.
    * - introduce una moneda (m)
    * - introduce el producto deseado.
    * entonces el expendedor devolverá un producto a menos que se lance una excepción si corresponde.
     */
    public Comprador(Moneda mon, Productos p, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Producto prod =
                /*
                * en este espacio haré que el comprador compre el producto, pero necesito el nombre de las clases para ello.
                * idea:
                *  if (producto != null){
                *  producto = producto.comsumir();
                * } else {
                * producto == null;
                * }
                 */
        Moneda mon;
        while ((mon = exp. getVuelto()) != null) {
            vuelto += mon.getValor();
            /*
            * mismo problema que el anterior, estas clases no sé si serán de este nombre en el archivo final.
             */
        }
    }

    /*
    * retorna el total de dinero recibido como vuelto.
     */
    public int cuantoVuelto() {
        return vuelto;
    }

    /*
    * retorna que producto se consumió como string
     */
    public String queConsumiste(){
        return producto;
    }
}
