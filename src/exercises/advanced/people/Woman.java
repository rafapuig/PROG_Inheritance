package exercises.advanced.people;

public class Woman extends Person {

    public Woman(String name, String surname) {
        super(name, surname);
        urinator = new SittingDownUrinator();
    }

    @Override
    public String getFullName() {
        return "Doña " + super.getFullName();
    }

    private boolean pregnate = false;

    public void becomePregnant() {
        if (!pregnate) pregnate = true;
    }

    public void labor() {
        pregnate = false;
    }

}
