package exercises.advanced.people;


public class Person implements Nameable, Vaccinable {

    private final String name;
    private final String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public void vaccinate(Vaccine vaccine) {
        System.out.println("Vacunando de " + vaccine.getName() + " a la persona " + getName());
    }

    public String getFullName() {
        return name + " " + surname;
    }



    protected Urinator urinator = null;

    public void setUrinator(Urinator urinator) {
        this.urinator = urinator;
    }

    public void urinate() {
        if (urinator != null) {
            urinator.urinate(this);
        } else {
            System.out.println(getName() + " orinando...");
        }
    }

}
