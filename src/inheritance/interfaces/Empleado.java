package inheritance.interfaces;


public class Empleado implements IPersona {

    private final Persona _super;
    private int sueldo;

    public Empleado(String nombre, String apellido, int edad, int sueldo) {
        _super = new Persona(nombre, apellido, edad);
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return _super.getNombre();
    }

    public void setNombre(String nombre) {
        _super.setNombre(nombre);
    }

    public void setApellido(String apellido) {
        _super.setApellido(apellido);
    }

    public String getApellido() {
        return _super.getApellido();
    }

    public void setEdad(int edad) {
        _super.setEdad(edad);
    }

    public int getEdad() {
        return _super.getEdad();
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return sueldo;
    }
}

class Demo {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("","",45, 6000);
        IPersona persona = empleado;
    }
}
