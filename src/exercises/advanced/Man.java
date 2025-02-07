package exercises.advanced;

public class Man extends Person {

    public Man(String name, String surname) {
        super(name,surname);
        orinator = new OrinarDePie();
    }

    @Override
    public String getFullName() {
        return "Don " + super.getFullName();
    }

    void pregnate(Woman woman) {
        woman.becomePregnant();
    }

}
