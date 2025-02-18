package exercises.manualenums;

import java.util.Random;

public abstract sealed class Sexo permits Masculino, Femenino {

    public static final Sexo MASCULINO;
    public static final Sexo FEMENINO;

    static {
        MASCULINO = Masculino.INSTANCE;
        FEMENINO = Femenino.getInstance();
    }

    public abstract String name();

    @Override
    public String toString() {
        return name();
    }
}

// hay que definir su estatus obligatoriamente --> final
final class Masculino extends Sexo {

    final static Masculino INSTANCE = new Masculino();

    private Masculino() {}

    @Override
    public String name() {
        return "masculino";
    }
}


final class Femenino extends Sexo {

    private static volatile Femenino INSTANCE = null; // = new Femenino();

    public static Femenino getInstance() {
        if (INSTANCE != null) return INSTANCE;

        synchronized (Femenino.class) {
            if (Femenino.INSTANCE == null) {
                Femenino.INSTANCE = new Femenino();
            }
        }
        return Femenino.INSTANCE;
    }

    private Femenino() {}

    @Override
    public String name() {
        return "femenino";
    }
}

//class MachoAlfa extends Masculino {} // No se puede heredar de una clase final
//final class TercerSexo extends Sexo {} // No se permite heredar si no forma parte de la lista permits


class SexoTest {

    public static void main(String[] args) {
        //new Sexo(); // No se pueden crear instancias de la clase abstracta Sexo
        Sexo sexo = null; // Se pueden declarar variables del tipo de clase abstracta

        // Se pueden crear instancias de las subclases
        //Sexo masculino = new Masculino(); //Upcasting implícito
        //Masculino.MASCULINO = new Masculino();

        //Sexo femenino = (Sexo) Femenino(); // Upcasting explícito (no necesario)

        //Object object = new Masculino();

        //Sexo machoAlfa = new MachoAlfa();
        //Sexo tercerSexo = new TercerSexo();

        //Sexo.MASCULINO = Sexo.FEMENINO;

        sexo = Sexo.MASCULINO;
        System.out.println(sexo);
        sexo = Sexo.FEMENINO;
        System.out.println(sexo);



        //testPatternSwitch();
    }


    static void testPatternSwitch() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Sexo s = random.nextBoolean() ? Masculino.INSTANCE : Femenino.getInstance();
            switch (s) {
                case Masculino ignored -> System.out.println("Masculino");
                case Femenino ignored -> System.out.println("Femenino");
            }
        }


    }
}
