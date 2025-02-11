package exercises.advanced.people;

public class Demo {
    public static void main(String[] args) {
        Pet pet = new Pet("Mitu");
        Person person = new Person("Pepe","Leches");
        Vaccine vaccine = new Vaccine("Covid");

        Man man = new Man("Adan","de Dios");
        Woman woman = new Woman("Eva", "de Dios");
        Woman maria = new Woman("Maria", "de la Virgen");
        Man jose = new Man("Jose", "Carpenter");

        Urinator dePie = new StandingUpUrinator();
        Urinator sentado = new SittingDownUrinator();

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

        person.urinate();
        man.urinate();
        woman.urinate();
        maria.urinate();
        jose.urinate();

        maria.setUrinator(dePie);
        maria.urinate();
        maria.setUrinator(sentado);
        maria.urinate();
        maria.setUrinator(null);
        maria.urinate();

        jose.setUrinator(sentado);
        jose.urinate();
        jose.setUrinator(null);
        jose.urinate();


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
