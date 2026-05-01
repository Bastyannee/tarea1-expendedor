public abstract class Moneda {
    
    public Moneda() {
    }

    public int getSerie() {
        //hashCode() nos da un entero basado en la dirección de memoria
        return this.hashCode();
    }

    public abstract int getValor();

    @Override
    public String toString() {
        return "Moneda de $" + getValor() + " (Serie: " + getSerie() + ")";
    }
}
