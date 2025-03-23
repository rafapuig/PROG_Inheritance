package exercises.astronomy;

import java.util.StringJoiner;

public abstract class CelestialBody {

    private final String name;
    private final double mass;
    private final double avgTemperature;

    public CelestialBody(String name, double mass, double avgTemperature) {
        this.name = name;
        this.mass = mass;
        this.avgTemperature = avgTemperature;
    }

    protected String fieldsToString() {
        return new StringJoiner(",")
                .add("name='" + name + "'")
                .add("mass=" + mass)
                .add("avgTemperature=" + avgTemperature)
                .toString();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "{", "}")
                .add(fieldsToString())
                .toString();
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getAvgTemperature() {
        return avgTemperature;
    }
}


