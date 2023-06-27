import Excepciones.ArchivoNoEncontradoException;
import Genericas.ListaGenerica;
import ManagerArchivos.LecturaEscritura;
import compra_juego.Juego;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{

    public static void main(String[] args) throws FileNotFoundException, ArchivoNoEncontradoException
    {
        LecturaEscritura lye = new LecturaEscritura();
        ArrayList<Juego> juegos=new ArrayList<>();
        juegos=lye.leeJuego1("SteamGames");
        juegos=lye.retornarConPrecio(juegos);
        System.out.println(juegos.toString());

    }
}
