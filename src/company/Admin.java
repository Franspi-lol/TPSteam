package company;

import java.io.Serializable;

public class Admin extends Usuario implements Serializable
{
    private String cargo;

    public Admin()
    {
        setId(getId());
    }

    public Admin(String nombre, String apellido, String usuario, String contrasena, String cargo) {
        super(nombre, apellido, usuario, contrasena);
        setId(getId());
        this.cargo = cargo;
    }

    public String getCargo()
    {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Admin{" +
                "cargo='" + cargo + '\'' +
                '}';
    }
}
