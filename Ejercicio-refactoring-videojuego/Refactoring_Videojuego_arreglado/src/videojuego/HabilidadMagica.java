package videojuego;

public class HabilidadMagica implements Habilidad {

    @Override
    public double calcularDaño(double daño) {
        return daño * 2;
    }

    @Override
    public String getTipo() {
        return "habilidad mágica";
    }

    @Override
    public String getDescripcion() {
        return "Esta habilidad dobla tu fuerza";
    }
}