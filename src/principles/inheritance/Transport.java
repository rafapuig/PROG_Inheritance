package principles.inheritance;

class Transport {}

class Truck extends Transport {}
class Car extends Transport {}

class ElectricTruck extends Truck {}
class ElectricCar extends Car {}

class CombustionEngineTruck extends Truck {}
class CombustionEngineCar extends Car {}

class AutopilotElectricTruck extends ElectricTruck {}
class AutopilotCombustionTruck extends CombustionEngineTruck {}

class AutopilotElectricCar extends ElectricCar {}
class AutopilotCombustionEngineCar extends CombustionEngineCar {}