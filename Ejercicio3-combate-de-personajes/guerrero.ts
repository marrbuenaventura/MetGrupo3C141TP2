import { Personaje } from './personaje.ts';

export class Guerrero extends Personaje 
{

    protected override prepararAtaque(): void 
    {
        console.log("Preparando el arma.");
    }

    protected override prepararEquipamiento(): void 
    {
        console.log("Equipando la armadura.");
    }

    protected override prepararseParaCombatir(): void 
    {
        console.log("Acercándose al enemigo.");
    }

    protected override atacar(): void 
    {
        console.log("Ejecutando un ataque físico.");
    }
}