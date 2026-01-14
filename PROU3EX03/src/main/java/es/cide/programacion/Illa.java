package es.cide.programacion;

import java.util.Random;

public class Illa {
    Random random = new Random();

    //ATRIBUTOS
    int numeroPiratas; //int para despues aleatorizar el numero de piratas de la isla
    String nombreIsla = "Puerto Rico"; //Nombre isla del caribe
    String nombreAleatorio; //String para elegir un nombre de pirata aleatorio
    Pirata[] piratas; //Este array es el que almacena los piratas
    String[] nombrePirata = { 
        "Juan Pablo",
        "Pablo Matas",
        "Eloy",
        "Dani Pico",
        "Martin Negro",
        "Uselet",
        "German"
    };
    
    //CONSTRUCTOR
    public Illa() {
        numeroPiratas = random.nextInt(5) + 3; //Numero aleatorio entre 3 y 7 de los piratas 
        piratas = new Pirata[numeroPiratas]; //Inicializa el array de piratas con el tamaño generado
        
        boolean[] nombreUsado = new boolean[nombrePirata.length]; //Este array es para saber que nombre ha salido
        
        for (int i = 0; i < numeroPiratas; i++) {
            int nombreNoUsado; //int para los nombres que no se han usado
            do {
                nombreNoUsado = random.nextInt(nombrePirata.length);
            } while (nombreUsado[nombreNoUsado]);
            
            nombreUsado[nombreNoUsado] = true; //Dice si el nombre se ha usado
            nombreAleatorio = nombrePirata[nombreNoUsado]; //Es el String para elegir un nombre de pirata aleatorio

            piratas[i] = new Pirata(nombreAleatorio, random.nextInt(3) + 1); //Crea un pirata con un nombre aleatorio único y vida aleatoria entre 1 y 3
        }
    }

    //GETTER Y SETTER
    public String getNomisla() { //Muestra el nombre de la isla
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

