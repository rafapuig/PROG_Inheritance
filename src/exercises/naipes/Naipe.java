package exercises.naipes;

import java.util.HashMap;

public class Naipe {

    public static int count;

    private final Palo palo;
    private final Numero numero;

    public Naipe(Numero numero, Palo palo) {
        this.palo = palo;
        this.numero = numero;
        count++;
    }

    public Palo getPalo() {
        return palo;
    }

    public Numero getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return numero + " de " + palo;
    }

    private static final HashMap<Integer, Naipe> cache = new HashMap<>();

    private static int getNaipeKey(Numero numero, Palo palo) {
        return palo.ordinal() * 10 + numero.ordinal();
    }

    int getNaipeKey() {
        return getNaipeKey(numero, palo);
    }

    public static Naipe of(Numero numero, Palo palo) {
        int key = getNaipeKey(numero, palo);
        Naipe naipe = cache.get(key);
        if (naipe == null) {
            naipe = new Naipe(numero, palo);
            cache.put(key, naipe);
        }
        return naipe;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Naipe naipe)) return false;
        if (!palo.equals(naipe.palo)) return false;
        return numero.equals(naipe.numero);
    }

    @Override
    public int hashCode() {
        return getNaipeKey();
    }
}
