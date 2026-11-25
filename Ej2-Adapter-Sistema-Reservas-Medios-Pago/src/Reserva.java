public class Reserva {
    private final Huesped huesped;
    private final double montoTotal;

    public Reserva(Huesped huesped, double montoTotal) {
        this.huesped = huesped;
        this.montoTotal = montoTotal;
    }

    public Huesped getHuesped()  { return huesped; }
    public double getMontoTotal() { return montoTotal; }

    public void pagarCon(MedioDePago medio) {
        medio.pagar(montoTotal);
    }
}