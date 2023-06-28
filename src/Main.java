import Compania.Carrito;
import Compania.Steam;
import Excepciones.ArchivoNoEncontradoException;
import ManagerArchivos.LecturaEscritura;
import Paquete_usuario.Admin;
import Paquete_usuario.Jugador;
import Paquete_usuario.Usuario;
import compra_juego.Compra;
import compra_juego.Juego;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{

    private static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException, ArchivoNoEncontradoException
    {
        LecturaEscritura lye = new LecturaEscritura();
        ArrayList<Juego> juegos=new ArrayList<>();
        lye.guardarConPrecio();


        Scanner scanner;


        int opc, opcCompra;
        scanner = new Scanner(System.in);
        Steam steam = new Steam("Steamcito");
        lee (lye,steam);
        cargarAdmins(steam);
        System.out.println("Steamcito " + steam.getNombreSteam());
        Usuario usr = Login(steam);
        Carrito<Compra> compra;
        if (usr instanceof Admin) {
            do {
                menuAdmin();
                opc = scanner.nextInt();
                scanner.nextLine();
                switch (opc) {

                    case 1:
                        System.out.println(steam.muestraJuegos());
                        break;
                    case 2:
                        muestraPorCategoria(steam);
                        break;
                    case 3:
                        bajaProducto(steam);
                        break;
                    case 6:
                        altaProducto(steam);
                        break;
                    case 7:
                        System.out.println(usr);
                        break;
                    case 8:
                        System.out.println(steam.muestraUsuarios());
                        break;
                    case 9:
                        buscaUsuario(steam);
                        break;
                    case 10:
                        bajaCliente(steam);
                        break;
                    case 11:
                        altaCliente(steam);
                        break;
                }
            } while (opc != 0);
        } else if (usr instanceof Jugador) {
            do {
                menuJugador();
                opc = scanner.nextInt();
                scanner.nextLine();
                switch (opc) {
                    case 1:
                        modificarDatos(steam, usr);
                        break;
                    case 2:
                        System.out.println(usr);
                        break;
                    case 3:
                        compra = new Carrito<>();
                        do {
                            menuCompra();
                            opcCompra = scanner.nextInt();
                            scanner.nextLine();
                            switch (opcCompra) {
                                case 1:
                                    System.out.println(steam.muestraProductosParaCliente());
                                    break;
                                case 2:
                                    muestraPorCategoria(steam);
                                    break;
                                case 3:
                                    muestraJuego(steam);
                                    break;
                                case 4:
                                    compra = realizarCompra(steam, compra);
                                    break;
                                case 5:
                                    System.out.println(compra);
                                    break;
                                case 6:
                                    if (finCompra(compra, usr)){
                                        compra = new Carrito<>();
                                    }
                                    break;
                                case 7:
                                    compra = cancelarCompra();
                                    System.out.println("COMPRA CANCELADA");
                                    break;
                                case 8:
                                    System.out.println(((Jugador) usr).muestraHistorialCompras());
                                    break;
                            }
                        } while (opcCompra != 0);
                        break;
                    case 4:
                        bajaClienteCliente (steam, lye);
                        break;

                }
            } while (opc != 0);
        }
        graba(lye, steam);
    }

        public static void graba(LecturaEscritura lye, Steam steam){
        lye.grabaClientes(steam.getUsuarios());
        lye.grabaProductos(steam.getListadoProductos());
    }

        public static void lee (LecturaEscritura lye, Steam steam){
            steam.setUsuarios(lye.leeJugadores());
            steam.setListadoProductos(lye.leeJuego());
    }

        public static void menuAdmin (){
        System.out.println("MENU ADMINISTRADOR: ");
        System.out.println("1. AGREGA PRODUCTO");
        System.out.println("2. VER LISTA PRODUCTOS");
        System.out.println("3. VER LISTA PRODUCTOS POR CATEGORIA");
        System.out.println("4. RENOVAR STOCK DE UN PRODUCTO");
        System.out.println("5. DAR DE BAJA UN PRODUCTO");
        System.out.println("6. DAR DE ALTA UN PRODUCTO");
        System.out.println("7. VER USUARIO ADMINISTRADOR");
        System.out.println("8. VER LISTA CLIENTES");
        System.out.println("9. BUSCAR CLIENTE");
        System.out.println("10. DAR DE BAJA UN CLIENTE");
        System.out.println("11. DAR DE ALTA UN CLIENTE");
        System.out.println("0. SALIR");
        System.out.println("SELECCIONE UNA OPCION: ");
    }

        public static void menuJugador (){
        System.out.println("MENU JUGADOR");
        System.out.println("1. MODIFICAR DATOS PERSONALES");
        System.out.println("2. VER JUGADOR ACTUAL");
        System.out.println("3. COMPRAR");
        System.out.println("4. DAR DE BAJA LA CUENTA");
        System.out.println("6. DEJAR UN COMENTARIO DEL PRODUCTO");
        System.out.println("0. SALIR");
        System.out.println("SELECCIONE UNA OPCION: ");
    }

        public static void menuCompra (){
        System.out.println("MENU COMPRA");
        System.out.println("1. VER LISTA PRODUCTOS");
        System.out.println("2. VER LISTA DE PRODUCTOS POR CATEGORIA");
        System.out.println("3. VER UN PRODUCTO");
        System.out.println("4. CARGAR PRODUCTO AL CARRITO");
        System.out.println("5. VER CARRITO");
        System.out.println("6. FINALIZAR PEDIDO");
        System.out.println("7. CANCELAR PEDIDO");
        System.out.println("8. VER HISTORIAL DE COMPRA");///SE PODRIA MODIFICAR
        System.out.println("0. ATRAS");
        System.out.println("SELECCIONE UNA OPCION: ");
    }

        public static Usuario Login (Steam steam) {
        String usuario, contrasena;
        char opc;
        Usuario usr;
        System.out.println("Login");
        System.out.println("Usuario");

            usuario = scanner.nextLine();
        System.out.println("Contraseña");
        contrasena = scanner.nextLine();
        usr = steam.buscarUsuarioLogin(usuario, contrasena);
        if (usr != null) {
            if (usr instanceof Jugador){
                if (!((Jugador) usr).isActivo()){
                    System.out.println("EL CLIENTE ESTA DADO DE BAJA");
                    System.exit(1);
                }
            }
            System.out.println("Logeado con exito!");
            System.out.println("Bienvenido " + usr.getNombre());
        } else {
            System.out.println("Usuario o Contraseña incorrectos!!");
            do {
                System.out.println("Desea crear un nuevo usuario? S/N");
                opc = scanner.nextLine().charAt(0);
                if (opc == 's' || opc == 'S') {
                    usr = nuevoCliente(steam);
                    steam.nuevoUsuario(usr);
                    System.out.println("Cliente creado con exito!");
                } else if (opc == 'n' || opc == 'N') {
                    System.out.println("Hasta pronto!");
                }
            } while (opc != 's' && opc != 'S' && opc != 'n' && opc != 'N');
        }
        return usr;
    }

        public static Usuario nuevoCliente (Steam steam){
        boolean flag = false;
        String usuario;
        Jugador jugador = new Jugador();
        System.out.println("Nombre: ");
            jugador.setNombre(scanner.nextLine());
        System.out.println("Apellido: ");
            jugador.setApellido(scanner.nextLine());

        do{
            System.out.println("E-Mail");
            jugador.setMail(scanner.nextLine());
            if (jugador.getMail().contains("@")){
                flag = true;
            }else{
                System.out.println("Error, mail no valido, reintente...");
            }
        }while (!flag);
        do{
            System.out.println("Nombre de usuario: ");
            usuario = scanner.nextLine();
            if (steam.buscarPorNombreUsuarioLogin(usuario)){
                System.out.println("Error, usuario ya registrado.");
            }
            else{
                jugador.setUsuario(usuario);
            }
        }while (steam.buscarPorNombreUsuarioLogin(usuario));
        System.out.println("contraseña: ");
        jugador.setContrasena(scanner.nextLine());
        jugador.setActivo(true);
        return jugador;
    }

        public static void cargarAdmins (Steam steam){
        Usuario admin1 = new Admin("Juan Ignacio", "Zappulla", "41928220", "juani99", "8914122", "Jefe");
        Usuario admin2= new Admin("Nahuel Ariel","Zamudio","41542799","nahuel98","741852","jefe2");
            steam.nuevoUsuario(admin1);
            steam.nuevoUsuario(admin2);
    }
/*
        public static void nuevoProducto (Supermercado mercado) {
        Producto producto = new Producto();
        System.out.println("Nombre del producto: ");
        producto.setNombreProducto(scanner.nextLine());
        System.out.println("Marca del producto: ");
        producto.setMarcaProducto(scanner.nextLine());
        System.out.println("Precio del producto: ");
        producto.setPrecioProducto(scanner.nextDouble());
        System.out.println("Stock Actual del producto: ");
        producto.setStockProducto(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Comentario: ");
        producto.setComentario(scanner.nextLine());
        System.out.println("Categoria: ");
        producto.setCategoria(scanner.nextLine());
        mercado.nuevoProducto(producto);
    }
*/
        public static void muestraPorCategoria(Steam steam){
        String categoria;
        System.out.println("INGRESE CATEGORIA: ");
        categoria = scanner.nextLine();
        System.out.println(steam.muestraProductosPorCategoria(categoria));
    }

        public static void muestraJuego(Steam steam){
        LecturaEscritura lye= new LecturaEscritura();
        String nombre;
        String juego;
        System.out.println("INGRESE NOMBRE DEL JUEGO: ");
        nombre = scanner.nextLine();
            juego = lye.leeJuego("GamesPriced");
        if (juego.length()>0){
            System.out.println(juego);
        }
        else{
            System.out.println("NO SE ENCUENTRA EL JUEGO O FUE DADO DE BAJA...");
        }
    }

        public static void muestraPorPlataforma(Steam steam){
        String plataforma;
        System.out.println("INGRESE PLATAFORMA: ");
        plataforma = scanner.nextLine();
        System.out.println(steam.muestraProductosPorCategoriaCliente(plataforma));
    }

        public static void buscaUsuario(Steam steam) {
        String usuario;
        System.out.println("INGRESE DNI DE USUARIO: ");
        usuario = scanner.nextLine();
        Usuario usr = steam.buscarUsuario(usuario);
        if ( usr instanceof Jugador) {
            System.out.println("Id:" + usr.getId());
            System.out.println(usr);
        } else if (usr instanceof Admin) {
            System.out.println("Id:" + usr.getId());
            System.out.println(usr);
        }
    }

       /* public static void restockearProducto (Steam mercado){
        int idProducto;
        int cantidad;
        boolean flag;
        System.out.println("Ingrese id de producto: ");
        idProducto = scanner.nextInt();
        flag = mercado.BuscaProducto(idProducto);
        if (!flag){
            System.out.println("ERROR, ID INCORRECTO O SE DESACTIVÓ EL PRODUCTO");
        }
        else{
            System.out.println("Ingrese cantidad para reestockear");
            cantidad = scanner.nextInt();
            flag = mercado.restockProducto(idProducto, cantidad);
            if(!flag){
                System.out.println("ERROR, REINTENTE");
            }
            else{
                System.out.println("INGRESO DE STOCK CORRECTO");
            }
        }
    }
    */


        public static void bajaProducto (Steam steam){
        String nombre;
        boolean flag;
        Juego juego=new Juego();
        System.out.println("Ingrese el nombre del juego: ");
         nombre= scanner.nextLine();
        flag = steam.bajaDeProducto(nombre);
        if (!flag){
            System.out.println("ERROR, EL PRODUCTO NO SE ENCUENTRA O YA ESTA DESACTIVADO");
        }
        else{
            System.out.println("PRODUCTO DADO DE BAJA CON EXITO");
        }
    }

        public static void altaProducto (Steam steam){
        String nombre;
        boolean flag;
        if (steam.muestraDadosDeBajaProductos().length()>0) {
            System.out.println("PRODUCTOS DADOS DE BAJA");
            System.out.println(steam.muestraDadosDeBajaProductos());
            System.out.println("Ingrese Nombre del Juego: ");
            nombre = scanner.nextLine();
            flag = steam.altaDeProducto(nombre);
            if (!flag) {
                System.out.println("ERROR, EL JUEGO NO SE ENCUENTRA O YA ESTA DADO DE ALTA");
            } else {
                System.out.println("PRODUCTO DADO DE ALTA CON EXITO");
            }
        }
        else{
            System.out.println("NO HAY PRODUCTOS DADOS DE BAJA");
        }
    }

        public static void bajaCliente (Steam steam){
        String dni;
        boolean flag;
        System.out.println("Ingrese DNI de cliente: ");
        dni = scanner.nextLine();
        flag = steam.bajaDeCliente(dni);
        if (!flag){
            System.out.println("ERROR, EL CLIENTE NO SE ENCUENTRA O YA ESTA DADO DE BAJA");
        }
        else{
            System.out.println("CLIENTE DADO DE BAJA CON EXITO");
        }
    }

        public static void bajaClienteCliente (Steam steam, LecturaEscritura lye){
        String dni;
        boolean flag;
        System.out.println("Ingrese DNI de cliente: ");
        dni = scanner.nextLine();
        flag = steam.bajaDeCliente(dni);
        if (!flag){
            System.out.println("ERROR, EL CLIENTE NO SE ENCUENTRA O YA ESTA DADO DE BAJA");
        }
        else{
            System.out.println("CLIENTE DADO DE BAJA CON EXITO");
            graba(lye, steam);
            System.exit(1);
        }
    }

        public static void altaCliente (Steam steam){
        String dni;
        boolean flag;

        if (steam.muestraDadosDeBajaUsuarios().length()>0){
            System.out.println("CLIENTES DADOS DE BAJA");
            System.out.println(steam.muestraDadosDeBajaUsuarios());
            System.out.println("Ingrese DNI del cliente: ");
            dni = scanner.nextLine();
            flag = steam.altaDeCliente(dni);
            if (!flag){
                System.out.println("ERROR, EL CLIENTE NO SE ENCUENTRA O YA ESTA DADO DE ALTA");
            }
            else{
                System.out.println("USUARIO DADO DE ALTA CON EXITO");
            }
        }
        else{
            System.out.println("NO HAY CLIENTES DADOS DE BAJA");
        }
    }

        public static boolean finCompra(Carrito<Compra>carrito, Usuario usr){
        int tipoPago;
        int aux;
        DecimalFormat formato = new DecimalFormat("#.##");

        if (carrito.mostrarCarrito().length() > 0){
            do {
                System.out.println("seleccione el metodo de pago:\n 1. Efectivo\n 2. Tarjeta Credito\n 3. Tarjeta Debito\n 4. MercadoPago");
                tipoPago=scanner.nextInt();
                if(tipoPago==1)
                {
                    carrito.setTipoPago("Efectivo");
                }
                else if(tipoPago==2)
                {
                    carrito.setTipoPago("Tarjeta Credito");
                }
                else if(tipoPago==3){
                    carrito.setTipoPago("Tarjeta Debito");
                }
                else if(tipoPago==4){
                    carrito.setTipoPago("MercadoPago");
                }
                else
                {
                    System.out.println("EL TIPO DE PAGO ES INCORRECTO, REINTENTE...");
                    tipoPago=0;
                }
            }while(tipoPago==0);

            System.out.println("EL TOTAL A PAGAR ES:" + formato.format(PrecioTotalConDescuento(carrito)));
            System.out.println("PARA REALIZAR EL PAGO PRESIONE 1, DE LO CONTRARIO PRESIONE 2: ");
            aux=scanner.nextInt();
            if(aux==1)
            {
                carrito.setPago(true);
                carrito.setPrecioTotalCompra(PrecioTotalConDescuento(carrito));
                ((Jugador) usr).agregarHistorial(carrito);
                return true;
            }
            else
            {
                carrito.setPago(false);
            }
        }
        else{
            System.out.println("ERROR, DEBE CARGAR PRODUCTOS PRIMERO");
        }
        return false;
    }

        public static double PrecioTotalConDescuento(Carrito<Compra>unProducto) {
        double total=0;
        double aplicarDescuento=0;
        double descuentoAplicado=0;
        for (int i=0;i<unProducto.getLista().size();i++)
        {

            total+=unProducto.getLista().get(i).getPrecio();

        }
        if (unProducto.getTipoPago().equals("Efectivo"))
        {
            unProducto.setDescuento(0.10);
            aplicarDescuento = total * unProducto.getDescuento();
            descuentoAplicado = total - aplicarDescuento;
        }
        else if (unProducto.getTipoPago().equals("Tarjeta Credito")){
            unProducto.setDescuento(0.15);
            aplicarDescuento = total * unProducto.getDescuento();
            descuentoAplicado = total + aplicarDescuento;
        }
        else if (unProducto.getTipoPago().equals("Tarjeta Debito")){
            unProducto.setDescuento(0.10);
            aplicarDescuento = total * unProducto.getDescuento();
            descuentoAplicado = total - aplicarDescuento;
        }
        else if (unProducto.getTipoPago().equals("MercadoPago")) {
            unProducto.setDescuento(0.20);
            aplicarDescuento = total * unProducto.getDescuento();
            descuentoAplicado = total + aplicarDescuento;
        }
        else {
            descuentoAplicado=(float)total;
        }
        return descuentoAplicado;
    }

        public static Carrito<Compra> cancelarCompra(){
        return new Carrito<>();
    }

        public static Carrito<Compra> realizarCompra(Steam steam, Carrito<Compra> carrito){
        Compra compraJuego;
        Juego juego;
        String nombreJuego;
        int cantidad;
        boolean controlStock;
        char continuar;
        do {
            System.out.println("ingrese el producto que desee comprar:");
            nombreJuego= scanner.nextLine();
            compraJuego = new Compra();
            juego = juego.buscarProducto(nombreProducto);
            if(juego.getGame() != null){
                System.out.println("indique la cantidad a comprar:");
                cantidad=scanner.nextInt();
                scanner.nextLine();

                if(juego.isActivo()==true){
                    compraJuego.getPrecio();
                    compraJuego.setCompra(juego);
                    carrito.agregarCarrito(compraJuego);
                    System.out.println("cargado con exito!");
                }
            else{
                System.out.println("EL PRODUCTO SELECCIONADO NO EXISTE O FUE DADO DE BAJA");
            }
            System.out.println("Desea continuar: S/N ");
            continuar= scanner.nextLine().charAt(0);
        }while(continuar == 's');

        return carrito;
    }

        public static void modificarDatos(Steam steam, Usuario usr)
            {
        int opc;
        boolean flag = false;
        do {
            System.out.println("SELECCIONE EL DATO A MODIFICAR:");
            System.out.println(" 1. nombre\n 2. apellido\n 3. E-Mail\n 4. Nombre Usuario\n5. contraseÃ±a\n 0. Atras\nELIJA UNA OPCION:");
            opc = scanner.nextInt();
            scanner.nextLine();
            System.out.println("OPCION ELEGIDA: " + opc);
            String usuario;
            switch (opc) {
                case 1:
                    System.out.println("Nombre: ");
                    usr.setNombre(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Apellido: ");
                    usr.setApellido(scanner.nextLine());
                    break;
                case 3:
                    do {
                        System.out.println("E-Mail");
                        ((Jugador) usr).setMail(scanner.nextLine());
                        if (((Jugador) usr).getMail().contains("@")) {
                            flag = true;
                        } else {
                            System.out.println("Error, mail no valido, reintente...");
                        }
                    } while (!flag);
                    break;
                case 4:
                    do {
                        System.out.println("Nombre de usuario: ");
                        usuario = scanner.nextLine();
                        if (steam.buscarPorNombreUsuarioLogin(usuario)) {
                            System.out.println("Error, usuario ya registrado.");
                        } else {
                            usr.setUsuario(usuario);
                        }
                    } while (steam.buscarPorNombreUsuarioLogin(usuario));
                    break;

                case 6:
                    System.out.println("contraseña: ");
                    usr.setContrasena(scanner.nextLine());
                    ((Jugador) usr).setActivo(true);
                    break;
            }
        }while (opc != 0);
    }
/*
        public static void comentar(Steam steam){
        int i;
        String nombre, comentario;
        System.out.println("ingrese el nombre del juego");
        nombre = scanner.nextLine();
        i = steam.buscarJuegoNombre(nombre);
        if (i < 0){
            System.out.println("ERROR, EL PRODUCTO NO EXISTE O FUE DADO DE BAJA...");
        }
        else{
            System.out.println("Deje su comentario");
            comentario=scanner.nextLine();
            steam.dejarUnComentario(comentario, i);
        }

    }
*/

    }
}
