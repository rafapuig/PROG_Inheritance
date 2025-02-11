package principles.composition;

abstract class Transport {
    private final Engine engine;
    private Driver driver;

    /**
     * El transporte no puede cambiar de motor una vez creado
     */
    public Transport(Engine engine) {
        this.engine = engine;
    }

    /**
     * El transporte puede cambiar de conductor
     */
    public Transport setDriver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public void deliver(String destination, String cargo) {
        driver.navigate();
        engine.move();
    }
}

class Car extends Transport {
    public Car(Engine engine) {
        super(engine);
    }
}

class Truck extends Transport {
    public Truck(Engine engine) {
        super(engine);
    }
}


abstract class Engine {
    public abstract void move();
}

class CombustionEngine extends Engine {
    @Override
    public void move() {
        System.out.println("Moving with Combustion Engine");
    }
}

class ElectricEngine extends Engine {

    @Override
    public void move() {
        System.out.println("Moving with Electric Engine");
    }
}

/**
 * La forma correcta de programar el tipo Driver es mediante una interface
 * Porque es una clase abstracta en la que todos sus miembros son abstractos
 * y no tiene estado (no hay ningún campo de instancia)
 * (ya se verá en el tema de interfaces)
 */
abstract class Driver {
    public abstract void navigate();
}

class Robot extends Driver {
    @Override
    public void navigate() {
        System.out.println("Robot navigated");
    }
}

class Human extends Driver {
    @Override
    public void navigate() {
        System.out.println("Human navigated");
    }
}

public class CompositionDemo {

    public static void main(String[] args) {

        Driver humanDriver = new Human();
        Driver robotDriver = new Robot();

        Transport autopilotCombustionEngineCar = new Car(new CombustionEngine()).setDriver(robotDriver);
        autopilotCombustionEngineCar.deliver("Madrid","Paquete 001");

        Transport electricEngineTruck = new Truck(new ElectricEngine());
        electricEngineTruck.setDriver(robotDriver);
        electricEngineTruck.deliver("Valencia", "Paquete 002");
        electricEngineTruck.setDriver(humanDriver);
        electricEngineTruck.deliver("Barcelona", "Paquete 003");

        Transport combustionEngineTruck = new Truck(new CombustionEngine());
        combustionEngineTruck.setDriver(humanDriver);

        Transport electricEngineCar = new Car(new ElectricEngine());
    }
}


