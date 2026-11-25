package gremios;

import java.time.LocalDate;

/** Datos personales comunes que el gremio debe proporcionar para cualquier héroe. */
public abstract class DatosHeroe {
    private final String nombre;
    private final String apodo;
    private final LocalDate fechaCreacion;

    protected DatosHeroe(String nombre, String apodo, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() { return nombre; }
    public String getApodo() { return apodo; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }
}
