public class Transaccion {
    private OperacionBancaria operacion;

    public void setOperacion(OperacionBancaria operacion) {
        this.operacion = operacion;
    }

    public void confirmar() {
        if (operacion == null) {
            throw new IllegalStateException("Debe seleccionar una operación antes de confirmar");
        }
        operacion.ejecutar();
    }
}