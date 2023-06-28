package ManagerArchivos;

import Paquete_usuario.Jugador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import compra_juego.JuegoFuncional;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;

import java.util.*;

public class LecturaEscritura extends JsonUtiles
{
   /* private final File fileUser = new File("usuarios.json");
    private final File fileGameNoPrice = new File("SteamGames.json");
    private final File fileGame = new File ("SteamGamesPriced.json");*/

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

    public void grabaJugadores (LinkedHashSet<Jugador> jugadores)
    {
        LinkedHashSet<Jugador> aux=new LinkedHashSet<>();
        JSONArray jsonArray=new JSONArray();
       /* //JSONObject jsonObjectColeccion=new JSONObject();
        try {
            JsonUtiles.grabar(jsonArray,"Jugadores");
        }catch (Exception e) {
        throw new RuntimeException(e);
    }*/
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(jugadores);
        try(FileWriter writer= new FileWriter("Jugadores.json"))
        {
            gson.toJson(jugadores,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee los juegos de la base de datos (GamesPriced.json)
     * @return - ArrayList<JuegoFuncional></>
     */
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
                JuegoFuncional juego = new JuegoFuncional(jsonObjectJuegos.optString("game","null"),
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

    /**
     * Es la utilizada para leer los json que no tienen el precio
     * @param archivo
     * @param juegos-array de juegos
     * @return
     */
    public ArrayList<JuegoFuncional> leeJuego1(String archivo, ArrayList<JuegoFuncional> juegos)
    {
        //ArrayList<JuegoFuncional> juegos=new ArrayList<>();


        try {
            String jsonArrayJuegos = JsonUtiles.leer(archivo);
            JSONArray jsonArray=new JSONArray(jsonArrayJuegos);
            for (int i =0; i<jsonArray.length();i++)
            {
                JSONObject jsonObjectJuegos =jsonArray.getJSONObject(i);
                JuegoFuncional juego = new JuegoFuncional(jsonObjectJuegos.optString("Game","null"),
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

    /**
     * Para generar/reiniciar base de datos de juegos
     */
    public void guardarConPrecio ()
    {
        ArrayList<JuegoFuncional> aux= new ArrayList<>();
        aux=leeJuego1("PS4Games", aux);
        aux=leeJuego1("XBOXGames",aux);
        aux=leeJuego1("SwitchGames", aux);
        aux=retornarConPrecio(aux);
        grabaJuegos(aux);
    }

}
