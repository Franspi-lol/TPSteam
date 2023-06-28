package compra_juego;

public class Compra
{
    private String nombreJuego;
    private int precioJuego;
    private int precio;

    public Compra() {
    }

    public Compra(JuegoNOUSAR juego, int precio) {
        nombreJuego = juego.getGame();
        precioJuego= juego.getPrice();
        this.precio = precio;
    }

    public String getCompra()
    {
        return nombreJuego+precio;
    }
    public void setCompra(JuegoFuncional juego)
    {
        nombreJuego=juego.getGame();
        precioJuego=juego.getPrice();
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "nombre del Juego='" + nombreJuego + '\'' +
                ", precio del Juego=$" + precioJuego +
                ", precio final=$" + precio +
                '}';
    }
}
