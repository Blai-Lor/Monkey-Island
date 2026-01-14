//Nombre: Blai Lorente Fuster
//DNI: 43482846N
//Fecha: 09/12/2025
package es.cide.programacion;

import java.util.Random;

public class Guybrush extends Heroi implements Fight, Speak{
    Random random = new Random();
    
    //ATRIBUTOS 
    String nom; 
    int eleccioResposta; //int de las elecciones
    String[] respuestaAleatoria = new String[4];
    String[] respuesta = { //String de las respuestas para defenderse de los insultos del pirata
        "¡He venido a saquear tu tesoro!", //¡Mejor que te vayas antes de que te hagas daño!
        "Con tu aliento, seguro que todos fueron asfixiados.", //Los enemigos contra los que me enfrenté fueron aniquilados.
        "Tu solo olor me deja enfadado, agitado y enojado.", //Te dejaré devastado, mutilado y perforado.
        "¿Es que tanto me parezco a tu hermana?", //Eres tan repulsivo como una mona marrana
        "Así habría sido, pero siempre estabas de escapada.", //Jamás había visto a nadie tan torpe con la espada
        "Al menos el mio puede ser identificado.", //Cuando tu padre te vio por primera vez debió sentirse mortificado.
        "Entonces se un buen perro ¡Siéntate! ¡Quieto!", //¡Te perseguiré dia y noche sin ningún respeto!
    };

    //CONSTRUCTOR
    public Guybrush(String nom, int vida, boolean vivo){
        super(nom, vida, vivo);
        this.nom = nom;
        this.vida = vida;
        this.vivo = vivo;

    }

    //GETTER Y SETTER
    public String getNombre(){
        return "Guybrush";
    }

    //METODOS
    public void defensar() { 
        for (int i = 0; i < respuestaAleatoria.length; i++) { //Bucle para que las respuestas aleatorias sean 4
            int numRandom = random.nextInt(respuesta.length); //Numero random de 0 y 6 de las respuestas
            respuestaAleatoria[i] = respuesta[numRandom]; //Como el array de respuestas aleatorias es de 4, hace que coja 4 respuestas del array de respuestas aleatoriamente
        }
        for (int i = 0; i < respuestaAleatoria.length; i++) { //Muestra las 4 respuestas aleatorias
            System.out.println((i + 1) + ". " + respuestaAleatoria[i]); //Las muestra en orden del 1 al 4
        }

        int eleccion = sc.nextInt(); 
        eleccioResposta = eleccion - 1; //Resta 1 a la respuesta ya que la maquina lo lee 0 - 6
        System.out.print("Has escogido: " + eleccion); //Muestra la eleccion
    }

    @Override
    public String getEleccio() { //Metodo de la eleccion
        return respuestaAleatoria[eleccioResposta]; //Muestra la respuesta elegida 
    }

    @Override
    public int getVida() { //Metodo de la vida
        this.vida = vida - 2; //Quita 2 de vida
        if (vida > 0) { //Aqui indica que si la vida es mayor a 0 indica que sigue vivo
            System.out.println("Sigues con vida tienes: " + vida);
            return vida;
        } else if (vida == 0) { //Aqui indica que si la vida es igual a 0 indica que ha muerto
            System.out.println("Has muerto");
            vivo = false; 
        }
        return vida;
    }

    @Override
    public boolean vida() {
        return vivo;
    }

    @Override
    public void sayHello(){ //La presentacion de Guybrush
        System.out.println("Guybrush: Hola pirata. No saben lo que les espera a estos piratas.");
    }

    @Override
    public void sayGoodBye(){ //La despedida de LeChuck
        System.out.println("Guybrush: Adios pirata, ya no nos vemos por aguas desconocidas.");
    }

    @Override
    public void insultar(){   
    }
}
