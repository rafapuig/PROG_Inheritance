package exercises.naipes;

public class Main {

    public static void main(String[] args) {
        testPalo();
        testNumero();
        testNaipe();
    }

    static void testPalo() {
        Palo copas = Palo.COPAS;
        Palo espadas = Palo.ESPADAS;

        Palo palo = Palo.OROS;
        if(palo == Palo.ESPADAS) {}
    }

    static void testNumero() {
        Numero as = Numero.AS;
        Numero rey = Numero.REY;
    }

    static void testNaipe() {
        Naipe naipe = new Naipe(Numero.CABALLO, Palo.ESPADAS);
        Naipe naipe2 = Naipe.of(Numero.CUATRO,Palo.ESPADAS);
        Naipe naipe1 = Naipe.of(Numero.CUATRO, Palo.ESPADAS);
        Naipe naipe3 = Naipe.of(Numero.SOTA, Palo.ESPADAS);
        System.out.println(Naipe.count);
        System.out.println(naipe.hashCode());
        System.out.println(naipe1.hashCode());
        System.out.println(naipe2.hashCode());
        System.out.println(naipe3.hashCode());

        System.out.println(naipe1);
        System.out.println(naipe3);
        System.out.println(naipe);

        for (int i = 0; i < Palo.values().length; i++) {
            System.out.println(Palo.values()[i].hashCode());
        }

        Palo[] copy = Palo.values();
        copy[0] = Palo.ESPADAS;
        copy[3] = Palo.ESPADAS;

        for (int i = 0; i < Palo.values().length; i++) {
            System.out.println(Palo.values()[i]);
        }

        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i]);
        }

    }
}
