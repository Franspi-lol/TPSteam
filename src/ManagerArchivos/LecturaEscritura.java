package ManagerArchivos;

import Excepciones.ArchivoNoEncontradoException;
import Genericas.ListaGenerica;
import com.google.gson.Gson;
import compra_juego.Juego;
import compra_juego.JuegoFuncional;
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

    public ArrayList<JuegoFuncional> leeJuego()
    {
        String archivo="GamesPriced";
        ArrayList<JuegoFuncional> juegos=new ArrayList<>();


        try {
            String jsonArrayJuegos = JsonUtiles.leer(archivo);
            JSONArray jsonArray=new JSONArray(jsonArrayJuegos);
            for (int i =0; i<jsonArray.length();i++)
            {
                JSONObject jsonObjectJuegos =jsonArray.getJSONObject(i);
                JuegoFuncional juego = new JuegoFuncional(jsonObjectJuegos.getString("game"),
                        jsonObjectJuegos.optString("gameLink", "null"),
                        jsonObjectJuegos.optInt("year",0),
                        jsonObjectJuegos.getString("genre"),

                        jsonObjectJuegos.optString("dev", "null"),
                        jsonObjectJuegos.optString("devLink", "null"),
                        jsonObjectJuegos.optString("publisher","null"),
                        jsonObjectJuegos.optString("publisherLink", "null"),
                        jsonObjectJuegos.getString("platform"),
                        jsonObjectJuegos.optString("platformLink","null"),jsonObjectJuegos.getInt("price") ) ;
                juegos.add(juego);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return juegos;
    }

    public ArrayList<JuegoFuncional> leeJuego1(String archivo, ArrayList<JuegoFuncional> juegos)
    {
        //ArrayList<JuegoFuncional> juegos=new ArrayList<>();


        try {
            String jsonArrayJuegos = JsonUtiles.leer(archivo);
            JSONArray jsonArray=new JSONArray(jsonArrayJuegos);
            for (int i =0; i<jsonArray.length();i++)
            {
                JSONObject jsonObjectJuegos =jsonArray.getJSONObject(i);
                JuegoFuncional juego = new JuegoFuncional(jsonObjectJuegos.getString("Game"),
                        jsonObjectJuegos.optString("GameLink", "null"),
                        jsonObjectJuegos.optInt("Year",0),
                        jsonObjectJuegos.getString("Genre"),

                        jsonObjectJuegos.optString("Dev", "null"),
                        jsonObjectJuegos.optString("DevLink", "null"),
                        jsonObjectJuegos.optString("Publisher","null"),
                        jsonObjectJuegos.optString("PublisherLink", "null"),
                        jsonObjectJuegos.getString("Platform"),
                        jsonObjectJuegos.optString("PlatformLink","null"),0 ) ;
                juegos.add(juego);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return juegos;
    }
    public ArrayList<JuegoFuncional> retornarConPrecio (ArrayList<JuegoFuncional> juegosSinPrecio)
    {
        Random random=new Random();
        JuegoFuncional aux=new JuegoFuncional();


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

    public void grabaJuegos (ArrayList<JuegoFuncional> listadoJuegos)
    {
        JSONArray jsonArray=new JSONArray(listadoJuegos);
        //JSONObject jsonObjectJuegos=new JSONObject();
        try {

            //jsonObjectJuegos.put("Game", listadoJuegos);
            //jsonArray.put(listadoJuegos);

            JsonUtiles.grabar(jsonArray,"GamesPriced");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
