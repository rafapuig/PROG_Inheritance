package exercises.coches;

import java.util.StringJoiner;

public abstract sealed class Coche permits CocheCambioAutomatico, CocheCambioManual {

    private final String matricula;
    private int marcha;
    private double velocidad;

    public Coche(String matricula) {
        this.matricula = matricula;
        marcha = 0;
        velocidad = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getMarcha() {
        return marcha;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void acelerar(double velocidad) {
        if (velocidad < 0) return;
        this.velocidad += velocidad;
    }

    public void frenar(double velocidad) {
        if (velocidad < 0) return;
        this.velocidad = Math.max(this.velocidad - velocidad, 0);
    }

    /**
     * No se permite cambiar a una marcha negativa
     */
    protected void cambiarMarcha(int marcha) {
        if (marcha < 0) return;
        this.marcha = marcha;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", " , getClass().getSimpleName() + " {", "}");
        sj.add("Matricula: " + matricula);
        sj.add("Velocidad: " + velocidad);
        sj.add("Marcha: " + marcha);
        return sj.toString();
    }
}
