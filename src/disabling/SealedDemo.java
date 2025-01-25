package disabling;

// Security solamente permite como subclases a las clases Password y Lock
abstract sealed class Security permits Password, Lock {
}

// Password no se puede heredar
final class Password extends Security {}

// Lock permite que otras clases deriven o extiendan de ella
non-sealed class Lock extends Security {}

public class SealedDemo {
}
