package exercises.astronomy;

import java.util.List;
import java.util.StringJoiner;

public class Planet extends CelestialBody {

    private double distanceToStar;
    private double orbToStart;
    private int numSatellites;

    //List<Satellite> satelliteList;


    public Planet(String name, double mass, double avgTemperature,
                  int numSatellites, double distanceToStar, double orbToStart) {
        super(name, mass, avgTemperature);
        this.numSatellites = numSatellites;
        this.distanceToStar = distanceToStar;
        this.orbToStart = orbToStart;
    }

    @Override
    protected String fieldsToString() {
        return new StringJoiner(",")
                .add(super.fieldsToString())
                .add("distanceToStar=" + distanceToStar)
                .add("orbToStart=" + orbToStart)
                .add("numSatellites=" + numSatellites)
                .toString();
    }

}
