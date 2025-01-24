package overriding;

class A {
    public void print() {
        System.out.println("A");
    }
}

class B extends A {
    @Override
    public void print() {
        System.out.println("B");
    }
}

class C extends B {
    // C hereda B.print()
}

class D extends C {
    // D hereda B.print() a través de C
}

class E extends D {
    @Override
    public void print() {
        System.out.println("E"); // Reemplaza la version B.print
    }
}

class F extends E {
    // F hereda E.print() a través de E
}

public class OverridingTest {
    public static void main(String[] args) {
        // Podemos asignar una referencia a un objeto cuyo tipo sea una clase A o descendente de A
        // a una variable de tipo A
        // Por eso, podemos usar a.print() en todas la siguientes instrucciones

        // El método print ha sido reemplazado en algunas de las clases descendentes de A en la jerarquía

        // El late binding realiza su magia llamando a la version apropiada del método print
        // dependiendo de la clase de objeto al cual la variable a refiere en el momento de ejecutar a.print()
        A a = new A();
        a.print(); // A
        a = new B();
        a.print(); // B
        a = new C();
        a.print(); // B
        a = new D();
        a.print(); // B
        a = new E();
        a.print(); // E
        a = new F();
        a.print(); // E
    }
}
