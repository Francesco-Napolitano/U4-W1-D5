package Multimedia;

public abstract class InterfacciaGenerale {
    protected String title ;

    public InterfacciaGenerale(String t){
        this.title = t;
    }

    public abstract void play();
}
