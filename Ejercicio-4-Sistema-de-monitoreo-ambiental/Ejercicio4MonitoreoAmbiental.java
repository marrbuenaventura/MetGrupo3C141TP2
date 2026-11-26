import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Contrato del objeto que publica los cambios de estado.
interface Sujeto {
    void suscribir(ObservadorSensor observador);
    void desuscribir(ObservadorSensor observador);
    void notificarObservadores();
}

// Contrato común para todos los paneles que reciben actualizaciones.
interface ObservadorSensor {
    void actualizar(String tipoSensor, double valor);
}

// Sujeto concreto base: cada sensor administra sus propios suscriptores.
abstract class Sensor implements Sujeto {
    private final String tipo;
    private double valor;
    private final List<ObservadorSensor> observadores;

    protected Sensor(String tipo) {
        this.tipo = tipo;
        this.observadores = new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public void suscribir(ObservadorSensor observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void desuscribir(ObservadorSensor observador) {
        observadores.remove(observador);
    }

    // Se invoca cuando el sensor recibe una nueva medición.
    public void actualizarValor(double nuevoValor) {
        this.valor = nuevoValor;
        notificarObservadores();
    }

    @Override
    public void notificarObservadores() {
        // Se recorre una copia para tolerar cambios de suscripción durante la notificación.
        List<ObservadorSensor> copiaObservadores = new ArrayList<>(observadores);
        for (ObservadorSensor observador : copiaObservadores) {
            observador.actualizar(tipo, valor);
        }
    }
}

// Sensores concretos: cada uno identifica el tipo de variable que mide.
class TemperaturaSensor extends Sensor {
    public TemperaturaSensor() {
        super("Temperatura");
    }
}

class HumedadSensor extends Sensor {
    public HumedadSensor() {
        super("Humedad");
    }
}

class CO2Sensor extends Sensor {
    public CO2Sensor() {
        super("CO2");
    }
}

class LuminosidadSensor extends Sensor {
    public LuminosidadSensor() {
        super("Luminosidad");
    }
}

// Observador concreto: presenta cualquier medición recibida.
class PanelPrincipal implements ObservadorSensor {
    @Override
    public void actualizar(String tipoSensor, double valor) {
        System.out.println("[PANEL PRINCIPAL] " + tipoSensor + ": " + valor);
    }
}

// Observador concreto: compara las mediciones con umbrales configurables.
class PanelAlertas implements ObservadorSensor {
    private final Map<String, Double> umbrales;

    public PanelAlertas() {
        this.umbrales = new HashMap<>();
    }

    public void configurarUmbral(String tipoSensor, double umbral) {
        umbrales.put(tipoSensor, umbral);
    }

    @Override
    public void actualizar(String tipoSensor, double valor) {
        Double umbral = umbrales.get(tipoSensor);
        if (umbral != null && valor > umbral) {
            System.out.println("[ALERTA] " + tipoSensor + " superó el umbral: " + valor
                    + " (umbral: " + umbral + ")");
        }
    }
}

// Observador concreto: registra cada cambio recibido.
class RegistroConsola implements ObservadorSensor {
    @Override
    public void actualizar(String tipoSensor, double valor) {
        System.out.println("[REGISTRO] Se actualizó " + tipoSensor + ": " + valor);
    }
}

public class Ejercicio4MonitoreoAmbiental {
    public static void main(String[] args) {
        // Creación de sensores.
        Sensor temperatura = new TemperaturaSensor();
        Sensor humedad = new HumedadSensor();
        Sensor co2 = new CO2Sensor();
        Sensor luminosidad = new LuminosidadSensor();

        // Creación de las vistas que reciben las notificaciones.
        ObservadorSensor panelPrincipal = new PanelPrincipal();
        PanelAlertas panelAlertas = new PanelAlertas();
        ObservadorSensor registro = new RegistroConsola();

        // Umbrales de ejemplo configurables (la consigna no fija valores concretos).
        panelAlertas.configurarUmbral("Temperatura", 30.0);
        panelAlertas.configurarUmbral("Humedad", 70.0);
        panelAlertas.configurarUmbral("CO2", 1000.0);
        panelAlertas.configurarUmbral("Luminosidad", 800.0);

        // Suscripción inicial: los tres paneles reciben cambios de cada sensor.
        Sensor[] sensores = { temperatura, humedad, co2, luminosidad };
        for (Sensor sensor : sensores) {
            sensor.suscribir(panelPrincipal);
            sensor.suscribir(panelAlertas);
            sensor.suscribir(registro);
        }

        // Nuevas mediciones: cada sensor notifica a sus observadores.
        temperatura.actualizarValor(32.5);
        humedad.actualizarValor(55.0);
        co2.actualizarValor(1200.0);
        luminosidad.actualizarValor(650.0);

        // El usuario desactiva el registro para el sensor de humedad.
        humedad.desuscribir(registro);
        System.out.println("\n-- El registro se desactivó para el sensor de humedad --");
        humedad.actualizarValor(72.0); // El registro ya no recibe esta actualización.

        // El usuario vuelve a activar el registro para ese sensor.
        humedad.suscribir(registro);
        System.out.println("\n-- El registro se volvió a activar para el sensor de humedad --");
        humedad.actualizarValor(68.0);
    }
}
