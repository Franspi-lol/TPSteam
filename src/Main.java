import Excepciones.ArchivoNoEncontradoException;
import Genericas.ListaGenerica;
import ManagerArchivos.LecturaEscritura;
import compra_juego.Juego;
import compra_juego.JuegoFuncional;

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
        ArrayList<JuegoFuncional> aux= new ArrayList<>();
       // File ps4=new File("PS4Games.json");
        //File XBOX=new File("XBOXGames.json");
        aux=lye.leeJuego1("PS4Games", aux);
        aux=lye.leeJuego1("XBOXGames",aux);
        aux=lye.retornarConPrecio(aux);
        lye.grabaJuegos(aux);
        aux=lye.leeJuego();

    }
}
