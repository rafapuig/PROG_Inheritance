package exercises.astronomy;

import java.util.StringJoiner;

public class Satellite extends CelestialBody {

    private double planetDistance;
    private double planetOrbita;
    private Planet planet;


    public Satellite(String name, double mass, double avgTemperature, double planetDistance, double planetOrbita, Planet planet) {
        super(name, mass, avgTemperature);
        this.planetDistance = planetDistance;
        this.planetOrbita = planetOrbita;
        this.planet = planet;
    }

    @Override
    protected String fieldsToString() {
        return new StringJoiner(", ")
                .add(super.fieldsToString())
                .add("planetDistance=" + planetDistance)
                .add("planetOrbita=" + planetOrbita)
                .add("planet=" + planet)
                .toString();
    }

}
