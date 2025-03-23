package inheritance;

// Todas las clases que definimos en Java heredan implícitamente de la clase Object

/**
 * La clase Employee no especifica una superclase de la cual extiende
 * Eso significa que su superclase es la clase Object del paquete java.lang
 * Employee hereda implícitamente de la clase Object
 */
public class Employee {

    private String name = "Anónimo";

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}

class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Armando Bronca Segura");
        System.out.println("Nombre:" + employee.getName());
    }
}