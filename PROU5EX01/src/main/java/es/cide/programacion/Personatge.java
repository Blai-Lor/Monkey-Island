//Nombre: Blai Lorente Fuster
//DNI: 43482846N
//Fecha: 09/12/2025
package es.cide.programacion;

public abstract class Personatge {

    protected String nom;
    protected int vida;

    public Personatge(String nom, int vida) {
        this.nom = nom;
        this.vida = vida;
    }

    public abstract boolean vida();
    
}
