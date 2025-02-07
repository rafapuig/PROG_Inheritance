package exercises.advanced;

public class Demo {
    public static void main(String[] args) {
        Pet pet = new Pet("Mitu");
        Person person = new Person("Pepe","Leches");
        Vaccine vaccine = new Vaccine("Covid");

        Man man = new Man("Adan","de Dios");
        Woman woman = new Woman("Eva", "de Dios");
        Woman maria = new Woman("Maria", "de la Virgen");
        Man jose = new Man("Jose", "Carpenter");

        Orinator dePie = new OrinarDePie();
        Orinator sentado = new OrinarSentado();

        pet.getName();
        person.getName();

        printName(pet);
        printName(person);
        printName(vaccine);
        printName(man);
        printName(woman);
        man.getFullName();
        woman.getFullName();
        person.getFullName();

        printFullName(person);
        printFullName(woman);
        printFullName(man);

        man.pregnate(woman);

        person.orinar();
        man.orinar();
        woman.orinar();
        maria.orinar();
        jose.orinar();

        maria.setOrinator(dePie);
        maria.orinar();
        maria.setOrinator(sentado);
        maria.orinar();
        maria.setOrinator(null);
        maria.orinar();

        jose.setOrinator(sentado);
        jose.orinar();
        jose.setOrinator(null);
        jose.orinar();


        applyVaccine(pet, vaccine);
        applyVaccine(person, vaccine);
    }

    /*static void printName(Pet pet) {
        System.out.println(pet.getName());
    }

    static void printName(Person person) {
        System.out.println(person.getName());
    }*/

    static void printName(Nameable nameable) {
        System.out.println(nameable.getName());
    }

    static void applyVaccine(Vaccinable vaccinable, Vaccine vaccine) {
        vaccinable.vaccinate(vaccine);
    }

    static void printFullName(Person person) {
        System.out.println(person.getFullName());
    }
}
