package gremios;

import java.time.LocalDate;

public class DatosMago extends DatosHeroe {
    private final int reservaMana;

    public DatosMago(String nombre, String apodo, LocalDate fechaCreacion, int reservaMana) {
        super(nombre, apodo, fechaCreacion);
        this.reservaMana = reservaMana;
    }

    public int getReservaMana() { return reservaMana; }
}
