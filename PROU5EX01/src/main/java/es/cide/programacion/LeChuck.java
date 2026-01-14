//Nombre: Blai Lorente Fuster
//DNI: 43482846N
//Fecha: 09/12/2025
package es.cide.programacion;

import java.util.Random;

public class LeChuck extends Pirata implements Fight, Speak {
    Random random = new Random();
    
    //ATRIBUTOS
    String nom; //String del nombre de LeChuck
    int asalto1, asalto2, asalto3;
    String insultoLeChuk = "¡Me das ganas de vomitar!"; //Insulto unico de LeChuck
    String respuestaLeChuk = "Me haces pensar que alguien ya lo ha hecho."; //Respuesta unica de LeChuck
    String[] batallaLeChuck = new String[4]; //Array con 4 insultos, 3 del pirata y el de LeChuck

    //CONSTRUCTOR
    public LeChuck(String nom, int vida, boolean vivo){
        super(nom, vida, vivo);
        this.nom = "LeChuck"; 
        this.vida = vida * 2; //La vida de LeChuck es el doble
        this.vivo = vivo; 
    
    asalto1 = random.nextInt(7); //Numero aleatorio entre 0 y 6
    asalto2 = random.nextInt(7); //Numero aleatorio entre 0 y 6
    while (asalto1 == asalto2) { //Para que el segundo no sea igual al primero
        asalto2 = random.nextInt(7);
    }
    asalto3 = random.nextInt(7); //Numero aleatorio entre 0 y 6
    while (asalto1 == asalto3 || asalto2 == asalto3) { //Para que el tercero no sea igual al primero ni al segundo
        asalto3 = random.nextInt(7); //Numero aleatorio entre 0 y 6
    }
    
    this.batallaLeChuck[0] = insultoPirata[asalto1]; //Guarda el primer insulto del array
    this.batallaLeChuck[1] = insultoPirata[asalto2]; //Guarda el segundo insulto del array
    this.batallaLeChuck[2] = insultoPirata[asalto3]; //Guarda el tercer insulto del array
    this.batallaLeChuck[3] = insultoLeChuk; //Guarda el insulto unico de LeChuck
    }
    
    //GETTER Y SETTER

    //METODOS
    @Override
    public void insultar(){
        int eleccion = random.nextInt(4); //Hace un numero aleatorio entre 0 y 2 para elegir uno de los 3 insultos del pirata
        
        if (batallaLeChuck[eleccion] == insultoPirata[asalto1]) { //Si el insulto es el mismo que el del asalto1, lo guarda en posicionInsulto
            posicionInsulto = asalto1;
        } else if (batallaLeChuck[eleccion] == insultoPirata[asalto2]) { //Si el insulto es el mismo que el del asalto2, lo guarda en posicionInsulto
            posicionInsulto = asalto2; 
        } else if (batallaLeChuck[eleccion] == insultoPirata[asalto3]) { //Si el insulto es el mismo que el del asalto3, lo guarda en posicionInsulto
            posicionInsulto = asalto3; 
        } else {
            posicionInsulto = 7; //Este es para el insulto de LeChuck
        }

        String combate = batallaLeChuck[eleccion]; //Guarda el insulto que dira
        System.out.println(nom + ": " + combate); 
    }

    public boolean replica(String def) { //Metodo para comprobar si la respuesta es la correcta
        if (posicionInsulto == 7) { //Si el insulto es 7 aparece el insulto de LeChuck
            return def.equals(respuestaLeChuk); //Aparece la respuesta de LeChuck
        }
        return def.equals(respuestaHeroe[posicionInsulto]); //La defensa del heroe es igual a la posicion original de la respuesta
    }

    @Override
    public void sayHello(){ //La presentacion de LeChuck
        System.out.println("LeChuck: Te enfrentaras al famoso y guapo LeChuck, tienes las suficientes pelotillas de batallar.");
    }

    @Override
    public void sayGoodBye(){ //La despedida de LeChuck
        System.out.println("LeChuck: Como has podido ganarme, pirata noseras una futura leyenda.");
    }

    String[] respuestaHeroe = { //String de las respuestas para defenderse de los insultos del pirata
        "¡He venido a saquear tu tesoro!", //¡Mejor que te vayas antes de que te hagas daño!
        "Con tu aliento, seguro que todos fueron asfixiados.", //Los enemigos contra los que me enfrenté fueron aniquilados.
        "Tu solo olor me deja enfadado, agitado y enojado.", //Te dejaré devastado, mutilado y perforado.
        "¿Es que tanto me parezco a tu hermana?", //Eres tan repulsivo como una mona marrana
        "Así habría sido, pero siempre estabas de escapada.", //Jamás había visto a nadie tan torpe con la espada
        "Al menos el mio puede ser identificado.", //Cuando tu padre te vio por primera vez debió sentirse mortificado.
        "Entonces se un buen perro ¡Siéntate! ¡Quieto!", //¡Te perseguiré dia y noche sin ningún respeto!
        "Me haces pensar que alguien ya lo ha hecho."
    };

    private String[] insultoPirata = { //String del insulto de los piratas
        "¡Mejor que te vayas antes de que te hagas daño!", 
        "Los enemigos contra los que me enfrenté fueron aniquilados.",
        "Te dejaré devastado, mutilado y perforado.",
        "Eres tan repulsivo como una mona marrana.",
        "Jamás había visto a nadie tan torpe con la espada.",
        "Cuando tu padre te vio por primera vez debió sentirse mortificado.",
        "¡Te perseguiré dia y noche sin ningún respeto!",
        "Me haces pensar que alguien ya lo ha hecho."
    };
}