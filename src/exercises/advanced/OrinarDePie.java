package exercises.advanced;

public class OrinarDePie implements Orinator {
    @Override
    public void orinate(Person person) {
        System.out.println(person.getName() + " Orinando de pie");
    }
}
