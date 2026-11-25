import { Personaje } from './personaje.ts';

export class Mago extends Personaje 
{

    protected override prepararAtaque(): void 
    {
        console.log("Seleccionando un hechizo.");
    }

    protected override prepararEquipamiento(): void 
    {
        console.log("Preparando el bastón.");
    }

    protected override prepararseParaCombatir(): void 
    {
        console.log("Concentrando energía mágica.");
    }

    protected override atacar(): void 
    {
        console.log("Ejecutando un ataque mágico.");
    }

    protected override recuperarEnergia(): void 
    {
        console.log("Recuperando maná.");
    }
}