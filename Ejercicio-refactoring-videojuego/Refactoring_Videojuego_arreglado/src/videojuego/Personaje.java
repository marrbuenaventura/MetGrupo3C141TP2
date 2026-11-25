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

    // Hide Delegate: Videojuego ya no recorre la cadena getTipoHabilidad().calcularDaño(...)
    public double calcularDañoTotal() {
        return tipoHabilidad.calcularDaño(daño);
    }

    // Move Method: antes estaba en Videojuego. Sin if: se delega en la estrategia
    public void imprimirInfo() {
        System.out.println(nombre + " tiene como daño " + daño);
        System.out.println("Habilidad tipo " + tipoHabilidad.getTipo());
        System.out.println(tipoHabilidad.getDescripcion());
    }
}