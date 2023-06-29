package Paquete_usuario;

import Excepciones.JuegoYaEnColeccionException;
import compra_juego.JuegoFuncional;

import java.io.Serializable;

public abstract class Usuario implements Serializable
{
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private int idUsuario;
    private static int id = 0;

    public Usuario()
    {
        this.idUsuario=++id;
    }

    public Usuario(String nombre, String apellido, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        setId(id++);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Usuario.id = id;
    }

    @Override
    public String toString() {//
        return  "\nID=" + idUsuario +
                "\nnombre='" + nombre + '\'' +
                ", \napellido='" + apellido + '\'' +
                ", \nusuario='" + usuario + '\'' +
                ", \ncontrasena='" + contrasena + '\''

                ;
    }

    //public abstract void agregarColeccion(JuegoFuncional a) throws JuegoYaEnColeccionException;
}
