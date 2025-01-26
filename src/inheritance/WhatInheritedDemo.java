package inheritance;

// Miembros de una clase
// Se consideran miembros de una clase:
// - los miembros (campos y métodos) declarados dentro del cuerpo de una clase
// - los miembros heredados de la superclase
//      - los miembros de la superclase son a su vez los declarados + heredados --> efecto dominó


/**
 * Se consideran miembros de la clase A
 * m1
 * m2
 * m3
 * Los miembros heredados de la clase base Object (campos y métodos no privados)
 */
class A {
    private int m1;
    protected int m2;
    public int m3;

    {
        // Miembros declarados dentro de la clase
        m1 = 4; // la clase puede acceder a su miembro privado
        m2 = 8;
        m3 = 9;
        // Miembros heredados desde la clase base Object
        hashCode();
        toString();
        equals(null);
        notify();
    }
}

/**
 * Se consideran miembros de la B
 * m4 - miembro declarado en la clase B
 * m5 - miembro declarado en la clase B
 * m6 - miembro declarado en la clase B *
 * Los miembros heredados desde la superclase A no privados:
 * - m2 por estar declarado dentro de la clase A (m1 es privado y NO se hereda por la clase B)
 * - m3 por estar declarado dentro de la clase A y no ser privado
 * - los miembros heredados por la clase A (miembros no privados de Object) *
 */
class B extends A {
    private int m4;
    protected int m5;
    public int m6;

    {
        m4 = 5; // miembro declarado en la clase (la clase puede usarlo directamente per al ser privado no se heredará)
        m5 = 6; // miembro declarado en la clase
        m6 = 7; // miembro declarado en la clase
        // m1 = 10; // No se hereda el miembro privado m1
        m2 = 50; // miembro heredado de la clase base A, por no ser privado (protected)
        m3 = 90; // miembro heredado de la clase base A, por no ser privado (public)
        //Miembros heredados por ser considerados miembros (heredados) de la superclase (efecto dominó)
        toString();
        hashCode();
    }
}

class C extends B {
    private int m7;
    protected int m8;
    public int m9;

    {
        // Acceso a todos los miembros declarados en la clase
        m7 = 7;
        m8 = 8;
        m9 = 9;
        //m4 = 5; // miembro declarado en la clase base con acceso privado, no se hereda
        m5 = 60; // miembro heredado desde la clase base (declarado dentro de la propia clase base B) protegido
        m6 = 70; // miembro heredado desde la clase base (declarado dentro de la propia clase base B) público

        //Miembros heredados por ser miembros (heredados) de la superclase (efecto dominó)
        m2 = 50; // miembro heredado desde la clase base B (al ser un miembro a su vez heredado por la base)
        m3 = 90; // miembro heredado desde la clase base B (al ser un miembro a su vez heredado por la base)
        toString(); // miembro heredado por ser un miembro a su vez heredado
        hashCode();
    }
}


/**
 * Dentro del cuerpo de la clase WhatInheritedDemo
 * se puede acceder mediante una referencia a los miembros protegidos de las clases A,B y C
 * porque la clase pertenece al mismo paquete que estas
 *
 * Si la clase estuviera en otro paquete solamente podría acceder a los miembros con nivel de acceso público
 */

public class WhatInheritedDemo {

    public static void main(String[] args) {
        // Código cliente (el mundo exterior a una clase y sus subclases)
        A a = new A();
        a.m2 = 1; // Java permite acceder a miembros protegidos a una clase del mismo paquete
        a.m3 = 1;
        a.toString();

        B b = new B();
        b.m2 = 2;
        b.m3 = 1;
        b.m5 = 5;
        b.m6 = 1;
        b.toString();

        C c = new C();
        c.m2 = 2;
        c.m3 = 1;
        c.m5 = 5;
        c.m6 = 1;
        c.m8 = 8;
        c.m9 = 9;
        c.toString();

        // Si guardamos una referencia al objeto de tipo C en una variable de tipo B
        B bc = c;
        //bc.m8 = 8; // No podemos acceder a los miembros específicos declarados en la clase C
        //bc.m9 = 9;
        bc.m6 = 6;  // Podemos acceder a los miembros de la clase B (declarados + heredados)
        bc.m5 = 5;
        bc.m3 = 3;
        bc.m2 = 2;
        bc.toString();


        // Si guardamos una referencia al objeto de tipo C en una variable de tipo A
        A ac = c;
        //ac.m8 = 8; // No podemos acceder a los miembros específicos declarados en la clase C
        //ac.m9 = 9;
        //ac.m6 = 6; // No podemos acceder a los miembros específicos declarados en la clase B
        //ac.m5 = 5;
        ac.m3 = 3;  // Podemos acceder a los miembros de la clase A (declarados + heredados)
        ac.m2 = 2;
        ac.toString();

        // Si guardamos una referencia al objeto de tipo C en una variable de tipo Object
        Object oc = c;
        //oc.m8 = 8; // No podemos acceder a los miembros específicos declarados en la clase C
        //oc.m9 = 9;
        //oc.m6 = 6; // No podemos acceder a los miembros específicos declarados en la clase B
        //oc.m5 = 5;
        //oc.m3 = 3; // No podemos acceder a los miembros específicos declarados en la clase A
        //oc.m2 = 2;
        oc.toString(); // Podemos acceder únicamente a los miembros de la clase Object

        // CONCLUSIÓN:
        // - El objeto referenciado siempre ha sido el mismo, el objeto instanciado de tipo C
        // - Lo que hemos variado es el tipo de referencia utilizado para acceder a sus miembros
        // - Cuanto más específica es la referencia (el tipo de la referencia), podemos acceder a más miembros
        // - Dada una referencia a un objeto, podemos acceder a los miembros (declarados y heredados)
        // que correspondan con la clase de la referencia
        // - Aunque el objeto sea de un tipo más específico,
        // con esa referencia NO podemos acceder a miembros de las clases descendentes de la clase de la referencia
    }

}
