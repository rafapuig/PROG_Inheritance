package exercises.coches.demo;

import exercises.coches.Coche;
import exercises.coches.CocheCambioAutomatico;
import exercises.coches.CocheCambioManual;
import exercises.coches.Coches;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CochesDemo {

    private static final Scanner scanner = new Scanner(System.in);

    private static String inputMatricula() {
        System.out.print("Introduce matricula: ");
        return scanner.nextLine();
    }

    private static void printMenuTipoCoche() {
        System.out.println("======= TIPO DE CAMBIO =======");
        System.out.println();
        System.out.println("1. Cambio Automático");
        System.out.println("2. Cambio Manual");
        System.out.println();
        System.out.print("Selecciona una opción:");
    }

    private static String inputTipoCoche() {

        while (true) {
            try {
                printMenuTipoCoche(); // Imprimimos el menu de opciones
                int opcion = scanner.nextInt();

                switch (opcion) { // Según la opción elegida
                    case 1:
                        return Coches.AUTOMATIC;
                    case 2:
                        return Coches.MANUAL;
                    default:
                        System.out.println("Opción no valida!");
                }

            } catch (InputMismatchException exception) {
                System.out.println("La opción debe ser un número");
                scanner.nextLine(); // Vaciar el scanner para poder leer otro entero
            }
        }
    }

    static void printCoche(Coche coche) {
        System.out.println(coche);
    }


    public static void main(String[] args) {

        String matricula = inputMatricula();

        String tipoCoche = inputTipoCoche();

        Coche coche = Coches.createCoche(tipoCoche, matricula);

        System.out.println(">>>>>>>>>> Inicialmente el coche:");
        printCoche(coche);

        System.out.println(">>>>>>>>>> Acelero a 60 km/h");
        coche.acelerar(60);

        // Comprobamos si el tipo real del objeto referenciado por coche es CocheCambioManual
        if (coche instanceof CocheCambioManual cocheCambioManual) { // El downcasting a CocheManual es correcto

            // Incorrecto, no se puede llamar al metodo porque si la referencia es de tipo Coche el acceso es protected
            // y la clase CochesDemo está en otro paquete y no es subclase de Coche
            //coche.cambiarMarcha(3);

            // Si no usamos una referencia de tipo CocheCambioManual no podemos llamar al metodo cambiarMarcha
            cocheCambioManual.cambiarMarcha(3);
        }
        printCoche(coche);


        // Ahora hacemos lo mismo pero con el switch con pattern matching
        coche.acelerar(90); // Primero lo aceleramos

        switch (coche) { // Segun el tipo real de objeto referenciando por la variable coche
            case CocheCambioManual cocheCambioManual -> cocheCambioManual.cambiarMarcha(5);
            case CocheCambioAutomatico ignored -> System.out.println("Cambio automático de marcha");
        }
        printCoche(coche);
    }

}
