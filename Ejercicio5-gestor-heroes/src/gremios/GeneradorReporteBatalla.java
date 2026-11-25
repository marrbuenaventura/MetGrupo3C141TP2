package gremios;

import java.util.List;

/** Subsistema: arma el reporte de batalla a partir de los héroes disponibles. */
public class GeneradorReporteBatalla {
    public String generar(List<Heroe> heroes, Guerrero mejorGuerrero) {
        StringBuilder sb = new StringBuilder("=== REPORTE DE BATALLA ===\n");
        if (heroes.isEmpty()) {
            return sb.append("No hay héroes reclutados.\n").toString();
        }
        sb.append("Héroes reclutados: ").append(heroes.size()).append("\n");
        for (Heroe h : heroes) {
            sb.append(" - ").append(h).append("\n");
        }
        if (mejorGuerrero != null) {
            sb.append("Mejor guerrero: ").append(mejorGuerrero.getNombre())
              .append(" (poder total ").append(mejorGuerrero.calcularPoderTotal()).append(")\n");
        }
        return sb.toString();
    }
}
