package inheritance;

/**
 * La clase Manager hereda de la clase Employee
 *
 * Aunque no se haya escrito código en el cuerpo de la clase Manager
 * Una instancia de tipo Manager se comporta como una de Empleado
 *
 * La clase Manager hereda de los miembros de la clase base Empleado:
 * el campo name y los métodos getName y setName
 * Para el código que usa instancias de la clase Manager es como si estos miembros se hubieran definido
 * directamente dentro del cuerpo de la clase Manager
 */
public class Manager extends Employee {
}

class ManagerTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setName("Lorenzo Penco");
        System.out.println("Nombre: " + manager.getName());
    }
}
