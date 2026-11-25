package gremios;

import java.time.LocalDate;

/** Producto abstracto del Factory Method: lo que todos los héroes tienen en común. */
public abstract class Heroe {
    private final String nombre;
    private final String apodo;
    private final LocalDate fechaCreacion;

    protected Heroe(String nombre, String apodo, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() { return nombre; }
    public String getApodo() { return apodo; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }

    /** Cada tipo de héroe describe sus atributos propios. */
    public abstract String describir();

    @Override
    public String toString() {
        return nombre + " '" + apodo + "' (creado " + fechaCreacion + ") - " + describir();
    }
}
