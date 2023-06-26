import Excepciones.ArchivoNoEncontradoException;
import ManagerArchivos.LecturaEscritura;
import compra_juego.Juego;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class


Main {

    public static void main(String[] args) throws FileNotFoundException, ArchivoNoEncontradoException {
        ArrayList<Juego> jeugos=new ArrayList<>();
        File fileGameNoPrice = new File("SteamGames.json");
        LecturaEscritura lye = new LecturaEscritura();
        jeugos=lye.leeJuego(fileGameNoPrice);
        jeugos=lye.retornarConPrecio(jeugos);
        System.out.println(jeugos.toString());
        lye.grabaJuegos(jeugos);

        }
    }
