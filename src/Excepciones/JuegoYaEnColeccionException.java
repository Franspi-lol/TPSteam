package Excepciones;

public class JuegoYaEnColeccionException extends Exception
{
   /* public JuegoYaEnColeccionException(String info)
    {
        super(info);
    }*/
    @Override
    public String getMessage()
    {
        return "Juego ya en coleccion";
    }

}
