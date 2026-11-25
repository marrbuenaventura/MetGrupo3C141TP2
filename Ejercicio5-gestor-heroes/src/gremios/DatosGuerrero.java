package gremios;

import java.time.LocalDate;

public class DatosGuerrero extends DatosHeroe {
    private final double poderAtaque;
    private final int victorias;
    private final double bonoPorVictoria;

    public DatosGuerrero(String nombre, String apodo, LocalDate fechaCreacion,
                         double poderAtaque, int victorias, double bonoPorVictoria) {
        super(nombre, apodo, fechaCreacion);
        this.poderAtaque = poderAtaque;
        this.victorias = victorias;
        this.bonoPorVictoria = bonoPorVictoria;
    }

    public double getPoderAtaque() { return poderAtaque; }
    public int getVictorias() { return victorias; }
    public double getBonoPorVictoria() { return bonoPorVictoria; }
}
