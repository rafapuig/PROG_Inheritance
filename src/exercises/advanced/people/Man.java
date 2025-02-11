package exercises.advanced.people;

public class Man extends Person {

    public Man(String name, String surname) {
        super(name,surname);
        urinator = new StandingUpUrinator();
    }

    @Override
    public String getFullName() {
        return "Don " + super.getFullName();
    }

    void pregnate(Woman woman) {
        woman.becomePregnant();
    }

}
