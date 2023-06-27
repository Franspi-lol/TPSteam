package Genericas;

import java.util.ArrayList;

/**
 * lista generica
 * @param <T>-Tipo generico
 */
public class ListaGenerica <T>
{
    private ArrayList<T> lista;
    public ListaGenerica()
    {
        lista = new ArrayList<>();
    }

    public void agregarLista (T objeto)
    {
        lista.add(objeto);
    }

    public ArrayList<T> getLista() {
        return lista;
    }

    public void setLista(ArrayList<T> lista) {
        this.lista = lista;
    }

    public int size()
    {
        return lista.size();
    }

    @Override
    public String toString() {
        return
                "lista=" + lista;
    }
}
