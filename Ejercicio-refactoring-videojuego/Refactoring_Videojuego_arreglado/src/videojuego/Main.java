package videojuego;

// Main.java
public class Main {
    public static void main(String[] args) {
        Videojuego juego = new Videojuego();
        Personaje mago = new Personaje("Merlin", 50, new HabilidadMagica());
        Personaje guerrero = new Personaje("Conan", 80, new HabilidadCuerpoACuerpo());
        juego.agregar(mago);
        juego.agregar(guerrero);

        juego.imprimirInfo(mago);
        juego.imprimirInfo(guerrero);
        System.out.println("Mas daño: " + juego.personajeConMasDaño().getNombre());
    }
}