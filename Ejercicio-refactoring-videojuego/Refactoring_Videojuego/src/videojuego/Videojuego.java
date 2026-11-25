package videojuego;

// Videojuego.java (el de la captura, con los errores corregidos)
import java.util.ArrayList;
import java.util.List;

public class Videojuego {
    private List<Personaje> personajes = new ArrayList<>();

    public void agregar(Personaje p) { personajes.add(p); }

    public Personaje personajeConMasDaño() {
        Personaje temp = null;
        double max = 0;
        for (Personaje p : personajes) {
            double daño = p.getTipoHabilidad().calcularDaño(p.getDaño());
            if (daño > max) {
                temp = p;
                max = daño;
            }
        }
        return temp;
    }

    public void imprimirInfo(Personaje p) {
        System.out.println(p.getNombre() + " tiene como daño " + p.getDaño());
        if (p.getTipoHabilidad().getClass() == HabilidadMagica.class) {
            System.out.println("Habilidad tipo habilidad mágica");
            System.out.println("Esta habilidad dobla tu fuerza");
        } else {
            System.out.println("Habilidad tipo habilidad Cuerpo a cuerpo");
            System.out.println("Este habilidad mantiene tu fuerza");
        }
    }
}