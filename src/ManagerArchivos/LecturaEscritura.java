package ManagerArchivos;

import Excepciones.ArchivoNoEncontradoException;
import com.google.gson.Gson;
import compra_juego.Juego;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LecturaEscritura
{
    private final File fileUser = new File("usuarios.json");
    private final File fileGameNoPrice = new File("SteamGames.json");
    private final File fileGame = new File ("SteamGamesPriced.json");

    public ArrayList<Juego> leeJuego (File fileJuegos) throws ArchivoNoEncontradoException, FileNotFoundException {//recibe el file, no nombre
        ArrayList<Juego> Juegos=null;
        try {
            if (fileJuegos.length()>0)
            {
                BufferedReader lectura = new BufferedReader(new FileReader(fileJuegos));
                Gson gson = new Gson();
                Juego[] juego = gson.fromJson(lectura, Juego[].class);
                Juegos = new ArrayList<>(Arrays.asList(juego));

            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        return Juegos;
    }

    public ArrayList<Juego> retornarConPrecio (ArrayList<Juego> juegosSinPrecio)
    {
        Random random=new Random();
        Juego aux=new Juego();


        for (int i=0;i<juegosSinPrecio.size();i++)
        {
            aux=juegosSinPrecio.get(i);
            int nroRandom = random.nextInt(60);
            aux.setPrice(nroRandom);
            juegosSinPrecio.set(i, aux);
        }
        return juegosSinPrecio;
    }

    public void grabaJuegos (ArrayList<Juego> listadoJuegos)
    {
        try {
            BufferedWriter escritura = new BufferedWriter(new FileWriter(fileGame));
            Gson gson = new Gson();
            gson.toJson(listadoJuegos, ArrayList.class, escritura);
            escritura.flush();
            escritura.newLine();
            escritura.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
