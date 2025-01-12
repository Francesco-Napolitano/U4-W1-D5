package Multimedia;

import Interfacce.Volume;

public class Audio extends InterfacciaGenerale implements Volume{
    private int volume;
    private int durata;

    public Audio(String t, int v, int d) {
        super(t);
        this.volume = v;
        this.durata = d;
    }

    @Override
    public void abbassaVolume() {
    volume--;
    }

    @Override
    public void alzaVolume() {

    }

    @Override
    public void play() {

    }
}
