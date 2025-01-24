package binding;

class LateBindingSuper {
    public void print() {
        System.out.println("Dentro de LateBindingSuper.print()");
    }
}

class LateBindingSub extends LateBindingSuper {
    public void print() {
        System.out.println("Dentro de LateBindingSub.print()");
    }
}

/**
 * En el enlace tardío la correspondencia se lleva a cabo basándose en el tipo real del objeto referenciado
 * y no en el tipo de la referencia (determinada a partir del tipo de la variable o expresión) a traves de la
 * cual se realiza la llamada al método
 */

public class LateBindingTest {
    public static void main(String[] args) {
        LateBindingSuper lbSuper = new LateBindingSuper();
        LateBindingSub lbSub = new LateBindingSub();

        // Enlaza con LateBindingSuper.print (el objeto referenciado por lbSuper es de tipo LateBindingSuper)
        lbSuper.print();

        // Enlaza con LateBindingSub.print (el objeto referenciado por lbSub es de tipo LateBindingSub)
        lbSub.print();

        // Enlaza con LateBindingSub.print (el objeto referenciado por lbSub es de tipo LateBindingSub)
        // La expresión (resultado de hacer el casting) es de tipo LateBindingSuper, pero el tipo del objeto no varía
        ((LateBindingSuper) lbSub).print();

        // Una variable referencia de tipo LateBindingSuper puede referenciar a un objeto de tipo LateBindingSuper
        // y también a un objeto de tipo sea descendente
        lbSuper = lbSub; // Upcasting

        // Enlaza con LateBindingSub.print (el objeto referenciado por lbSuer es de tipo LateBindingSub)
        lbSuper.print();

    }
}
