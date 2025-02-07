package exercises.advanced.abstracts;


abstract sealed class Person permits Man, Woman {

    enum Gender {MALE, FEMALE}

    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract Gender getGender();
}

final class Man extends Person {

    public Man(String name) {
        super(name);
    }

    @Override
    Gender getGender() {
        return Gender.MALE;
    }
}

final class Woman extends Person {

    public Woman(String name) {
        super(name);
    }

    @Override
    Gender getGender() {
        return Gender.FEMALE;
    }
}


public class PeopleGenderDemo {

    public static void main(String[] args) {
        Man man = new Man("Adan");
        Woman woman = new Woman("Eva");
        Man jose = new Man("Jose");
        Woman maria = new Woman("Maria");

        System.out.println(man.getGender());
        System.out.println(woman.getGender());
        System.out.println(jose.getGender());
        System.out.println(maria.getGender());

        printPerson(man);
        printPerson(woman);
        printPerson(jose);
        printPerson(maria);
    }

    static void printPerson(Person person) {
        System.out.println(person.getName() + " is a " + person.getGender());
    }
}
