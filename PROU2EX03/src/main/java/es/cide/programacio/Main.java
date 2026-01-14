package es.cide.programacio;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random();

        //A continuacion la bienvenida e instrucciones para el jugador
        System.out.println("Bienvenido a la Batalla de Insultos entre piratas");
        System.out.println("Instrucciones: Cada ronda un pirata te insultará y tendrás que elegir la mejor respuesta.");
        System.out.println("Si aciertas la respuesta ganarás 2 puntos, pero si fallas perderás 1 punto.");
        System.out.println("Si deseas acabar antes pulsa 0 y terminará el juego.");

        String[] insultos = {//Array de insultos
            "¡Mejor que te vayas antes de que te hagas daño!",
            "Eres tan repulsivo como una mona marrana",
            "¡Fuera de mi cubierta, babosa marina!",
            "¡Te perseguiré dia y noche sin ningún respeto!",
            "Jamás había visto a nadie tan torpe con la espada"
        };

        String[] correctas = {//Array de respuestas correctas
            "¡He venido a saquear tu tesoro!",
            "¿Es que tanto me parezco a tu hermana?",
            "¡Tu tesoro o tu vida!",
            "Entonces se un buen perro ¡Siéntate! ¡Quieto!",
            "Así habría sido, pero siempre estabas de escapada."
        };

        String[] incorrectas = { //Array de respuestas incorrectas
            "¡Soy Cuybrush Threepwood! ¡Un gran pirata!",
            "Uups... pensaba que eras otra persona.",
            "Cuando termine CONTIGO, serás un bistec disentería.",
            "¡Eres el monstruo más feo jamás creado",
            "¡Voy a enseñarte como a una puerca guarrería!"
        };

        int puntuacion = 0; 
        int ronda = 1;     
        int maxRondas = 5; //Maximo de rondas
        int eleccion = - 1; //Eleccion del jugador     

        while (ronda <= maxRondas && eleccion != 0) {//Bucle del juego
            int insultoAleatorio = aleatorio.nextInt(insultos.length); //Aleatorizo un insulto
            int posicion = aleatorio.nextInt(3); //Aleatorizo la posición de la respuesta correcta (0, 1, 2)=3veces

            //Escoge 2 respuestas incorrectas
            int respuestaIncorrecta1 = aleatorio.nextInt(incorrectas.length); //Primera respuesta incorrecta aleatoria
            int respuestaIncorrecta2; //Segunda respuesta incorrecta aleatoria
            do { //Un mini bucle para que no repitan las respuestas incorrectas
                respuestaIncorrecta2 = aleatorio.nextInt(incorrectas.length);
            } while (respuestaIncorrecta2 == respuestaIncorrecta1);
            //Enseña la ronda y el insulto del pirata
            System.out.println("Ronda: " + ronda);
            System.out.println("Pirata: " + insultos[insultoAleatorio]);

            //Enseña las respuestas por la posición aleatoria
            if (posicion == 0) {
                System.out.println("1. " + correctas[insultoAleatorio]);
                System.out.println("2. " + incorrectas[respuestaIncorrecta1]);
                System.out.println("3. " + incorrectas[respuestaIncorrecta2]);
            } else if (posicion == 1) {
                System.out.println("1. " + incorrectas[respuestaIncorrecta1]);
                System.out.println("2. " + correctas[insultoAleatorio]);
                System.out.println("3. " + incorrectas[respuestaIncorrecta2]);
            } else {
                System.out.println("1. " + incorrectas[respuestaIncorrecta1]);
                System.out.println("2. " + incorrectas[respuestaIncorrecta2]);
                System.out.println("3. " + correctas[insultoAleatorio]);
            }

            //El usuario elige una opcion entro 1-3 o el 0 para salir del juego
            System.out.print("Tu respuesta tiene que ser (1-3 o 0 para abandonar el juego): ");
            eleccion = sc.nextInt();
            sc.nextLine();

            if (eleccion != 0) {//Si el usuario pone un 0 se acaba el juego
                //System.out.println("Has abandonado la batalla. aún no estas lo suficientemente preparado, practica más marinero.");
                if (eleccion < 1 || eleccion > 3) { //Si la respuesta es entre 1 y 3
                    System.out.println("Mala respuesta. Pierdes 1 punto.");
                    puntuacion -= 1;
                } else if (eleccion - 1 == posicion) { //Esto es porque cuando el jugador pone 2 en verdad es la opción 1 porque el array lo lee -1
                    System.out.println("Bien hecho!"); //Sii acierta la respuesta suma 2 puntos
                    puntuacion += 2;
                } else { //Si la falla resta 1 punto
                    System.out.println("Decepcionante");
                    puntuacion -= 1;
                }
                System.out.println("Puntuación actual: " + puntuacion); //Muestra la puntuación actual
                ronda++;
            }

        //Estadisticas finales del usuario del juego 
        System.out.println("Rondas jugadas: " + ronda); //Rondas totales
        System.out.println("Puntuación final: " + puntuacion); //Puntuacion total
        if (puntuacion >=10) { //Si la puntuación es mayor o igual que 10
            System.out.println("¡Eres el rey de los piratas!");
        } else if (puntuacion >= 5) { //Si la puntuación es mayor o igual que 5
            System.out.println("Te has defendido como un buen marinero.");
        } else { //Si la puntuación es menor que 5
            System.out.println("¡Los loros se ríen de ti!");
        }
        sc.close();
    }
    }
}
