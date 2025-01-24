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
        A a = new A();
        a.print(); // A
        B b = new B();
        b.print(); // B
        C c = new C();
        c.print(); // B
        D d = new D();
        d.print(); // B
        E e = new E();
        e.print(); // E
        F f = new F();
        f.print(); // E
    }
}
