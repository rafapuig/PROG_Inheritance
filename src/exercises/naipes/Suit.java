package exercises.naipes;

import java.util.Arrays;

public abstract sealed class Suit {

    public static final Suit OROS = new Oros();
    public static final Suit COPAS = new Copas();
    public static final Suit ESPADAS = new Espadas();
    public static final Suit BASTOS = new Bastos();

    protected static Suit[] values = {OROS, COPAS, ESPADAS, BASTOS};

    private static Suit[] makeSystemCopy() {
        Suit[] copy = new Suit[values.length];
        System.arraycopy(values, 0, copy, 0, values.length);
        return copy;
    }

    private static Suit[] makeManualCopy() {
        Suit[] copy = new Suit[values.length];
        //Copia manual
        for (int i = 0; i < values.length; i++) {
            copy[i] = values[i];
        }
        return copy;
    }

    private static Suit[] makeCopy() {
        return Arrays.copyOf(values, values.length);
    }


    /**
     * Devuelve una copia al código cliente para que no pueda modificar la original
     */
    public static Suit[] values() {
        return makeCopy();
    }


    private int ordinal = -1;

    public final int ordinal() {
        if (ordinal == -1) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] == this) {
                    ordinal = i;
                    break;
                }
            }
        }
        return ordinal;
    }

    public abstract String name();

    @Override
    public int hashCode() {
        return ordinal();
    }

    @Override
    public String toString() {
        return name();
    }


    static final class Oros extends Suit {

        static {
            //OROS = new Oros();
        }

        private Oros() {
        }

        @Override
        public String name() {
            return "oros";
        }
    }

    static final class Copas extends Suit {
        private Copas() {
        }

        @Override
        public String name() {
            return "copas";
        }
    }

    static final class Espadas extends Suit {
        private Espadas() {
        }

        @Override
        public String name() {
            return "espadas";
        }
    }

    static final class Bastos extends Suit {
        private Bastos() {
        }

        @Override
        public String name() {
            return "bastos";
        }
    }
}

class SuitUtil {

    public static String toPokerTranslation(Suit suit) {
        String poker = switch (suit) {
            case Suit.Bastos ignored -> "tréboles";
            case Suit.Copas ignored -> "corazones";
            case Suit.Espadas ignored -> "picas";
            case Suit.Oros ignored -> "diamantes";
        };
        return poker;
    }

}

class SuitDemo {

    public static void main(String[] args) {
        System.out.println(Suit.OROS);
        System.out.println(Suit.COPAS);
        System.out.println(Suit.ESPADAS);
        System.out.println(Suit.BASTOS);


        //Suit.OROS = Suit.ESPADAS; // No deberia

        Suit oros = Suit.OROS;
        Suit copas = Suit.COPAS;
        Suit espadas = Suit.ESPADAS;
        Suit bastos = Suit.BASTOS;

        System.out.println(Suit.OROS == oros);

        for (Suit suit : Suit.values()) {
            System.out.println(suit.name());
            System.out.println(suit.ordinal());
        }

        for (Suit suit : Suit.values()) {

            System.out.println(suit.name() + " -> " + SuitUtil.toPokerTranslation(suit));
        }

        if(Suit.ESPADAS == Suit.BASTOS) {}
        Suit s = Suit.ESPADAS;

    }
}
