package Excepciones;

import java.io.FileNotFoundException;

public class ArchivoNoEncontradoException extends Exception
{
    public ArchivoNoEncontradoException(FileNotFoundException e) {
    }

    public String getMessage(){
        return "Archivo no encontrado";
    }
}
