package videojuego;

import java.util.ArrayList;
import java.util.List;

public class Videojuego {
    private List<Personaje> personajes = new ArrayList<>();

    public void agregar(Personaje p) { personajes.add(p); }

    public Personaje personajeConMasDaño() {
        Personaje masFuerte = null;   // Rename Variable (antes: temp)
        double max = 0;
        for (Personaje p : personajes) {
            double daño = p.calcularDañoTotal();   // Hide Delegate
            if (daño > max) {
                masFuerte = p;
                max = daño;
            }
        }
        return masFuerte;
    }

    public void imprimirInfo(Personaje p) {
        p.imprimirInfo();   // Move Method
    }
}