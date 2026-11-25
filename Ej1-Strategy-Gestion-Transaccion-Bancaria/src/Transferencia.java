public class Transferencia implements OperacionBancaria {
    private final Cuenta origen;
    private final Cuenta destino;
    private final double importe;

    public Transferencia(Cuenta origen, Cuenta destino, double importe) {
        this.origen = origen;
        this.destino = destino;
        this.importe = importe;
    }

    @Override
    public void ejecutar() {
        if (origen.getSaldo() < importe) {
            throw new IllegalStateException("Saldo insuficiente en la cuenta de origen");
        }
        if (importe <= 0) {
            throw new IllegalArgumentException("El importe a transferir debe ser mayor a 0");
        }
        origen.debitar(importe);

        destino.acreditar(importe);
        System.out.println("Transferencia exitosa de $" + importe
                + " de " + origen.getTitular() + " a " + destino.getTitular());
    }
}