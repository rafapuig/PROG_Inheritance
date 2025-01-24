package inheritance;

/**
 * La clase Manager hereda de la clase Employee
 * <p>
 * Aunque no se haya escrito código en el cuerpo de la clase Manager
 * Una instancia de tipo Manager se comporta como una de Empleado
 * <p>
 * La clase Manager hereda de los miembros de la clase base Empleado:
 * el campo name y los métodos getName y setName
 * Para el código que usa instancias de la clase Manager es como si estos miembros se hubieran definido
 * directamente dentro del cuerpo de la clase Manager
 */
public class Manager extends Employee {
    {
        // No tenemos acceso directo al miembro name de la clase base
        //name = "Señor X";

        // Si podemos acceder al campo indirectamente mediante los métodos getName() y setName()
        // Lo que demuestra, que realmente el objeto de tipo Manager cuenta con un campo name
        // El campo name "permea"
        setName("Señor X");
        String name = getName();
        System.out.println(name);
    }
}

class ManagerTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        // Aunque la clase Manager no declara un método setName
        // Lo hereda, es decir, es como si realmente se hubiera definido un método setName en la clase Manager
        manager.setName("Lorenzo Penco");
        // Aunque, la clase Manager no declara un método getName
        // Para el código cliente es como si la clase Manager hubiera definido el método getName
        System.out.println("Nombre: " + manager.getName());
    }
}
