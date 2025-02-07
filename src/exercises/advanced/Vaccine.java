package exercises.advanced;

public class Vaccine implements Nameable {

    private final String name;

    public Vaccine(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
