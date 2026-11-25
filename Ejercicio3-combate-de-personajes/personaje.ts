export abstract class Personaje 
{

    public combatir(): void //Este método no se debe sobreescribir para cumplir con el Template Method, es el esqueleto.
    {
        this.prepararAtaque();
        this.prepararEquipamiento();
        this.prepararseParaCombatir();
        this.atacar();
        this.evaluarResultado();
        this.recuperarEnergia();
    }

    protected abstract prepararAtaque(): void;

    protected abstract prepararEquipamiento(): void;

    protected abstract prepararseParaCombatir(): void;

    protected abstract atacar(): void;

    protected evaluarResultado(): void //Comportamiento en común entre las subclases, no es un hook.
    {
        console.log("Evaluando el resultado del combate.");
    }

    protected recuperarEnergia(): void //Hook, puede sobreescribirse o no. Depende de la clase hija.
    { 
        console.log("Recuperando energía."); 
    } 
}