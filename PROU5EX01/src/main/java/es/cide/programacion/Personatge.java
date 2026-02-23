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

