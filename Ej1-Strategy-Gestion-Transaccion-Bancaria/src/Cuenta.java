public class Cuenta {
    private final String titular;
    private double saldo;

    public Cuenta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() { return titular; }
    public double getSaldo()   { return saldo; }

    public void acreditar(double importe) { saldo += importe; }
    public void debitar(double importe)   { saldo -= importe; }

    @Override
    public String toString() {
        return titular + ": $" + saldo;
    }
}