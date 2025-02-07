package inheritance.interfaces;

public class Persona implements IPersona {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    @Override
    public String getNombre(){
        return nombre;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    @Override
    public String getApellido(){
        return apellido;
    }
    @Override
    public void setEdad(int edad){
        this.edad = edad;
    }
    @Override
    public int getEdad(){
        return edad;
    }
}
