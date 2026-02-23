package es.cide.programacion;

import java.util.Random;
import java.util.Scanner;

public abstract class Heroi extends Personatge implements Speak, Fight {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    //ATRIBUTOS
    int eleccion;
    int eleccioResposta;
    boolean vivo; //Boolean de si el heroe esta vivo
    int asalto1, asalto2, asalto3; //int de las 3 variables de asalto
    
    String[] respuesta = { //String de las respuestas para defenderse de los insultos del pirata
        "¡He venido a saquear tu tesoro!", //¡Mejor que te vayas antes de que te hagas daño!
        "Con tu aliento, seguro que todos fueron asfixiados.", //Los enemigos contra los que me enfrenté fueron aniquilados.
        "Tu solo olor me deja enfadado, agitado y enojado.", //Te dejaré devastado, mutilado y perforado.
        "¿Es que tanto me parezco a tu hermana?", //Eres tan repulsivo como una mona marrana
        "Así habría sido, pero siempre estabas de escapada.", //Jamás había visto a nadie tan torpe con la espada
        "Al menos el mio puede ser identificado.", //Cuando tu padre te vio por primera vez debió sentirse mortificado.
        "Entonces se un buen perro ¡Siéntate! ¡Quieto!", //¡Te perseguiré dia y noche sin ningún respeto!
        "Me haces pensar que alguien ya lo ha hecho." //Respuesta del insulto de LeChuck
    };

    //CONSTRUCTOR
    public Heroi(String nom, int vida, boolean vivo) { 
        super(nom, vida);
        this.nom = nom;
        this.vida = vida;
        this.vivo = vivo;
    
    
    asalto1 = random.nextInt(7); //Numero aleatorio entre 0 y 6
    asalto2 = random.nextInt(7); //Numero aleatorio entre 0 y 6
    asalto3 = random.nextInt(7); //Numero aleatorio entre 0 y 6
    while (asalto1 == asalto2) { //Para que el segundo no sea igual al primero
        asalto2 = random.nextInt(7); //Numero aleatorio entre 0 y 6
    }
    while (asalto1 == asalto3 || asalto2 == asalto3) { //Para que el tercero no sea igual al primero ni al segundo
        asalto3 = random.nextInt(7); //Numero aleatorio entre 0 y 6
    }
    }

    //GETTER Y SETTER
    public String getNomHeroi() { //Muestra el nombre del Heroe
        return this.nom;
    }

    protected int getVida() { //Muestra la vida del heroe
        return vida;
    }

    //METODO
    public void defensar() { //Metodo de defensar y en los que aparecen las respuestas del heroe
        int i = 0;
        while (i < respuesta.length) { //Sale del bucle al acabar de la 1 a la 7
            System.out.println((i + 1) + " . " + respuesta[i]); //i suma para que salgan del 1 al 7 las respuesta del array
            i++; //Suma las rondas
        }
        eleccion = sc.nextInt(); //La eleccion del usuario
        sc.nextLine();
        eleccioResposta = eleccion - 1; //Resta 1 a la respuesta ya que la maquina lo lee 0 - 6
    }
    
    
    public String getEleccio() {
        return respuesta[eleccioResposta]; 
    }

    @Override
    public boolean vida() {
        return vivo;
    }

    @Override
    public void sayHello() { //La presentacion del heroe
        System.out.println("Estoy preparado para enfrentatme a estos sucios piratas!");
    }

    @Override
    public void sayGoodBye() { //La despedida del heroe
        System.out.println("Un gusto poder haber luchado en esta isla!");
    }

    @Override
    public void insultar() {
    }
}

