public class Deposito implements OperacionBancaria {
    private final Cuenta cuenta;
    private final double importe;

    public Deposito(Cuenta cuenta, double importe) {
        this.cuenta = cuenta;
        this.importe = importe;
    }

    @Override
    public void ejecutar() {
        if (importe <= 0) {
            throw new IllegalArgumentException("El importe a depositar debe ser mayor a 0");
        }
        cuenta.acreditar(importe);
        System.out.println("Depósito exitoso de $" + importe + " en " + cuenta.getTitular());
    }
}