package references;

import model.Employee;
import model.Person;
import model.Programmer;

public class ReferencesDemo {

    public static void main(String[] args) {

        // Creamos una instancia de tipo Programmer
        // y guardamos una referencia de tipo Object a este objeto
        Object obj = new Programmer(); // Upcasting en acción

        // Con la referencia de tipo Object solamente podemos interactuar con el objeto
        // mediante la interfaz de la clase Object
        // Es como si solo supiéramos del objeto que es un Object
        System.out.println(obj.toString()); // Late binding del método toString

        // Si el objeto es una Person
        // Si obj contiene una referencia a una instancia de Person o derivada
        // Si la variable obj almacena una referencia que apunta a una instancia de tipo Person o derivada de Person
        if (obj instanceof Person person) {
            // la variable person contiene una referencia al objeto de tipo Programmer creado al principio
            // pero ahora la referencia es de tipo Person
            // y, por tanto, mediante esta referencia podemos acceder a los miembros específicos de la clase Person
            // e interactuar con el objeto tratándolo como una instancia de Person
            person.setName("Armando Bronca Segura");
            person.setAge(23);
            // Toda instancia de tipo Person es considera también una instancia de tipo Object
            // (De hecho en Java todo objeto es considerado una instancia de tipo Object)
            System.out.println(obj.toString()); // Late binding del método toString
        }

        // Si el objeto es un Employee
        // Si obj contiene una referencia a una instancia de Employee o derivada
        // Si la variable obj almacena una referencia que apunta a una instancia de tipo Employee o derivada de Employee
        if (obj instanceof Employee employee) {
            // la variable employee contiene una referencia al objeto de tipo Programmer creado al principio
            // pero ahora la referencia es de tipo Employee
            // y, por tanto, mediante esta referencia podemos acceder a los miembros específicos de la clase Employee
            // e interactuar con el objeto tratándolo como una instancia de Employee
            // y como todo Employee es considerado a su vez un Person, también podemos acceder a los miembros de Person
            employee.setSalary(1500);
            // Toda instancia de tipo Employee es considera también una instancia de tipo Person
            // Todo Employee es un Person
            // Por tanto, mediante una referencia de tipo Employee podemos acceder a los miembros de la clase Person
            System.out.println(employee.getName());
        }

        if (obj instanceof Programmer programmer) {
            // la variable programmer contiene una referencia al objeto de tipo Programmer creado al principio
            // pero ahora la referencia es de tipo Programmer
            // y, por tanto, mediante esta referencia podemos acceder a los miembros específicos de la clase Programmer
            // e interactuar con el objeto tratándolo como una instancia de Programmer
            // y como todo Programmer es considerado a su vez un Employee, también podemos acceder a los miembros de Employee
            // y como todo Employee es considerado a su vez un Person, también podemos acceder a los miembros de Person
            // y como todo Person es considerado a su vez un Object, también podemos acceder a los miembros de Object
            programmer.setLanguage("Java");
            programmer.setAge(50);
            programmer.setSalary(1800);
            System.out.println(programmer.toString()); // Late binding del método toString
        }

    }
}
