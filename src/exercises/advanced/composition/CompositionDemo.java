package exercises.advanced.composition;


import java.util.StringJoiner;

class Name {
    private final String firstName;
    private final String lastName;
    private final String middleName;

    //Patron builder....


    public Name(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    String getFullName() {
        StringJoiner sj = new StringJoiner(" ");
        sj.setEmptyValue("Anónimo");
        if (firstName != null && !firstName.isEmpty()) {
            sj.add(firstName);
        }
        if (middleName != null && !middleName.isEmpty()) {
            sj.add(middleName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            sj.add(lastName);
        }
        return sj.toString();
    }


}

class Person {

    private final Name name;
    int edad;

    Person(String firstName, String lastName, int edad) {
        this(firstName, null, lastName, edad);
    }

    Person(String firstName, String middleName, String lastName, int edad) {
        this.name = new Name(firstName, middleName, lastName);
        this.edad = edad;
    }

    Person(Name name, int edad) {
        this(name.getFirstName(), name.getMiddleName(), name.getLastName(), edad);
    }

    public int getEdad() {
        return edad;
    }

    public String getFirstName() {
        return name.getFirstName();
    }

    public String getMiddleName() {
        return name.getMiddleName();
    }

    public String getLastName() {
        return name.getLastName();
    }

    public String getFullName() {
        return name.getFullName();
    }

}


public class CompositionDemo {

    public static void main(String[] args) {
        Name name = new Name("Armando", "Bronca", "Segura");
        System.out.println(name.getFullName());

        Person perico = new Person("Perico", "Palotes", 23);
        System.out.println(perico.getFullName());

        Person armando = new Person(name, 45);
        System.out.println(armando.getFullName());

    }
}
