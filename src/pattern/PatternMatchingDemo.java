package pattern;

//Clase Person sellada y abstracta
// Únicamente tiene como subclases Man y Woman
// Hacer la clase abstracta nos permite asegurar que no se puedan crear objetos directamente de tipo Person
// se deben crear instancias de alguna de sus especializaciones
// En este caso, además se convierte en algo obligatorio dado que existe un método declarado como incompleto
// lo que implica que la clase no esté completamente implementada, lo cual no permite crear objetos de la clase
abstract sealed class Person permits Man, Woman {

    private final String name;
    private final int age;

    // Único constructor de la clase Person
    // Al proporcionar a la clase Person un constructor el compilador no añade el constructor sin argumentos
    // Esto obliga a proporcionar los argumentos de los parámetros name y age cuando se instancia un objeto Person
    public Person(String name, int age) {
        // En el constructor inicializamos los valores de los campos de la instancia creada
        // Usamos this.name porque el nombre del parámetro name al coincidir con el nombre del campo
        // deja inaccesible de forma directa el acceso al campo name
        this.name = name;
        // Lo mismo sucede con el campo age y el parámetro de entrada age
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Método abstracto
    // Somos conscientes de que toda persona tiene un modo formal de nombrarla
    // Por eso definimos el método en la clase Person
    // Sin embargo, no sabemos como implementarlo, por tanto, lo marcamos como abstracto
    // y obligamos a las subclases a implementarlo
    abstract String getFormalTitle();

    // El contar con el método abstracto getFormalTitle permite llamarlo en los métodos de la clase
    // y mediante el late binding dependiendo del tipo del objeto se determinará la implementación que se usa
    @Override
    public String toString() {
        return getFormalTitle() + " " + getName();
    }
}

// A la clase Man le es permitido heredar de la clase Person
// Sin embargo, al estar declarada como final, no se puede definir subclases de Man
final class Man extends Person {

    // La clase Man cuenta con un constructor al que hay que proporcionar los valores para inicializar los
    // campos de la superclase name y age más el campo adicional declarado en la clase Man hemophiliac
    public Man(String name, int age, boolean hemophiliac) {
        // Es necesario incluir como primera instrucción del constructor una llamada al constructor de la superclase
        // Ya que la superclase no cuenta con un constructor sin argumentos
        // Si no llamamos explícitamente al constructor de la superclase el compilador añadiría una llamada al constructor
        // sin argumentos, pero dado que la superclase no tiene constructor sin argumentos el código no compila
        // (prueba a eliminar/comentar la linea super(name, age); y comprueba el error que se produce)
        super(name, age); // Llamada al constructor de la clase base, primera instrucción
        // La llamada al constructor de la superclase inicializa el nombre y la edad
        this.hemophiliac = hemophiliac;
    }

    boolean hemophiliac;

    public boolean isHemophiliac() {
        return hemophiliac;
    }


    @Override
    String getFormalTitle() {
        return "Sr.";
    }

}

// A la clase Woman le está permitido heredar de la clase Person
// Sin embargo, al estar declarada como final, no se puede definir subclases de Woman
final class Woman extends Person {

    public Woman(String name, int age, boolean pregnant) {
        super(name, age); // Llamada al constructor de la clase base para (inicializar la persona que toda mujer es)
        this.pregnant = pregnant;
    }

    boolean pregnant;

    public boolean isPregnant() {
        return pregnant;
    }

    @Override
    String getFormalTitle() {
        return "Sra.";
    }
}


public class PatternMatchingDemo {

    static String getFormalName(Person person) {
        return switch (person) {
            case Man ignored -> "Sr. ";
            case Woman ignored -> "Sra. ";
        } + person.getName();
    }

    /**
     * El método getDetails usa la instrucción switch con correspondencia de patrón
     * Este tipo switch permite basarse en el tipo real del objeto para ejecutar un case u otro
     * Además permite indicar una variable en la que asignar una referencia con downcasting aplicado
     * que permite acceder a miembros específicos del objeto
     *
     * @param person referencia a una instancia de tipo Persona o subclase (Man o Woman), el metodo es polimorfico
     *               hace uso del polimorfismo de inclusión
     */
    static String getDetails(Person person) {
        return person.getName() + " " + person.getAge() + " years old" +
                switch (person) {
                    case Man man -> ", is hemofilic = " + man.isHemophiliac();
                    case Woman woman -> ", is pregnant = " + woman.isPregnant();
                };
    }

    public static void main(String[] args) {

        Person man = new Man("Armando", 20, true); // Upcasting
        Person woman = new Woman("Belen", 45, false); // Upcasting

        System.out.println(man);
        System.out.println(woman);

        System.out.println(getFormalName(man));
        System.out.println(getFormalName(woman));

        System.out.println(getDetails(man));
        System.out.println(getDetails(woman));
    }
}
