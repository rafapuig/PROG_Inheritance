package exercises.astronomy;

public class AstronomyDemo {

    public static void main(String[] args) {
        Planet planet = new Planet("Earth", 213, 23, 1, 323, 365);
        System.out.println(planet);

        Satellite luna = new Satellite("Luna",34,3,23,32,planet);
        System.out.println(luna);
    }
}
