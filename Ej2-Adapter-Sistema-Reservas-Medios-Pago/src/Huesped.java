public class Huesped {
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String numeroTarjeta;

    public Huesped(String nombre, String apellido, String email, String numeroTarjeta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombre()        { return nombre; }
    public String getApellido()      { return apellido; }
    public String getEmail()         { return email; }
    public String getNumeroTarjeta() { return numeroTarjeta; }
}