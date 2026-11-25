package gremios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Subsistema: guarda los héroes reclutados. */
public class RepositorioHeroes {
    private final List<Heroe> heroes = new ArrayList<>();

    public void agregar(Heroe heroe) { heroes.add(heroe); }

    public List<Heroe> obtenerTodos() { return Collections.unmodifiableList(heroes); }

    public List<Guerrero> obtenerGuerreros() {
        List<Guerrero> guerreros = new ArrayList<>();
        for (Heroe h : heroes) {
            if (h instanceof Guerrero) guerreros.add((Guerrero) h);
        }
        return guerreros;
    }
}
