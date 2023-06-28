package Compania;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class Carrito<T>
{
    private int idCarrito;
    private static int id = -1;
    private Date fecha;
    private String tipoPago;
    private boolean isPago;
    private double descuento;
    private ArrayList<T> lista;
    private double precioTotalCompra;


    public Carrito() {
        idCarrito = ++id;
        lista = new ArrayList<T>();
        fecha = new Date();
    }

    public double getPrecioTotalCompra() {
        return precioTotalCompra;
    }

    public void setPrecioTotalCompra(double precioTotal) {
        this.precioTotalCompra = precioTotal;
    }

    /**
     * @return the idCarrito
     */
    public int getIdCarrito() {
        return idCarrito;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @return the tipoPago
     */
    public String getTipoPago() {
        return tipoPago;
    }

    /**
     * @return the isPago
     */
    public boolean isPago() {
        return isPago;
    }

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }


    /**
     * @param idCarrito the idCarrito to set
     */
    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @param tipoPago the tipoPago to set
     */
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    /**
     * @param isPago the isPago to set
     */
    public void setPago(boolean isPago) {
        this.isPago = isPago;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the lista
     */
    public ArrayList<T> getLista() {
        return lista;
    }

    public void agregarCarrito(T compra)
    {
        lista.add(compra);
    }

    public void setLista(ArrayList<T> lista) {
        this.lista = lista;
    }

    //permite mostrar el carrito completo

    public String mostrarCarrito() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            builder.append(lista.get(i).toString() + "\n");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "idCarrito=" + idCarrito +
                ", fecha=" + fecha +
                ", tipoPago='" + tipoPago + '\'' +
                ", lista=" + lista +
                ", precioTotalCompra=" + precioTotalCompra +
                '}';
    }
}
