package binding;

class EarlyBindingSuper {

    // Variable de instancia
    public String anInstanceVar = "EarlyBindingSuper";

    // Variable estática
    public static int counter = 100;

    // Método estático
    public static void print() {
        System.out.println("Dentro del método EarlyBindingSuper.print()");
    }
}

/**
 * La clase EarlyBindingSub hereda de EarlyBindingSuper y declara los mismos
 * campos y métodos con el mismo tipo y nombre *
 * Los campos tienen distinto valor
 * El método imprime un mensaje diferente
 *
 * De esta manera podemos distinguir que versión de que clase es accedido cuando
 * se ejecute el código que intenta acceder al campo o llamar al método
 */

class EarlyBindingSub extends EarlyBindingSuper {

    // Variable de instancia
    public String anInstanceVar = "EarlyBindingSub";

    // Variable estática
    public static int counter = 200;

    // Método estático
    public static void print() {
        System.out.println("Dentro del método EarlyBindingSub.print()");
    }
}

/**
 * Para decidir la version del campo al que acceder o del código del método a ejecutar
 * se basa en el tipo de la variable o expresión mediante la cual se realiza el acceso o la llamada
 */
public class EarlyBindingTest {

    public static void main(String[] args) {
        EarlyBindingSuper ebSuper = new EarlyBindingSuper();
        EarlyBindingSub ebSub = new EarlyBindingSub();

        // Accede a EarlyBindingSuper.anInstanceVar (la variable ebSuper es de tipo EarlyBindingSuper)
        System.out.println(ebSuper.anInstanceVar);

        // Accede a EarlyBindingSuper.counter (la variable ebSuper es de tipo EarlyBindingSuper)
        System.out.println(ebSuper.counter); // 100

        // Accede a EarlyBindingSuper.print (la variable ebSuper es de tipo EarlyBindingSuper)
        ebSuper.print();
        System.out.println("--------------------------------------------------");

        // Accede a EarlyBindingSub.anInstanceVar (la variable ebSuper es de tipo EarlyBindingSub)
        System.out.println(ebSub.anInstanceVar);

        // Accede a EarlyBindingSub.counter (la variable ebSuper es de tipo EarlyBindingSub)
        System.out.println(ebSub.counter); // 100

        // Accede a EarlyBindingSub.print (la variable ebSuper es de tipo EarlyBindingSub)
        ebSub.print();
        System.out.println("--------------------------------------------------");

        // Accede a EarlyBindingSuper.anInstanceVar (la expresión es de tipo EarlyBindingSuper)
        System.out.println(((EarlyBindingSuper) ebSub).anInstanceVar);

        // Accede a EarlyBindingSuper.counter (la expresión es de tipo EarlyBindingSuper)
        System.out.println(((EarlyBindingSuper) ebSub).counter);

        // Accede a EarlyBindingSuper.print (la expresión es de tipo EarlyBindingSuper)
        ((EarlyBindingSuper) ebSub).print();
        System.out.println("--------------------------------------------------");

        ebSuper = ebSub; // Upcasting

        //Aunque el tipo del objeto referenciado por la variable ebSuper es EarlyBindingSub
        //el tipo de la variable utilizado para acceder al los campos y métodos es de tipo EarlyBindingSuper
        // Por eso, se accede a la version de los campos y métodos de la clase que coincide con el tipo de la variable
        // no con el tipo del objeto referenciado por la variable


        // Accede a EarlyBindingSuper.anInstanceVar (la variable ebSuper es de tipo EarlyBindingSuper)
        System.out.println(ebSuper.anInstanceVar);

        // Accede a EarlyBindingSuper.counter (la variable ebSuper es de tipo EarlyBindingSuper)
        System.out.println(ebSuper.counter); // 100

        // Accede a EarlyBindingSuper.print (la variable ebSuper es de tipo EarlyBindingSuper)
        ebSuper.print();
        System.out.println("--------------------------------------------------");
    }

}
