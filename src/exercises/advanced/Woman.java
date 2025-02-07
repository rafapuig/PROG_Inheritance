package exercises.advanced;

public class Woman extends Person {

    public Woman(String name, String surname) {
        super(name, surname);
        orinator = new OrinarSentado();
    }

    @Override
    public String getFullName() {
        return "Doña " + super.getFullName();
    }

    private boolean pregnate = false;

    public void becomePregnant() {
        if (pregnate == false) pregnate = true;
    }

    public void labor() {
        pregnate = false;
    }




}
