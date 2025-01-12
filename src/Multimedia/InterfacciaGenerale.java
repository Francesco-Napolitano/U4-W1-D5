package Multimedia;

public abstract class InterfacciaGenerale {
    protected String titolo ;

    public InterfacciaGenerale(String titolo){
        this.titolo = titolo;
    }

    public abstract void play();

}
