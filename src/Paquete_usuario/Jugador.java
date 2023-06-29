package Paquete_usuario;

import Compania.Coleccion;
import Excepciones.JuegoYaEnColeccionException;
import compra_juego.JuegoFuncional;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Jugador extends Usuario implements Serializable
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
        //setCategoria(categoria);
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



    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    public Coleccion<String, JuegoFuncional> getColeccion() {
        return coleccion;
    }

    /**
     * comprobar si el usuario ya tiene una coleccion iniciada
     * @return-true para si, false para no
     */
    public boolean EstadoColeccion()
    {
        if (coleccion!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setColeccion(Coleccion<String, JuegoFuncional> coleccion) {
        this.coleccion = coleccion;
    }


    /*public Compra nuevaCompra (){
        Compra nuevaCompra = new Compra();

        return nuevaCompra();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return isActivo == jugador.isActivo && Objects.equals(mail, jugador.mail) && Objects.equals(coleccion, jugador.coleccion) && Objects.equals(categoria, jugador.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, isActivo, coleccion, categoria);
    }

    @Override
    public String toString() {
        return  super.toString()+
                "mail='" + mail + '\'' +
                ", isActivo=" + isActivo +'}'+"\n"
                //+muestraColeccion()
                ;
    }

    /**
     * Muestra la coleccion
     * @return-Los juegos de la coleccion
     */
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

    /**
     * USAR SI JUGADOR NO TIENE COLECCION PREVIA
     * @param juego
     * @throws JuegoYaEnColeccionException
     */
    public void agregarColeccion (JuegoFuncional juego) throws JuegoYaEnColeccionException
    {
        coleccion=new Coleccion<>();
        try {
            coleccion.agregarAColeccion(juego.getGame(),juego);
        }catch (JuegoYaEnColeccionException e)
        {
            e.getMessage();
        }

    }

    /**
     * Si jugador ya tenia coleccion
     * @param juego
     * @throws JuegoYaEnColeccionException
     */
    public void agregarColeccionConColeccion (JuegoFuncional juego) throws JuegoYaEnColeccionException
    {
        //coleccion=new Coleccion<>();
        try {
            coleccion.agregarAColeccion(juego.getGame(),juego);
        }catch (JuegoYaEnColeccionException e)
        {
            e.getMessage();
        }
    }


}
