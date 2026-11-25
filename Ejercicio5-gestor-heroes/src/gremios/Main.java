package gremios;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Gremio gremioA = new Gremio("Gremio del Norte");
        Gremio gremioB = new Gremio("Gremio del Sur");

        // Singleton: ambos gremios comparten exactamente el mismo gestor.
        System.out.println("¿Mismo gestor? " + (gremioA.getGestor() == gremioB.getGestor()));

        gremioA.reclutarGuerrero(new DatosGuerrero("Conan", "El Bárbaro", LocalDate.of(2026, 1, 10), 80, 5, 4));
        gremioB.reclutarGuerrero(new DatosGuerrero("Aragorn", "Trancos", LocalDate.of(2026, 2, 3), 70, 12, 3));
        gremioA.reclutarMago(new DatosMago("Gandalf", "El Gris", LocalDate.of(2026, 3, 15), 500));

        gremioB.consultarMejorGuerrero();
        gremioA.pedirReporte(); // ve a los héroes que reclutó el otro gremio: estado compartido
    }
}
