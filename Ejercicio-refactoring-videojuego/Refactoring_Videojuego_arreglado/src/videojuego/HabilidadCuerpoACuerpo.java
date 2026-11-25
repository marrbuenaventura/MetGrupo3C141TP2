package videojuego;

public class HabilidadCuerpoACuerpo implements Habilidad {

    @Override
    public double calcularDaño(double daño) {
        return daño;
    }

    @Override
    public String getTipo() {
        return "habilidad Cuerpo a cuerpo";
    }

    @Override
    public String getDescripcion() {
        return "Este habilidad mantiene tu fuerza";
    }
}