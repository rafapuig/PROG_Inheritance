package exercises.advanced;

public class OrinarSentado implements Orinator {

    @Override
    public void orinate(Person person) {
        System.out.println(person.getName() + " Orinando sentado");
    }
}
