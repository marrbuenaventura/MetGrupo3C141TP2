package gremios;

/** ConcreteCreator: sabe cómo construir un Mago. */
public class MagoFactory extends HeroeFactory<DatosMago> {
    @Override
    public Heroe crearHeroe(DatosMago d) {
        return new Mago(d.getNombre(), d.getApodo(), d.getFechaCreacion(), d.getReservaMana());
    }
}
