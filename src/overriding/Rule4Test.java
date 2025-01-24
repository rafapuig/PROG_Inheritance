package overriding;

import java.util.Random;

class Person {
    public void print() {
        System.out.println("Soy un Person");
    }
}

class Employee extends Person {
    public void print() {
        System.out.println("Soy un Employee");
    }
}


/**
 * La clase P define un método getPerson() que devuelve una referencia de tipo Person
 */
class P {
    public Person getPerson() {
        System.out.println("Dentro de P.getPerson()");
        return new Person();
    }
}

/**
 * La clase Q reemplaza el método getPerson heredado de la clase base P
 * También devuelve una referencia de tipo Person,
 * pero a un objeto de tipo Person o Employee (aleatorio)
 * Los objetos de tipo Q usarán esta versión del método getPerson cuando
 * a través de una referencia, sea de tipo P o Q, se llame al método getPerson
 */
class Q extends P {
    @Override
    public Person getPerson() {
        System.out.println("Dentro de Q.getPerson()");
        return new Random().nextBoolean()? new Employee() : new Person();
    }
}

/**
 * En la clase R queremos asegurar que el tipo concreto o especifico de Person
 * es un Employee.
 * Podemos cambiar el tipo de valor retornado por el método getPerson a Employee
 * Gracias a la relación es-un de la herencia entre un Employee y un Person
 * Cualquier objeto de tipo Employee se considera también un objeto de tipo Person
 */
class R extends Q {

    // El método getPerson devuelve una referencia de tipo Employee (no Person)
    // Una referencia Employee es compatible con una de tipo Person
    // Este método siempre devuelve una referencia a un objeto de tipo Employee
    @Override
    public Employee getPerson() {
        System.out.println("Dentro de R.getPerson()");
        return new Employee();
    }
}

public class Rule4Test {
    public static void main(String[] args) {
        Person person;
        P p;
        p = new P();

        person = p.getPerson(); // Devuelve un objeto de tipo Person
        person.print();

        p = new Q();
        person = p.getPerson(); // Devuelve un objeto de tipo Person o descendente
        person.print();

        // Ahora p apunta a un objeto de clase R
        p = new R();

        // Se llamará a la version getPerson reemplazada de la clase R
        // Esta versión devuelve una referencia de tipo Employee
        // El método siempre devuelve un objeto de tipo Employee o descendente
        // Esta referencia se puede asignar a una variable de tipo Person
        // Se trata de un upcasting llevado a cabo de manera implícita
        person = p.getPerson(); // Upcasting
        person.print();
    }
}
