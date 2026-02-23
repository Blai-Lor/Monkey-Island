package es.cide.programacion;

import java.util.Random;

public class Pirata extends Personatge implements Fight, Speak {
    Random random = new Random();
    
    //ATRIBUTOS 
    boolean vivo = true; //Este boolean es que esta vivo
    String[] insultoRandom = new String[3]; //Array de 3 que guarda los 3 insultos de un pirata en concreto
    String[] respuestaCorrecta = new String[7];
    int asalto1, asalto2, asalto3;
    String[] asalto = new String[7];
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
    public Pirata(String nom, int vida, boolean vivo) { 
        super(nom, vida);
        this.nom = nom;
        this.vida = vida;
        this.vivo = vivo;

        asalto1 = random.nextInt(insultoPirata.length); //Numero aleatorio entre 0 y 6
        asalto2 = random.nextInt(insultoPirata.length); //Numero aleatorio entre 0 y 6
        while (asalto2 == asalto1) { //Para que el segundo no sea igual al primero
            asalto2 = random.nextInt(insultoPirata.length); //Numero aleatorio entre 0 y 6
        }
        
        asalto3 = random.nextInt(insultoPirata.length); //Numero aleatorio entre 0 y 6
        while (asalto3 == asalto1 || asalto3 == asalto2) { //Para que el tercero no sea igual al primero ni al segundo
            asalto3 = random.nextInt(insultoPirata.length); //Numero aleatorio entre 0 y 6
        }

        this.insultoRandom[0] = insultoPirata[asalto1]; //Guarda el primer insulto del array
        this.insultoRandom[1] = insultoPirata[asalto2]; //Guarda el segundo insulto del array
        this.insultoRandom[2] = insultoPirata[asalto3]; //Guarda el tercer insulto del array
    }

    @Override
    public void insultar() { //Este es el metodo de insultar
        int eleccion = random.nextInt(3); //Hace un numero aleatorio entre 0 y 2 para elegir uno de los 3 insultos del pirata
        
        if (insultoRandom[eleccion] == insultoPirata[asalto1]) { //Si el insulto es el mismo que el del asalto1, lo guarda en posicionInsulto
            posicionInsulto = asalto1; 
        } else if (insultoRandom[eleccion] == insultoPirata[asalto2]) { //Si el insulto es el mismo que el del asalto2, lo guarda en posicionInsulto
            posicionInsulto = asalto2; 
        } else if (insultoRandom[eleccion] == insultoPirata[asalto3]) { //Si el insulto es el mismo que el del asalto3, lo guarda en posicionInsulto
            posicionInsulto = asalto3; 
        }
        String combate = insultoRandom[eleccion]; //Guarda el insulto que dira
        System.out.println(nom + ": " + combate);
    }

    public boolean replica(String def) { //Metodo para comprobar si la respuesta es la correcta
        return def.equals(respuestaHeroe[posicionInsulto]); //La defensa del heroe es igual a la posicion original de la respuesta
    }

    
    //GETTER Y SETTER
    public String getNomPirata() { //Muestra el nombre del Pirata
        return this.nom;
    }

    //METODO 
    public boolean getVida() { //Metodo de la vida
        this.vida = this.vida - 1; //Quita 1 de vida al Pirata
        if (vida > 0) { //Si la vida del pirata es mayor a 0 es que sigue vivo
            System.out.println("Vida del pirata: " + vida);
            vivo = true;
        } else if (vida == 0) { //Si la vida del pirata es 0 muestra este mensaje
            System.out.println("El pirata a muerto.");
            vivo = false;
        }
        return this.vivo;
    }

    public boolean vida() {
        return vivo;
    }
    
    @Override
    public void sayHello(){ //La presentacion del Pirata
        System.out.println("Que haces entrando a esta isla pestoso.");
    }

    @Override
    public void sayGoodBye(){ //La despedida de Pirata
        System.out.println("Al final el pestoso nos ha ganado, sera desgraciado.");
    }
    
    @Override
    public void defensar(){
    } 
}

