package Compania;

import Excepciones.JuegoYaEnColeccionException;

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

    public boolean agregarAColeccion (K key, V variable) throws JuegoYaEnColeccionException
    {
        boolean agregado = false;

            if (coleccion.containsKey(key))
            {
                throw new JuegoYaEnColeccionException();
            }
            else
            {
                coleccion.put(key,variable);
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
