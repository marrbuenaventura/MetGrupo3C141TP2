package gremios;

import java.time.LocalDate;

/** Producto concreto: mago con una reserva de maná. */
public class Mago extends Heroe {
    private final int reservaMana;

    public Mago(String nombre, String apodo, LocalDate fechaCreacion, int reservaMana) {
        super(nombre, apodo, fechaCreacion);
        this.reservaMana = reservaMana;
    }

    public int getReservaMana() { return reservaMana; }

    @Override
    public String describir() {
        return "Mago | reserva de maná=" + reservaMana;
    }
}
