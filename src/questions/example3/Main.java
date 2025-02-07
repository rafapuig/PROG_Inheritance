package questions.example3;

class Banquete {
    protected int comensales = 0;

    public int getComensales() {
        return comensales;
    }
}


/**
 * Un banquete con extra tiene como comensales totales el número de invitados más uno extra
 */
class BanqueteConExtra extends Banquete {

    public BanqueteConExtra(int invitados) {
        super.comensales = invitados + 1; // mas el comensal extra
    }
}

/**
 * Una boda es un banquete con un comensal extra, el cura
 * más dos comensales más: el novio y la novia
 */
class BanqueteBoda extends BanqueteConExtra {
    /**
     * Una boda tiene dos comensales mas adicionales al número de invitados (el novio y la novia)
     */
    public BanqueteBoda(int invitados) {
        // El banquete de boda es un banquete con un extra a tener en cuenta (el cura)
        super(invitados + 2);
    }
}

public class Main {

    public static void main(String[] args) {
        // Un banquete con extra de 4 invitados tendrá 5 comensales
        BanqueteConExtra banquete = new BanqueteConExtra(4);

        // El banquete empieza con 5 invitados: 4 + el extra (¿un fotógrafo?)
        banquete = promocionarABoda(banquete); // Al promocionar se le añade el cura y los novios 5 + 1 + 2 = 8
        System.out.println(banquete.getComensales()); // Total 8 comensales
    }

    /**
     * Crea un banquete de boda con los comensales del banquete proporcionado mas un extra (el cura)
     * más dos comensales mas ( el novio y la novia)
     */
    static BanqueteBoda promocionarABoda(Banquete banquete) {
        BanqueteBoda boda = new BanqueteBoda(banquete.getComensales());
        return boda;
    }
}