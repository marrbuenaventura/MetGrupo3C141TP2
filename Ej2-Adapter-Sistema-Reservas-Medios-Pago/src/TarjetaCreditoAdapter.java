public class TarjetaCreditoAdapter implements MedioDePago {
    private final TarjetaCredito tarjeta;
    private final Huesped huesped;

    public TarjetaCreditoAdapter(TarjetaCredito tarjeta, Huesped huesped) {
        this.tarjeta = tarjeta;
        this.huesped = huesped;
    }

    @Override
    public void pagar(double monto) {
        String numero = huesped.getNumeroTarjeta();

        if (!tarjeta.validarLimite(numero, monto)) {
            throw new IllegalStateException("Límite insuficiente en la tarjeta");
        }
        tarjeta.autorizarCargo(numero, monto);
    }
}