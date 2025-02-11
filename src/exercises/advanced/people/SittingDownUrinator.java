package exercises.advanced.people;

public class SittingDownUrinator implements Urinator {

    @Override
    public void urinate(Person person) {
        System.out.println(person.getName() + " Orinando sentado");
    }
}
