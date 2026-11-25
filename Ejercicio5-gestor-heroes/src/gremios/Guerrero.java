package gremios;

import java.time.LocalDate;

/** Producto concreto: guerrero con poder de ataque, victorias y bono por victoria. */
public class Guerrero extends Heroe {
    private final double poderAtaque;
    private final int victorias;
    private final double bonoPorVictoria;

    public Guerrero(String nombre, String apodo, LocalDate fechaCreacion,
                    double poderAtaque, int victorias, double bonoPorVictoria) {
        super(nombre, apodo, fechaCreacion);
        this.poderAtaque = poderAtaque;
        this.victorias = victorias;
        this.bonoPorVictoria = bonoPorVictoria;
    }

    public double getPoderAtaque() { return poderAtaque; }
    public int getVictorias() { return victorias; }
    public double getBonoPorVictoria() { return bonoPorVictoria; }

    /** Poder real en combate: ataque base + bono acumulado por las victorias. */
    public double calcularPoderTotal() {
        return poderAtaque + victorias * bonoPorVictoria;
    }

    @Override
    public String describir() {
        return "Guerrero | ataque=" + poderAtaque + ", victorias=" + victorias
                + ", bono/victoria=" + bonoPorVictoria + ", poder total=" + calcularPoderTotal();
    }
}
