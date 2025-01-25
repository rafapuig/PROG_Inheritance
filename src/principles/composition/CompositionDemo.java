package principles.composition;

abstract class Transport {
    private final Engine engine;
    private Driver driver;

    public Transport(Engine engine) {
        this.engine = engine;
    }

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

        Transport autopilotElectricEngineTruck = new Truck(new ElectricEngine());
        autopilotElectricEngineTruck.setDriver(robotDriver);
        autopilotElectricEngineTruck.deliver("Valencia", "Paquete 002");
        autopilotElectricEngineTruck.setDriver(humanDriver);
        autopilotElectricEngineTruck.deliver("Barcelona", "Paquete 003");
    }
}


