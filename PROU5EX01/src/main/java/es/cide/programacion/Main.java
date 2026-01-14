//Nombre: Blai Lorente Fuster
//DNI: 43482846N
//Fecha: 09/12/2025
package es.cide.programacion;

import java.util.Scanner;

public abstract class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String heroeNombre = ""; //Nombre del heroe
        boolean heroeVivo = true; //Boolean de que el heroe esta vivo
        boolean acierta; //Si acierta la respuesta
        int ronda = 0; //int de las rondas
        String pirataNombre = ""; //Nombre del pirata
        int eleccionHeroe;

        Heroi heroi = null; //Creamos el Heroe
        Illa illa = new Illa(); //Creamos Isla

        System.out.println("Bienvenido al juego LeChuck's Revenge: Monkey Island 2"); //Muestra la bienvenida al juego
        System.out.println("Introduce (1 o 2) para seleccionar personaje: "); //Introduce las opciones a elegir de los heroes
        System.out.println("1. Guybrush");
        System.out.println("2. Elaine");
        eleccionHeroe = sc.nextInt(); //Eleccion de las opciones

        while (eleccionHeroe != 1 && eleccionHeroe != 2) { //Si el usuario pone algo diferente a 1 y 2 vuelve a preguntar el numero
            System.out.println("Esta opcion no esta, introduce 1 o 2:"); 
            eleccionHeroe = sc.nextInt();
        }

        if (eleccionHeroe == 1) { //Si escogemos la opcion 1 
            System.out.println("Tu personaje es: Guybrush");
            heroi = new Guybrush("Guybrush", 10, true);
            heroeNombre = "Guybrush";
        } else if (eleccionHeroe == 2) { //Si escogemos la opcion 2
            System.out.println("Tu personaje es: Elaine");
            heroi = new Elaine("Elaine", 10, true); //Creamos Elaine
            heroeNombre = "Elaine";
        }
        
        
        heroi.sayHello();
        System.out.println("Estas en la isla: " + illa.getNomIlla()); //Muestra el nombre de la isla
        int totalPiratas = illa.getPirataAleatorio(); //Obtenemos el numero de piratas
        
        System.out.println("Hay " + totalPiratas + " piratas en esta isla"); //Muestra el numero de piratas que hay
        System.out.println("----------"); //Separacion
        
        Pirata pirata = new Pirata(pirataNombre, 5, true); //Creamos Pirata

        while (heroeVivo && ronda < totalPiratas) { 
            pirata = illa.vullUnPirata(ronda); //Nos da un pirata del array
            pirataNombre = pirata.getNomPirata(); //Obtenemos el nombre del pirata
            pirata.sayHello(); //La presentacion del pirata
            
            System.out.println("Combate: " + (ronda + 1) + " de " + totalPiratas + " "); //Muestra la ronda y los piratas
            System.out.println("Tu batalla es con: " + pirataNombre); //Muestra el nombre del pirata de esta batalla
            System.out.println("Vida del pirata: " + pirata.vida); //Muestra la vida del pirata
            System.out.println("Tu vida: " + heroi.vida); //Muestra la vida del heroe
            System.out.println("----------"); //Separacion
            
            while (pirata.vida > 0 && heroeVivo) { //Bucle de si la vida del pirata es diferente a 0 y si el heroe esta vivo
                pirata.insultar();
                System.out.println("----------"); //Muestra una separacion
                
                heroi.defensar();
                System.out.println(heroeNombre+": " + heroi.getEleccio()); //Nombre heroe y la respuesta de este
                System.out.println("----------"); //Separacion
                
                acierta = pirata.replica(heroi.getEleccio());
                
                if (acierta) { //If de si acierta la respuesta aparece este mensaje
                    System.out.println(pirataNombre + ": Madre mia como puede ser que me hayas ganado, por poco.");
                    System.out.println("----------"); //Separacion
                    pirata.getVida();
                    
                } else if (!acierta) { //Else if de si falla la respuesta aparece este mensaje
                    System.out.println(pirataNombre + ": ¿Te pegan en casa y no lo sabes o eres tonto por naturaleza?");
                    System.out.println("--------"); //Separacion
                    heroi.getVida();
                    
                    if (heroi.vida() == false) { //Si la vida es false aparece este mensaje
                        System.out.println("El Pirata a ganado."); //Victoria del pirata
                        heroeVivo = false;
                        heroi.sayGoodBye(); //La despedida del heroe
                    }
                }
            }
            ronda++; //Aumenta la ronda para pasar al siguiente pirata
        }
        
        if (heroeVivo) { //Victoria del heroe
            System.out.println("Enhorabuena, has ganado estas batallas"); //Muestra la enhorabuena al jugador
            System.out.println("Has ganado a los " + totalPiratas + " piratas de " + illa.getNomIlla()); //Muestra los pirata derrotados y el nombre de la isla
        } else { //De la victoria del pirata
            System.out.println("Ha sido lamentable tu nivel, decepcionante."); //Muestra la humillación al jugador
        }
        
        sc.close();
    }
}