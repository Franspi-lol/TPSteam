package Paquete_usuario;

import compra_juego.Juego;

import java.util.HashMap;

public class Jugador extends Usuario
{
    private String mail;
    private boolean isActivo;
    private HashMap<String, Juego> coleccion;


    public Jugador(String nombre, String apellido, String usuario, String contrasena, String mail, boolean isActivo) {
        super(nombre, apellido, usuario, contrasena);
        this.mail = mail;
        this.isActivo = isActivo;
        setId(getId());

        coleccion=new HashMap<>();
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

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    public HashMap<String, Juego> getColeccion() {
        return coleccion;
    }

    public void setColeccion(HashMap<String, Juego> coleccion) {
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
