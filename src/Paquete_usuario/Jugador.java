package Paquete_usuario;

import Compania.Coleccion;
import Interface.ICategoria;
import compra_juego.Juego;

import java.io.Serializable;

public class Jugador extends Usuario implements Serializable, ICategoria
{
    private String mail;
    private boolean isActivo;
    private Coleccion<String, Juego> coleccion;
    private String categoria;


    public Jugador() {
        super(nombre, apellido, usuario, contrasena);
        this.mail = mail;
        this.isActivo = isActivo;
        setId(getId());
        setCategoria(categoria);
        coleccion=new Coleccion<>();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isActivo() {
        return isActivo;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    public Coleccion<String, Juego> getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion<String, Juego> coleccion) {
        this.coleccion = coleccion;
    }


    /*public Compra nuevaCompra (){
        Compra nuevaCompra = new Compra();

        return nuevaCompra();
    }*/

    @Override
    public String toString() {
        return  super.toString()+
                "mail='" + mail + '\'' +
                ", isActivo=" + isActivo +
                //", coleccion=" + coleccion +
                '}';
    }
     public String muestraColeccion()
     {
        String aux= new String();
        return aux;
     }

}
