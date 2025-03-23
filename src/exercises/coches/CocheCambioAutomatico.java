package exercises.coches;

public final class CocheCambioAutomatico extends Coche {

    public CocheCambioAutomatico(String matricula) {
        super(matricula);
    }

    @Override
    public void acelerar(double velocidad) {
        super.acelerar(velocidad);
        cambiarMarcha();
    }

    @Override
    public void frenar(double velocidad) {
        super.frenar(velocidad);
        cambiarMarcha();
    }

    private void cambiarMarcha() {
        if (this.getVelocidad() <= 20) {
            cambiarMarcha(1);
        } else if (this.getVelocidad() >= 20 && this.getVelocidad() <= 45) {
            cambiarMarcha(2);
        } else if (this.getVelocidad() > 45 && this.getVelocidad() <= 70) {
            cambiarMarcha(3);
        } else if (this.getVelocidad() > 70 && this.getVelocidad() <= 100) {
            cambiarMarcha(4);
        } else if (this.getVelocidad() > 100) {
            cambiarMarcha(5);
        }
    }

}
