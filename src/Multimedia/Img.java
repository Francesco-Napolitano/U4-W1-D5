package Multimedia;

import Interfacce.Luminosita;

public class Img extends InterfacciaGenerale implements Luminosita {
    private int luminosita;

    public Img(String titolo, int l) {
        super(titolo);
        this.luminosita = l;
    }

    @Override
    public void aumentaLuminosita() {
        luminosita++;
    }

    @Override
    public void diminuisciLuminosita() {
        luminosita--;
    }

    public void mostra(){
        System.out.println(titolo + " " + "!".repeat(luminosita));
    }

    @Override
    public void play() {
        mostra();
    }
}
