package exercises.advanced;


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



    protected Orinator orinator = null;

    public void setOrinator(Orinator orinator) {
        this.orinator = orinator;
    }

    public void orinar() {
        if (orinator != null) {
            orinator.orinate(this);
        } else {
            System.out.println(getName() + " orinando...");
        }
    }

}
