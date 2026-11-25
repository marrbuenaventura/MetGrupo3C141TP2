public class Main {
    public static void main(String[] args) {
        Cuenta ana  = new Cuenta("Ana", 1000);
        Cuenta luis = new Cuenta("Luis", 500);

        Transaccion transaccion = new Transaccion();

        // elige deposito
        transaccion.setOperacion(new Deposito(ana, 200));
        // cambia de opinion y elige extracción (antes de confirmar)
        transaccion.setOperacion(new Extraccion(ana, 300));
        transaccion.confirmar();   // ejecuta la extracción

        // ejecuta transferencia
        transaccion.setOperacion(new Transferencia(ana, luis, 400));
        transaccion.confirmar();

        // error: saldo insuficiente
        try {
            transaccion.setOperacion(new Extraccion(ana, 99999));
            transaccion.confirmar();
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(ana);
        System.out.println(luis);
    }
}