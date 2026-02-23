package es.cide.programacion;

public abstract class Piratas extends Personatge implements Speak, Fight {

    public Piratas(String nom, int vida){
        super(nom, vida);
    }
}

