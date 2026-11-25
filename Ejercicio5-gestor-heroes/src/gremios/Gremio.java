package gremios;

/** Cliente: solo conoce al gestor (la fachada) y a los datos que él mismo aporta. */
public class Gremio {
    private final String nombre;
    private final GestorDeHeroes gestor = GestorDeHeroes.getInstance();

    public Gremio(String nombre) { this.nombre = nombre; }

    public String getNombre() { return nombre; }
    public GestorDeHeroes getGestor() { return gestor; }

    public void reclutarGuerrero(DatosGuerrero datos) {
        Heroe h = gestor.reclutarGuerrero(datos);
        System.out.println("[" + nombre + "] reclutó a " + h.getNombre());
    }

    public void reclutarMago(DatosMago datos) {
        Heroe h = gestor.reclutarMago(datos);
        System.out.println("[" + nombre + "] reclutó a " + h.getNombre());
    }

    public void consultarMejorGuerrero() {
        System.out.println("[" + nombre + "] mejor guerrero: "
                + gestor.consultarMejorGuerrero().map(Heroe::getNombre).orElse("ninguno"));
    }

    public void pedirReporte() {
        System.out.println(gestor.generarReporteBatalla());
    }
}
