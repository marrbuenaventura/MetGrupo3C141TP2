public class Main {
    public static void main(String[] args) {
        Huesped huesped = new Huesped("Ana", "Pérez", "ana@mail.com", "4111-1111-1111-1111");
        Reserva reserva = new Reserva(huesped, 15000);

        // pago con tarjeta
        MedioDePago tarjeta = new TarjetaCreditoAdapter(new TarjetaCredito(20000), huesped);
        reserva.pagarCon(tarjeta);

        // pago con billetera virtual
        MedioDePago billetera = new BilleteraVirtualAdapter(new BilleteraVirtual(), huesped);
        reserva.pagarCon(billetera);

        // error: límite insuficiente
        try {
            MedioDePago tarjetaChica = new TarjetaCreditoAdapter(new TarjetaCredito(5000), huesped);
            reserva.pagarCon(tarjetaChica);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}