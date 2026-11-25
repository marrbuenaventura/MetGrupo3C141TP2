package gremios;

import java.util.Comparator;
import java.util.Optional;

/**
 * Singleton + Facade.
 *  - Singleton: una única instancia compartida por todos los gremios.
 *  - Facade: interfaz simple que coordina fábricas, repositorio y generador de reportes.
 */
public class GestorDeHeroes {

    // Singleton: instancia única creada al cargar la clase (segura ante hilos).
    private static final GestorDeHeroes INSTANCIA = new GestorDeHeroes();

    // Subsistema que el gremio no necesita conocer.
    private final HeroeFactory<DatosGuerrero> fabricaGuerreros = new GuerreroFactory();
    private final HeroeFactory<DatosMago> fabricaMagos = new MagoFactory();
    private final RepositorioHeroes repositorio = new RepositorioHeroes();
    private final GeneradorReporteBatalla generadorReporte = new GeneradorReporteBatalla();

    // Constructor privado: nadie fuera de la clase puede hacer "new GestorDeHeroes()".
    private GestorDeHeroes() { }

    public static GestorDeHeroes getInstance() { return INSTANCIA; }

    // ---- Operaciones de la fachada ----

    public Heroe reclutarGuerrero(DatosGuerrero datos) {
        return reclutar(fabricaGuerreros, datos);
    }

    public Heroe reclutarMago(DatosMago datos) {
        return reclutar(fabricaMagos, datos);
    }

    /** Extensión sin modificar nada: sirve para cualquier tipo nuevo (p. ej. Arquero) con su fábrica. */
    public <D extends DatosHeroe> Heroe reclutar(HeroeFactory<D> fabrica, D datos) {
        Heroe heroe = fabrica.crearHeroe(datos);
        repositorio.agregar(heroe);
        return heroe;
    }

    public Optional<Guerrero> consultarMejorGuerrero() {
        return repositorio.obtenerGuerreros().stream()
                .max(Comparator.comparingDouble(Guerrero::calcularPoderTotal));
    }

    public String generarReporteBatalla() {
        return generadorReporte.generar(repositorio.obtenerTodos(),
                consultarMejorGuerrero().orElse(null));
    }
}
