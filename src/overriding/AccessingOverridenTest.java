package overriding;

class AOAncestor {

    public void print() {
        System.out.println("Dentro de AOAncestor.print()");
    }

    public void printNotOverridden() {
        System.out.println("Dentro de AOAncestor.printNotOverridden()");
    }

}

class AOSuper extends AOAncestor {
    @Override
    public void print() {
        System.out.println("Dentro de AOSuper.print()");
    }
}

class AOSub extends AOSuper {

    public void print() {
        super.print(); // Llama al método reemplazado AOSuper.print
        System.out.println("Dentro de AOSub.print()");
    }

    public void callOverriddenPrint() {
        super.print(); // Llama al método reemplazado (versión de AOSuper)
        // Es imposible llamar desde AOSub a la version de AOAncestor del método print porque ha sido reemplazada
        // en la clase AOSuper
        printNotOverridden(); // Llama a la versión más próxima ascendiendo por la jerarquía
    }
}

public class AccessingOverridenTest {

    public static void main(String[] args) {
        AOSub aoSub = new AOSub();
        aoSub.print();
        aoSub.callOverriddenPrint();
    }
}
