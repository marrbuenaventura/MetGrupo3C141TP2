public class BilleteraVirtualAdapter implements MedioDePago {
    private final BilleteraVirtual billetera;
    private final Huesped huesped;

    public BilleteraVirtualAdapter(BilleteraVirtual billetera, Huesped huesped) {
        this.billetera = billetera;
        this.huesped = huesped;
    }

    @Override
    public void pagar(double monto) {
        billetera.pagar(huesped.getEmail(), monto);
    }
}