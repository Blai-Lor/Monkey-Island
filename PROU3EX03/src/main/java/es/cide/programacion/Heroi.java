package es.cide.programacion;

import java.util.Scanner;

public class Heroi {
    Scanner sc = new Scanner(System.in);
    
    //ATRIBUTOS
    String nombreHeroe;
    int vidaHeroe = 10;
    boolean vida = true; //Este boolean es que esta vivo por eso esta en true
    
    String[] respuestaHeroe = { //String de las respuestas para defenderse de los insultos del pirata
        "¡He venido a saquear tu tesoro!", //¡Mejor que te vayas antes de que te hagas daño!
        "Con tu aliento, seguro que todos fueron asfixiados.", //Los enemigos contra los que me enfrenté fueron aniquilados.
        "Tu solo olor me deja enfadado, agitado y enojado.", //Te dejaré devastado, mutilado y perforado.
        "¿Es que tanto me parezco a tu hermana?", //Eres tan repulsivo como una mona marrana
        "Así habría sido, pero siempre estabas de escapada.", //Jamás había visto a nadie tan torpe con la espada
        "Al menos el mio puede ser identificado.", //Cuando tu padre te vio por primera vez debió sentirse mortificado.
        "Entonces se un buen perro ¡Siéntate! ¡Quieto!", //¡Te perseguiré dia y noche sin ningún respeto!
    };

    //CONSTRUCTOR
    public Heroi(String nombreHeroe, int vidaHeroe) { 
        this.nombreHeroe = nombreHeroe; //Guardamos el nombre del heroe
        this.vidaHeroe = vidaHeroe; //Guardamos la vida del heroe
    }

    //GETTER Y SETTER
    public String getNomheroe() { //Muestra el nombre del Heroe
        return this.nombreHeroe;
    }

    public int getVidaheroe() { //Muestra la vida del Heroe
        return this.vidaHeroe;
    }

    //METODO
    public String defensar() { //Metodo de defensar y en los que aparecen las respuestas
        System.out.println("1. " + respuestaHeroe[0]);
        System.out.println("2. " + respuestaHeroe[1]);
        System.out.println("3. " + respuestaHeroe[2]);
        System.out.println("4. " + respuestaHeroe[3]);
        System.out.println("5. " + respuestaHeroe[4]);
        System.out.println("6. " + respuestaHeroe[5]);
        System.out.println("7. " + respuestaHeroe[6]);
        System.out.println("Tu respuesta es: ");
        int eleccion = sc.nextInt(); //La eleccion de la respuesta
        return respuestaHeroe[eleccion - 1]; //Es -1 porque al seleccionar por ejemplo la respuesta 2 en el array es la 1
    }

    public int vidaHeroe() { //Metodo de la vida del Heroe
        this.vidaHeroe = vidaHeroe - 1; //Quita 1 de vida al Heroe
        if (vidaHeroe != 0) { //Aqui indica que si la vida del heroe es diferente a 0 indica que sigue vivo
            System.out.println("Estas con vida");
        } else if (vidaHeroe == 0) { //Aqui indica que si la vida del heroe es igual a 0 indica que ha muerto
            System.out.println("Has muerto");
            vida = false; 
        }
        return vidaHeroe;
    }
}
