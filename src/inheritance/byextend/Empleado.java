package inheritance.byextend;

public class Empleado extends Persona {

    private int sueldo;

    public Empleado(String nombre, String apellido, int edad, int sueldo) {
        super(nombre, apellido, edad);
        this.sueldo = sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return sueldo;
    }

    @Override
    public String getNombre() {
        return super.getNombre().toUpperCase();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
}

class EmpleadoDemo {

    public static void main(String[] args) {
        Empleado emp = new Empleado("","", 32, 5000);
        emp.setNombre("Rafa");
        emp.setApellido("Puig");
        Persona persona = emp;
        System.out.println(emp.getSueldo());
    }

}
