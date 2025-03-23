package exercises.coches;

public class Coches {

    public static final String MANUAL = "Coche cambio Manual";
    public static final String AUTOMATIC = "Coche cambio Automático";

    /**
     * Metodo factoría de coches según el tipo
     */
    public static Coche createCoche(String tipoCoche, String matricula) {
        return switch (tipoCoche) {
            case MANUAL -> new CocheCambioManual(matricula);
            case AUTOMATIC -> new CocheCambioAutomatico(matricula);
            default -> throw new IllegalArgumentException("El tipo de coche no es valido");
        };
    }
}
