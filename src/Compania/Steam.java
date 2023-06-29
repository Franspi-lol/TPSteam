package Compania;

import Interface.IMuestra;
import ManagerArchivos.LecturaEscritura;
import Paquete_usuario.Admin;
import Paquete_usuario.Jugador;
import Paquete_usuario.Usuario;
import compra_juego.JuegoFuncional;

import java.io.File;
import java.io.IOException;
import java.util.*;
public class Steam implements IMuestra {
    private String nombreSteam;
    private LinkedHashSet<Jugador> usuarios;
    private ArrayList<JuegoFuncional> listadoJuegos;

    public Steam(String nombreSteam) {
        this.nombreSteam = nombreSteam;
        usuarios = new LinkedHashSet<>();
        listadoJuegos = new ArrayList<>();
    }
    public void nuevoAdmin (Usuario usu)
    {

    }
    public void nuevoUsuario (Jugador usuario){
        usuarios.add(usuario);
    }

    public void nuevoJuego (JuegoFuncional juego){
        listadoJuegos.add(juego);
    }

    public ArrayList<JuegoFuncional> getListadoJuegos() {
        return listadoJuegos;
    }

    public void setListadoJuegos(ArrayList<JuegoFuncional> listadoJuegos) {
        if(listadoJuegos != null){
            this.listadoJuegos = listadoJuegos;
        }
    }

    public LinkedHashSet<Jugador> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(LinkedHashSet<Jugador> usuarios) {
        if (usuarios != null){
            this.usuarios = usuarios;
        }
    }

    public String getNombreSteam() {
        return nombreSteam;
    }

    public void setNombreSupermercado(String nombreSupermercado) {
        this.nombreSteam = nombreSupermercado;
    }

    public Usuario buscarUsuarioLogin (String usr, String pass){
        for (Usuario usuario : usuarios){
            if (usuario.getUsuario().equals(usr)){
                if (usuario.getContrasena().equals(pass)){
                    if (usuario instanceof Jugador) {
                        Jugador jugador = new Jugador();
                        return jugador = (Jugador) usuario;
                    }
                    else if(usuario instanceof Admin){
                        Admin admin = new Admin();
                        return admin = (Admin) usuario;
                    }
                }
            }
        }
        return null;
    }

    public boolean buscarPorNombreUsuarioLogin (String usr) {
        boolean flag = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(usr)) {
                flag = true;
            }
        }
        return flag;
    }

    public String muestraUsuarios() {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Jugador){
                if (((Jugador) usuario).isActivo()){
                    sb.append("\n");
                    sb.append("[" + usuario + "]");
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public String muestraJuegos (){
        StringBuilder sb = new StringBuilder();
        for (JuegoFuncional juego : listadoJuegos){
                sb.append(juego.getGame());
                sb.append("\n");

        }
        return sb.toString();
    }

    public String muestraProductosParaCliente (){
        //StringBuilder sb = new StringBuilder();
        String nuevo=new String();
        LecturaEscritura lye= new LecturaEscritura();
        for (JuegoFuncional juego : listadoJuegos){

                nuevo=nuevo+juego.getGame().toString()+"\n";

        }
        return nuevo;
    }

    public String muestraProductosPorCategoria (String plataforma){
        StringBuilder sb = new StringBuilder();
        for (JuegoFuncional juego : listadoJuegos){
            if (juego.getPlatform().equals(plataforma)){
                sb.append(juego.getGame());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String elejirPlataforma (int plataformaElejida)
    {
        String plataforma = new String();
        if (plataformaElejida==1)
        {
            plataforma="the Playstation 4";

        }
        if (plataformaElejida==2)
        {
            plataforma= "the Switch";
        }
        if (plataformaElejida==3)
        {
            plataforma= "the XBOX";
        }
        return plataforma;
    }

    public String muestraProductosPorCategoriaCliente (String plataforma){///solo elejir entre 3
        StringBuilder sb = new StringBuilder();
        //String plataforma=new String();

        for (JuegoFuncional juego : listadoJuegos){
            if (juego.getPlatform().equals(plataforma)){
                       sb.append(juego.getGame());
                    sb.append("\n");
                }
            }
        return sb.toString();
    }

    public String buscaUnSoloProducto (String nombreJuego){
        StringBuilder sb = new StringBuilder();
        for (JuegoFuncional juego : listadoJuegos){
            if (juego.getGame().equals(nombreJuego)){
                sb.append(juego);
            }
        }
        return sb.toString();
    }

    public JuegoFuncional buscarProducto (String nombreJuego){
        JuegoFuncional aux = new JuegoFuncional();
        for (JuegoFuncional juego : listadoJuegos){
            if (juego.getGame().equals(nombreJuego)){
                aux = juego;
            }
        }
        return aux;
    }

    public Usuario buscarUsuario (String usuario){
        Usuario usr = null;
        for (Usuario usuarioAux : usuarios){
            if (usuarioAux.getUsuario().equals(usuario)){
                usr = usuarioAux;
            }
        }
        return usr;
    }

    public boolean BuscaProducto (String nombreJuego){
        boolean flag = false;
        for (JuegoFuncional juego : listadoJuegos){
            if (juego.getGame().equals(nombreJuego)){

                    flag = true;
                }
            }

        return flag;
    }

    public boolean bajaDeCliente(String nombreUsuario){
        boolean flag = false;
        for (Usuario usuarioAux: usuarios){
            if (usuarioAux.getUsuario().equals(nombreUsuario)){
                if (usuarioAux instanceof Jugador){
                    if (((Jugador) usuarioAux).isActivo()){
                        ((Jugador) usuarioAux).setActivo(false);
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public String muestraDadosDeBajaUsuarios() {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Jugador){
                if (!((Jugador) usuario).isActivo()){
                    sb.append("\n");
                    sb.append("[" + usuario + "]");
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public boolean altaDeCliente(String nombreUsuario){
        boolean flag = false;
        for (Usuario usuarioAux: usuarios){
            if (usuarioAux instanceof Jugador) {
                if (usuarioAux.getUsuario().equals(nombreUsuario)) {
                    if (!((Jugador) usuarioAux).isActivo()) {
                        ((Jugador) usuarioAux).setActivo(true);
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public int buscarJuegoNombre(String nombreJuego) {
        int i=0, encontrado =-1;
        boolean flag = false;
        JuegoFuncional unJuego;
        while(i<listadoJuegos.size() && !flag){
            unJuego = listadoJuegos.get(i);
            if(unJuego.getGame().equals(nombreJuego)) {
                flag = true;
                encontrado = i;
            }
            else{
                i++;
            }
        }
        return encontrado;
    }




    /**
     * Para reiniciar las bases de datos
     */
    public void reiniciarPrograma ()
    {
        LecturaEscritura lye=new LecturaEscritura();
        lye.guardarConPrecio();
        File file = new File("Jugadores.json");
        file.deleteOnExit();
        //LinkedHashSet<Jugador> a=null;


        //lye.grabaJugadores(a);


    }
}
