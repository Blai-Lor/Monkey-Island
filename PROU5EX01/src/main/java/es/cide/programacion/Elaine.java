package es.cide.programacion;

import java.util.Random;

public class Elaine extends Heroi implements Fight, Speak{
    Random random = new Random();
    
    //ATRIBUTOS
    String nom;
    int eleccioResposta; //int de las elecciones

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
    public Elaine(String nom, int vida, boolean vivo){
        super(nom, vida, vivo);
        this.nom = nom;
        this.vida = 10;
        this.vivo = vivo;
    }

    //METODOS
    @Override
    public int getVida() { //Metodo de la vida
        this.vida = vida - 1; //Quita 1 de vida
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
    public void sayHello(){ //La presentacion de Elaine
        System.out.println("Elaine: Hola pirata. Soy Elaine y vamos a acabar con los piratas de esta isla.");
    }

    @Override
    public void sayGoodBye(){ //La despedida de Elaine
        System.out.println("Elaine: Adios pirata, ha sido un honor haber peleado frente a ti.");
    }
    
    @Override
    public void insultar(){
    }
}

