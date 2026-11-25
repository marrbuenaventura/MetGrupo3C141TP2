package videojuego;
public class Personaje {
    private String nombre;
    private double daño;
    private Habilidad tipoHabilidad;

    public Personaje(String nombre, double daño, Habilidad tipoHabilidad) {
        this.nombre = nombre;
        this.daño = daño;
        this.tipoHabilidad = tipoHabilidad;
    }
    public String getNombre() { return nombre; }
    public double getDaño() { return daño; }
    public Habilidad getTipoHabilidad() { return tipoHabilidad; }
}
