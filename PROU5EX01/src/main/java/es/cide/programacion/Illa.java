package es.cide.programacion;

import java.util.Random;

public class Illa {
    Random random = new Random();

    //ATRIBUTOS
    int numeroPiratas; //int para despues aleatorizar el numero de piratas de la isla
    String nombreIsla = "Puerto Rico"; 
    String nombreAleatorio; //String para elegir un nombre de pirata aleatorio
    Pirata[] piratas; //Este array es el que almacena los piratas
    String[] nombrePirata = { //Array de los nombres de los piratas
        "Juan Pablo",
        "Pablo Matas",
        "Eloy",
        "Dani Pico",
        "German"
    };
    
    
    //CONSTRUCTOR
    public Illa() {
        numeroPiratas = random.nextInt(3) + 3; //Numero aleatorio entre 3 y 5 de los piratas 
        piratas = new Pirata[numeroPiratas]; //Inicializa el array de piratas con el tamaño generado
        
        boolean[] nombreUsado = new boolean[nombrePirata.length]; //Este array es para saber que nombre ha salido
        
        for (int i = 0; i < numeroPiratas -1; i++) { //Pone a los piratas y el -1 es porque el ultimo es LeChuck
            int nombreNoUsado; //int para los nombres que no se han usado
            do { //Bucle para que no se repitan los nombres
                nombreNoUsado = random.nextInt(nombrePirata.length); //Hace un numero aleatorio para elegir un nombre y que no se repita
            } while (nombreUsado[nombreNoUsado]);
            
            nombreUsado[nombreNoUsado] = true; //Dice si el nombre se ha usado
            nombreAleatorio = nombrePirata[nombreNoUsado]; //Es el String para elegir un nombre de pirata aleatorio
            int vidaAleatoria = random.nextInt(3) + 1; //Vida aleatoria entre 1 y 3
            piratas[i] = new Pirata(nombreAleatorio, vidaAleatoria, true); //Crea un pirata con un nombre aleatorio único y vida aleatoria entre 1 y 3
        }
        piratas[numeroPiratas -1] = new LeChuck("LeChuck", 5, true); //Creo LeChuck fuera para que sea el ultimo y -1 para estar el ultimo en el array
    }

    //GETTER Y SETTER
    public String getNomIlla() { //Muestra el nombre de la isla
        return nombreIsla;
    }

    public int getPirataAleatorio() { //Numero de piratas generados
        return numeroPiratas;
    }
    
    //METODO 
    public Pirata vullUnPirata(int index) { //Muestra un pirata del array donde estan los piratas
        return piratas[index];
    }

}
