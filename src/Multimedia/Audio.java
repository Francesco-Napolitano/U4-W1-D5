package Multimedia;

import Interfacce.Volume;

public class Audio extends InterfacciaGenerale implements Volume{
    private int volume;
    private int durata;

    public Audio(String titolo, int v, int d) {
        super(titolo);
        this.volume = v;
        this.durata = d;
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
        for (int i= 0; i<durata; i++){
            System.out.println(titolo + " " + "!".repeat(volume) );
        }
    }
}
