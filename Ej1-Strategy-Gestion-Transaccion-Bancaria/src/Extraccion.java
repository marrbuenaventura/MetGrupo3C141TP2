public class Extraccion implements OperacionBancaria {
    private final Cuenta cuenta;
    private final double importe;

    public Extraccion(Cuenta cuenta, double importe) {
        this.cuenta = cuenta;
        this.importe = importe;
    }

    @Override
    public void ejecutar() {
        if (cuenta.getSaldo() < importe) {
            throw new IllegalStateException("Saldo insuficiente en la cuenta de " + cuenta.getTitular());
        }
        if (importe <= 0) {
            throw new IllegalArgumentException("El importe a extraer debe ser mayor a 0");
        }
        cuenta.debitar(importe);
        System.out.println("Extracción exitosa de $" + importe + " de " + cuenta.getTitular());
    }
}