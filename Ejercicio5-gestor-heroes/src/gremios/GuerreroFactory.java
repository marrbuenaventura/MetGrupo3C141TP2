package gremios;

/** ConcreteCreator: sabe cómo construir un Guerrero. */
public class GuerreroFactory extends HeroeFactory<DatosGuerrero> {
    @Override
    public Heroe crearHeroe(DatosGuerrero d) {
        return new Guerrero(d.getNombre(), d.getApodo(), d.getFechaCreacion(),
                d.getPoderAtaque(), d.getVictorias(), d.getBonoPorVictoria());
    }
}
