package Compania;

import Excepciones.JuegoYaEnColeccionException;
import Interface.ICategoria;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Clase generica de coleccion
 * @param <K> - Clave| nombre Game
 * @param <V> - JuegoFuncional
 */
public class Coleccion<K,V>
{
    private HashMap<K, V> coleccion;

    public Coleccion()
    {
        coleccion=new HashMap<>();
    }

    public boolean agregarAColeccion (K key, V value) throws JuegoYaEnColeccionException
    {
        boolean agregado = false;
        if (coleccion.containsKey(key))
        {
            throw new JuegoYaEnColeccionException("El juego ya estaba en coleccion");
        }
        else
        {
            coleccion.put(key,value);
            agregado=true;
        }
        return agregado;
    }

    /**
     * funcion para devolver iterador
     * @return Iterator
     */
    public Iterator getIterator()
    {
        return coleccion.entrySet().iterator();
    }


}
