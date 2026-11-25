//Los métodos abstractos se implementan en las clases concretas con override. Protected permite que las clase abstracta y sus 
//subclases puedan acceder a los métodos pero las externas no. combatir() se permite porque es el esqueleto, es un método público.

import { Guerrero } from './guerrero.ts';
import { Mago } from './mago.ts';

const guerrero = new Guerrero();
const mago = new Mago();

console.log("Combate del Guerrero:");
guerrero.combatir();

console.log("\nCombate del Mago:");
mago.combatir();