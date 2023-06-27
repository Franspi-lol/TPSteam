package ManagerArchivos;

import Excepciones.ArchivoNoEncontradoException;
import Genericas.ListaGenerica;
import com.google.gson.Gson;
import compra_juego.Juego;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LecturaEscritura extends JsonUtiles
{
    private final File fileUser = new File("usuarios.json");
    private final File fileGameNoPrice = new File("SteamGames.json");
    private final File fileGame = new File ("SteamGamesPriced.json");

   /* public ArrayList<Juego> leeJuego (File fileJuegos) throws ArchivoNoEncontradoException, FileNotFoundException {//recibe el file, no nombre
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
    }*/

    public ArrayList<Juego> leeJuego(String archivo)
    {
        ArrayList<Juego> juegos=new ArrayList<>();


        try {
            String jsonArrayJuegos = JsonUtiles.leer(archivo);
            JSONArray jsonArray=new JSONArray(jsonArrayJuegos);
            for (int i =0; i<jsonArray.length();i++)
            {
                JSONObject jsonObjectJuegos =jsonArray.getJSONObject(i);
                Juego juego = new Juego(jsonObjectJuegos.getString("GameLink"),
                        jsonObjectJuegos.getString("Game"),
                        jsonObjectJuegos.getString("Platform"),
                        jsonObjectJuegos.getInt("Year"),
                        jsonObjectJuegos.getString("PlatformLink"),
                        jsonObjectJuegos.getInt("Price"));
                juegos.add(juego);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return juegos;
    }

    public ArrayList<Juego> leeJuego1(String archivo)
    {
        ArrayList<Juego> juegos=new ArrayList<>();


        try {
            String jsonArrayJuegos = JsonUtiles.leer(archivo);
            JSONArray jsonArray=new JSONArray(jsonArrayJuegos);
            for (int i =0; i<jsonArray.length();i++)
            {
                JSONObject jsonObjectJuegos =jsonArray.getJSONObject(i);
                Juego juego = new Juego(jsonObjectJuegos.getString("GameLink"),
                        jsonObjectJuegos.getString("Game"),
                        jsonObjectJuegos.getString("Platform"),
                        jsonObjectJuegos.optInt("Year",0),
                        jsonObjectJuegos.getString("PlatformLink"),
                        0);
                juegos.add(juego);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return juegos;
    }
    public ArrayList<Juego> retornarConPrecio (ArrayList<Juego> juegosSinPrecio)
    {
        Random random=new Random();
        Juego aux=new Juego();


        for (int i=0;i<juegosSinPrecio.size();i++)
        {
            aux=juegosSinPrecio.get(i);
            //System.out.println(aux.toString());
            int nroRandom = random.nextInt(60);

            aux.setPrice(nroRandom);
            //System.out.println(aux.toString());
            juegosSinPrecio.set(i, aux);
        }
        return juegosSinPrecio;
    }

    public void grabaJuegos (ArrayList<Juego> listadoJuegos)
    {
        JSONArray jsonArray=new JSONArray(listadoJuegos);
        //JSONObject jsonObjectJuegos=new JSONObject();
        try {

            //jsonObjectJuegos.put("Game", listadoJuegos);
            //jsonArray.put(listadoJuegos);

            JsonUtiles.grabar(jsonArray,"SteamGamesPriced");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
