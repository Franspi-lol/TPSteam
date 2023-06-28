package Paquete_usuario;

import Compania.Coleccion;
import Excepciones.JuegoYaEnColeccionException;
import Interface.ICategoria;
import compra_juego.JuegoNOUSAR;
import compra_juego.JuegoFuncional;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

public class Jugador extends Usuario implements Serializable, ICategoria
{
    private String mail;
    private boolean isActivo;
    private Coleccion<String, JuegoFuncional> coleccion;
    private String categoria;

    public Jugador() {
    }

    /**
     *
     * @param nombre
     * @param apellido
     * @param usuario
     * @param contrasena
     * @param mail
     * @param isActivo
     */
    public Jugador(String nombre, String apellido, String usuario, String contrasena, String mail, boolean isActivo) {
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

    public Coleccion<String, JuegoFuncional> getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion<String, JuegoFuncional> coleccion) {
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
                ", isActivo=" + isActivo +'}'+"\n"+
                muestraColeccion()
                ;
    }
     public String muestraColeccion()
     {
         String devolver=new String();
        Iterator iterator=coleccion.getIterator();
        while (iterator.hasNext())
        {
            Map.Entry entry=(Map.Entry) iterator.next();
            devolver=devolver+entry.toString();
        }
        return devolver;
     }
    public void agregarColeccion (JuegoFuncional juego) throws JuegoYaEnColeccionException
    {
        coleccion.agregarAColeccion(juego.getGame(),juego);
    }

}
