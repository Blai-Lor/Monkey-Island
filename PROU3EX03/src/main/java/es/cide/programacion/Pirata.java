package es.cide.programacion;

import java.util.Random;

public class Pirata {
    Random random = new Random();
    
    //ATRIBUTOS
    String nombrePirata; 
    int vidaPirata; 
    boolean vivo = true; //Este boolean es que esta vivo
    int insultoAleatorio, insultoAleatorio1, insultoAleatorio2; //int de las 3 variables que guardan los aleatorios de los insultos seleccionados
    String[] insultoRandom = new String[3]; //Array de 3 que guarda los 3 insultos de un pirata en concreto
    int posicionInsulto; //Es la posicion original del insulto del pirata
    String[] respuestaHeroe = { //String de las respuestas para defenderse de los insultos del pirata
        "¡He venido a saquear tu tesoro!", //¡Mejor que te vayas antes de que te hagas daño!
        "Con tu aliento, seguro que todos fueron asfixiados.", //Los enemigos contra los que me enfrenté fueron aniquilados.
        "Tu solo olor me deja enfadado, agitado y enojado.", //Te dejaré devastado, mutilado y perforado.
        "¿Es que tanto me parezco a tu hermana?", //Eres tan repulsivo como una mona marrana
        "Así habría sido, pero siempre estabas de escapada.", //Jamás había visto a nadie tan torpe con la espada
        "Al menos el mio puede ser identificado.", //Cuando tu padre te vio por primera vez debió sentirse mortificado.
        "Entonces se un buen perro ¡Siéntate! ¡Quieto!", //¡Te perseguiré dia y noche sin ningún respeto!
    };

    private String[] insultoPirata = { //String del insulto de los piratas
        "¡Mejor que te vayas antes de que te hagas daño!", 
        "Los enemigos contra los que me enfrenté fueron aniquilados.",
        "Te dejaré devastado, mutilado y perforado.",
        "Eres tan repulsivo como una mona marrana.",
        "Jamás había visto a nadie tan torpe con la espada.",
        "Cuando tu padre te vio por primera vez debió sentirse mortificado.",
        "¡Te perseguiré dia y noche sin ningún respeto!"
    }; 

    //CONSTRUCTOR
    public Pirata(String nombrePirata, int vidaPirata) {
        this.nombrePirata = nombrePirata; 
        this.vidaPirata = vidaPirata;

        do { //Este bucle hace 3 numeros diferentes
            insultoAleatorio = random.nextInt(7); //Número aleatorio entre 0 y 6 para el primer insulto
            insultoAleatorio1 = random.nextInt(7); //Número aleatorio entre 0 y 6 para el segundo insulto
            insultoAleatorio2 = random.nextInt(7); //Número aleatorio entre 0 y 6 para el tercer insulto
        } 
        while (this.insultoAleatorio == this.insultoAleatorio1 || this.insultoAleatorio == this.insultoAleatorio2 
        || this.insultoAleatorio1 == this.insultoAleatorio2); //El while esta para que no haya insultos repetidos 
        
        insultoRandom[0] = insultoPirata[insultoAleatorio]; //Se guarda el primer insulto del array 
        insultoRandom[1] = insultoPirata[insultoAleatorio1]; //Se guarda el segundo insulto del array
        insultoRandom[2] = insultoPirata[insultoAleatorio2]; //Se guarda en el tercer insulto del array
    }
    
    //GETTER Y SETTER
    public String getNompirata() { //Muestra el nombre del Pirata
        return this.nombrePirata;
    }

    public int getVidapirata() { //Muestra la vida del Pirata
        return this.vidaPirata;
    }

    //METODO
    String insultar() { //Este es el metodo de insultar
        int losInsultos = random.nextInt(3); //Hace un número aleatorio entre 0 y 2 para elegir uno de los 3 insultos del pirata
        
        if (insultoRandom[losInsultos] == insultoPirata[insultoAleatorio]) { //El if guarda la posicion original del insulto para usar en replica
            posicionInsulto = insultoAleatorio; //Se guarda la posición original del primer insulto
        } else if (insultoRandom[losInsultos] == insultoPirata[insultoAleatorio1]) {
            posicionInsulto = insultoAleatorio1; //Se guarda la posición original del segundo insulto
        } else if (insultoRandom[losInsultos] == insultoPirata[insultoAleatorio2]) {
            posicionInsulto = insultoAleatorio2; //Se guarda la posición original del tercer insulto
        }
        
        String ataque = insultoRandom[losInsultos]; //Devuelve el insulto aleatorio
        return ataque;
    }
    
    public boolean replica(String def) { //Metodo para comprobar si la respuesta es la correcta
        return def.equals(respuestaHeroe[posicionInsulto]); //La defensa del heroe es igual a la posicion original de la respuesta
    }
    
    public int vida() {
        this.vidaPirata = vidaPirata - 1; //Quita 1 de vida al Pirata
        if (vidaPirata != 0) { //Si la vida del pirata es diferente a 0 es que sigue vivo
            System.out.println("Vida del pirata: " + vidaPirata);
        } else if (vidaPirata == 0) { //Si la vida del pirata es 0 muestra este mensaje
            vivo = false;
        }
        return vidaPirata;
    }
}
