package inheritance.delegation;

/**
 * La clase Empleado usa la composición junto con la delegación
 * para la reutilización del código de la clase Persona
 * Esta opción sería la correcta si lo que se desea es simplemente la reutilización del código de Persona
 * (estamos interesados en el código de los metodos de la clase Persona, su implementación)
 * pero no se quiere que la clase Empleado tenga la interfaz de Persona
 *
 * Esta clase Empleado posee la interfaz de la clase Persona
 * Hay que definir manualmente cada metodo de la interfaz de la clase Persona que queramos que
 * este presente también en la clase Empleado
 *
 * La reutilización del código de la clase Persona se produce cuando en el cuerpo de un metodo
 * de la clase Empleado se llama al metodo correspondiente en la clase Persona
 * Esta técnica se denomina delegación
 * Cuando un objeto Empleado recibe el mensaje getNombre "delega" la respuesta al mensaje en el objeto Persona
 */
public class Empleado {

    private final Persona _super; // La clase Empleado usa un objeto Persona (Composición)
    private int sueldo;

    public Empleado(String nombre, String apellido, int edad, int sueldo) {
        _super = new Persona(nombre, apellido, edad); // Se crea el objeto Persona componente
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return _super.getNombre(); // Se delega en el objeto persona la respuesta
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

class EmpleadoDelegationDemo {

    public static void main(String[] args) {

        Empleado empleado = new Empleado("Perico","Palotes",45, 1900);
        //Persona persona = empleado; // Error, una persona no es un empleado (en este ejemplo)
        System.out.println(empleado.getNombre());
        System.out.println(empleado.getApellido());
        System.out.println(empleado.getEdad());
        System.out.println(empleado.getSueldo());

        empleado.setEdad(46);
        System.out.println(empleado.getEdad());
    }
}
