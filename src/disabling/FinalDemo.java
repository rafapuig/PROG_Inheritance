package disabling;

// No se puede heredar de una clase final
// Una clase declarada como final no permite crear subclases que usen a esta clase como superclase
final class SecurityFinal {}

// No compila. No se puede heredar de la clase SecurityFinal
//class CrackedSecurity extends SecurityFinal {}

class A {

    // Método de instancia declarado final
    // no se podrá reemplazar en las subclases
    // Cuando el compilador encuentre en el código que se usa una referencia de tipo A o derivada
    // ya sabe al no ser reemplazable esta implementación por ninguna subclase
    // se puede hacer binding en tiempo de compilación con esta versión del método
    public final void m1() {}
    public void m2() {}

    public static final void sm1() {}
    public static void sm2() {}
}

class B extends A {

    // No compila. El método m1 es final y no se puede reemplazar
    //@Override
    //public void m1() { }

    //El método m2 no es final y se puede redefinir (reemplazar) en la subclase
    @Override
    public void m2() { }

    // No compila. El método estático sm1 es final y no se puede redefinir en la subclase
    //public static void sm1() { }

    //El método estático sm2 no es final y se puede redefinir (ocultar) en la subclase
    public static void sm2() { }
}


public class FinalDemo {
}
