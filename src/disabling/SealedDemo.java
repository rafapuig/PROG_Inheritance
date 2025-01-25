package disabling;

// Security solamente permite como subclases a las clases Password y Lock
abstract sealed class Security permits Password, Lock {
}

// Password no se puede heredar
final class Password extends Security {}

// Lock permite que otras clases deriven o extiendan de ella
non-sealed class Lock extends Security {}


// Alternativamente, podemos especificar todas las subclases dentro de la clase sellada
// El compilador asume que las clases definidas dentro de la clase sellada conforman la lista de subclases
abstract sealed class SecurityAlt {
    final class Password extends SecurityAlt {}
    non-sealed class Lock extends SecurityAlt {}
}

public class SealedDemo {
}


