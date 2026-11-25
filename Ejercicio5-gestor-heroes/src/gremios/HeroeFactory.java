package gremios;

/**
 * Creator del Factory Method.
 * Declara el método fábrica crearHeroe(); cada subclase decide qué clase concreta instanciar.
 * Quien lo usa depende solo de Heroe y de esta abstracción, nunca de Guerrero o Mago.
 */
public abstract class HeroeFactory<D extends DatosHeroe> {
    public abstract Heroe crearHeroe(D datos);
}
