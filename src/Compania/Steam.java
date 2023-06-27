package Compania;

import ManagerArchivos.LecturaEscritura;
import Paquete_usuario.Usuario;
import compra_juego.Juego

import java.util.*;
public class Steam {
    private String nombreSteam;
    private LinkedHashSet<Usuario> usuarios;
    private ArrayList<Juego> listadoJuegos;

    public Steam(String nombreSteam) {
        this.nombreSteam = nombreSteam;
        usuarios = new LinkedHashSet<>();
        listadoJuegos = new ArrayList<>();
    }

    public void nuevoUsuario (Usuario usuario){
        usuarios.add(usuario);
    }

    public void nuevoJuego (Juego juego){
        listadoJuegos.add(juego);
    }

    public ArrayList<Juego> getListadoJuegos() {
        return listadoJuegos;
    }

    public void setListadoJuegos(ArrayList<Juego> listadoJuegos) {
        if(listadoJuegos != null){
            this.listadoJuegos = listadoJuegos;
        }
    }

    public LinkedHashSet<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(LinkedHashSet<Usuario> usuarios) {
        if (usuarios != null){
            this.usuarios = usuarios;
        }
    }

    public String getNombreSupermercado() {
        return nombreSupermercado;
    }

    public void setNombreSupermercado(String nombreSupermercado) {
        this.nombreSupermercado = nombreSupermercado;
    }

    public Usuario buscarUsuarioLogin (String usr, String pass){
        for (Usuario usuario : usuarios){
            if (usuario.getUsuario().equals(usr)){
                if (usuario.getContrasena().equals(pass)){
                    if (usuario instanceof Cliente) {
                        Cliente cliente = new Cliente();
                        return cliente = (Cliente) usuario;
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
            if (usuario instanceof Cliente){
                if (((Cliente) usuario).getActivo()){
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
        for (Juego juego : listadoJuegos){
                sb.append(juego.getGame());
                sb.append("\n");

        }
        return sb.toString();
    }

    public String muestraProductosParaCliente (){
        StringBuilder sb = new StringBuilder();
        LecturaEscritura lye= new LecturaEscritura()
        for (Juego juego : listadoProductos){
            if (juego.isActivo()==true){
                sb.append(lye.leeJuego());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String muestraProductosPorCategoria (String categoria){
        StringBuilder sb = new StringBuilder();
        for (Producto producto : listadoProductos){
            if (producto.getCategoria().equals(categoria)){
                sb.append(producto.muestraProducto());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String muestraProductosPorCategoriaCliente (String categoria){
        StringBuilder sb = new StringBuilder();
        for (Producto producto : listadoProductos){
            if (producto.getCategoria().equals(categoria)){
                if (producto.isActivo() && producto.getStockProducto() > 0){
                    sb.append(producto.muestraProducto());
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public String buscaUnSoloProducto (String nombreProducto){
        StringBuilder sb = new StringBuilder();
        for (Producto producto : listadoProductos){
            if (producto.getNombreProducto().equals(nombreProducto) && producto.isActivo()){
                sb.append(producto);
            }
        }
        return sb.toString();
    }

    public Juego buscarProducto (String nombreProducto){
        Juego aux = new Juego();
        for (Juego producto : listadoJuegos){
            if (aux.getGame().equals(nombreProducto) && producto.isActivo()){
                aux = producto;
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

    public boolean BuscaProducto (int id){
        boolean flag = false;
        for (Producto producto : listadoProductos){
            if (producto.getIdProducto() == id){
                if (producto.isActivo()){
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean restockProducto (int id, int cantidad){
        boolean flag = false;
        for (Producto producto : listadoProductos){
            if(producto.getIdProducto() == id){
                cantidad += producto.getStockProducto();
                producto.setStockProducto(cantidad);
                flag = true;
            }
        }
        return flag;
    }

    public boolean bajaDeProducto (String nombre){
        boolean flag = false;
        for (Juego juego : listadoProductos){
            if (juego.getIdProducto() == id){
                if (juego.isActivo()){
                    juego.setActivo(false);
                    flag = true;
                }
            }
        }
        return flag;
    }

    public String muestraDadosDeBajaProductos (){
        StringBuilder sb = new StringBuilder();
        for (Juego juego : listadoJuegos){
            if (!juego.isActivo()){
                sb.append(juego);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public boolean altaDeProducto (String nombre){
        boolean flag = false;
        for (Juego juego : listadoJuegos){
            if (juego.getGame() == nombre){
                if (!juego.isActivo()){
                    juego.setActivo(true);
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean bajaDeCliente(String dni){
        boolean flag = false;
        for (Usuario usuarioAux: usuarios){
            if (usuarioAux.getDni().equals(dni)){
                if (usuarioAux instanceof Cliente){
                    if (((Cliente) usuarioAux).getActivo()){
                        ((Cliente) usuarioAux).setActivo(false);
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
            if (usuario instanceof Cliente){
                if (!((Cliente) usuario).getActivo()){
                    sb.append("\n");
                    sb.append("[" + usuario + "]");
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public boolean altaDeCliente(String dni){
        boolean flag = false;
        for (Usuario usuarioAux: usuarios){
            if (usuarioAux instanceof Cliente) {
                if (usuarioAux.getDni().equals(dni)) {
                    if (!((Cliente) usuarioAux).getActivo()) {
                        ((Cliente) usuarioAux).setActivo(true);
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
        Producto unProducto;
        while(i<listadoProductos.size() && !flag){
            unProducto = listadoProductos.get(i);
            if(unProducto.getNombreProducto().equals(nombreProducto) && unProducto.isActivo()) {
                flag = true;
                encontrado = i;
            }
            else{
                i++;
            }
        }
        return encontrado;
    }


/*
    public void dejarUnComentario(String comentario, int i)
    {
        listadoJuegos.get(i).setComentario(comentario);
    }
*/
    public boolean controlStrockProducto (int idProducto, int cantidad) {
        boolean flag = false;
        int aux = 0;
        for (Juego juego : listadoProductos) {
            if (juego.getIdProducto() == idProducto) {
                if (cantidad <= juego.getStockProducto()) {
                    aux = juego.getStockProducto() - cantidad;
                    juego.setStockProducto(aux);
                    flag = true;
                }
            }

        }
        return flag;
    }


}
