package constructors;

class Super {
    public Super() {
        //super(); // No necesario, inyectado por el compilador
        System.out.println("Dentro del constructor de la clase Super");
    }
}
class Sub extends Super {

    // El constructor de la clase primero llamará al constructor
    // de la clase base
    // El compilador inyecta automáticamente una llamada al constructor sin argumentos de la clase base
    // en cada constructor declarado en la subclase
    public Sub() {
        //super(); // No es necesario, es añadido automáticamente por el compilador
        System.out.println("Dentro del constructor de la clase Sub");
    }
}

public class ConstructorCallTest {
    public static void main(String[] args) {
        Sub sub = new Sub();
    }
}
