package exercises.advanced;

public class Pet implements Nameable, Vaccinable {
    private String name;

    @Override
    public String getName() {
        return name;
    }


    public  Pet(String name) {
        this.name = name;
    }

    @Override
    public void vaccinate(Vaccine vaccine) {
        System.out.println("Vacunando de " + vaccine.getName() + " a la mascota " + this.getName());
    }
}
