public class TarjetaCredito {
    private final double limiteDisponible;

    public TarjetaCredito(double limiteDisponible) {
        this.limiteDisponible = limiteDisponible;
    }

    public boolean validarLimite(String numeroTarjeta, double monto) {
        return monto <= limiteDisponible;
    }

    public void autorizarCargo(String numeroTarjeta, double monto) {
        System.out.println("Cargo de $" + monto + " autorizado en la tarjeta " + numeroTarjeta);
    }
}