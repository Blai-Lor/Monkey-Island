package es.cide.programacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean heroeVivo = true; //Boolean de que el heroe esta vivo
        boolean acierta;
        int ronda = 0; //int de las rondas
        String pirataNombre;
        
        System.out.println("Bienvenido al juego The Secret of: Monkey Island"); //Muestra la bienvenida al juego
        System.out.print("Introduce el nombre de tu heroe: ");
        String herNom = sc.nextLine(); //String del nombre del heroe
        
        Heroi heroe = new Heroi(herNom, 10); //Creamos el heroe con el nombre y la vida
        
        Illa isla = new Illa(); //Creamos la isla
        int totalPiratas = isla.getPirataAleatorio(); //Obtenemos el numero de piratas
        
        System.out.println(herNom+", estás en " + isla.getNomisla()); //Muestra el nombre de la isla   
        System.out.println("Hay " + totalPiratas + " piratas en esta isla"); //Muestra el numero de piratas que hay

        while (heroeVivo && ronda < totalPiratas) { 
            Pirata pirata = isla.vullUnPirata(ronda); //Nos da un pirata del array
            pirataNombre = pirata.getNompirata(); //Obtenemos el nombre del pirata
            int pirataVida = pirata.getVidapirata(); //Obtenemos la vida del pirata
            
            System.out.println("---- Batalla " + (ronda + 1) + " de " + totalPiratas + " ----"); //Muestra la ronda y los piratas
            System.out.println("Tu batalla es con: " + pirataNombre); //Muestra el nombre del pirata de esta batalla
            System.out.println("Vida del pirata: " + pirataVida); 
            System.out.println("Tu vida: " + heroe.getVidaheroe());
            System.out.println("----------"); //Separacion
            
            while (pirataVida > 0 && heroeVivo) { //Bucle de si la vida del pirata es diferente a 0 y si el heroe esta vivo
                String insultado = pirata.insultar();
                System.out.println(pirataNombre + " dice: " + insultado); //Muestra el nombre del pirata y el insulto
                System.out.println("----------"); //Muestra una separacion
                
                String respuestaHeroe = heroe.defensar();
                System.out.println(herNom+": " +respuestaHeroe); //Nombre heroe y la respuesta de este
                System.out.println("----------"); //Separacion
                
                acierta = pirata.replica(respuestaHeroe);
                
                if (acierta) { //If de si acierta la respuesta aparece este mensaje
                    System.out.println("Madre mia como me has ganado, por poco");
                    System.out.println("----------"); //Separacion
                    pirataVida = pirata.vida();
                } else if (!acierta) { //Else if de si falla la respuesta aparece este mensaje
                    System.out.println(pirataNombre+": ¿Te pegan en casa y no lo sabes o eres tonto por naturaleza?");
                    System.out.println("--------"); //Separacion
                    heroe.vidaHeroe();
                    
                    if (heroe.getVidaheroe() <= 0) { //If de si la vida del heroe es igual o menor a 0 es que ha muerto el heroe
                        System.out.println("El Pirata ha ganado."); //Victoria del pirata
                        heroeVivo = false;
                    }
                }
            }
            ronda++; //Aumenta la ronda para pasar al siguiente pirata
        }
        
        if (heroeVivo) { //Victoria del heroe
            System.out.println("Enhorabuena, has ganado estas batallas"); //Muestra la enhorabuena al jugador
            System.out.println("Has ganado a los " + totalPiratas + " piratas de " + isla.getNomisla()); //Muestra los pirata derrotados y el nombre de la isla
        } else { //De la victoria del pirata
            System.out.println("Ha sido lamentable tu nivel, decepcionante"); //Muestra la humillación al jugador
        }
        
        sc.close();
    }
    
}