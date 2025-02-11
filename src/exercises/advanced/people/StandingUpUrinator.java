package exercises.advanced.people;

public class StandingUpUrinator implements Urinator {
    @Override
    public void urinate(Person person) {
        System.out.println(person.getName() + " Orinando de pie");
    }
}
