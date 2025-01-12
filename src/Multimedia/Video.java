package Multimedia;

import Interfacce.Luminosita;
import Interfacce.Volume;

public class Video extends InterfacciaGenerale implements Volume, Luminosita {
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int d, int v, int l) {
        super(titolo);
        this.durata = d;
        this.volume = v;
        this.luminosita = l;

    }

    @Override
    public void aumentaLuminosita() {
        luminosita--;
    }

    @Override
    public void diminuisciLuminosita() {
    luminosita++;
    }

    @Override
    public void abbassaVolume() {
    volume--;
    }

    @Override
    public void alzaVolume() {
    volume++;
    }

    @Override
    public void play() {
        for (int i=0; i<durata; i++){
            System.out.println(titolo + " " + "!".repeat(volume) + "*".repeat(luminosita) );
        }
    }
}
