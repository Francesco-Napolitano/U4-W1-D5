package MediaPlayer;

import Multimedia.Audio;
import Multimedia.Img;
import Multimedia.InterfacciaGenerale;
import Multimedia.Video;

import java.util.Scanner;

public class Player {
    public static void main(String[] main) {
        InterfacciaGenerale[] player = new InterfacciaGenerale[5];
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Aggiungi 5 elementi multimediali. ");

        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci i seguenti numeri per selezionare l'elemento da aggiungere: \n 1-video | 2-immagine | 3-audio | 0 uscire");
            int scelta = myscanner.nextInt();
            myscanner.nextLine();

            switch (scelta) {
                case 0 -> {
                    System.out.println("Programma annullato.");
                    i += 5;
                }
                case 1 -> {
                    System.out.println("Titolo: ");
                    String title = myscanner.nextLine();
                    System.out.println("Inserisci la durata: ");
                    int durata = myscanner.nextInt();
                    System.out.println("Inserisci il volume: ");
                    int volume = myscanner.nextInt();
                    System.out.println("Inserisci la luminosità: ");
                    int luminosità = myscanner.nextInt();
                    player[i] = new Video(title, durata, volume, luminosità);
                }
                case 2 -> {
                    System.out.println("Titolo: ");
                    String title = myscanner.nextLine();
                    System.out.println("Inserisci la luminosità: ");
                    int luminosita = myscanner.nextInt();
                    player[i] = new Img(title, luminosita);
                }
                case 3 -> {
                    System.out.println("Titolo: ");
                    String title = myscanner.nextLine();
                    System.out.println("Inserisci la durata: ");
                    int durata = myscanner.nextInt();
                    System.out.println("Inserisci il volume: ");
                    int volume = myscanner.nextInt();
                    System.out.println("Inserisci la luminosità: ");
                    player[i] = new Audio(title, durata, volume);
                }
                default -> {
                    System.out.println("Scelta non valida.");
                }
            }

        }
        System.out.println("\n Scegli cosa fare adesso: ");
        System.out.println("1-Esegui un elemento \n 2-Modifica un elemento (solo volume o luminosità per video/audio \n 3-Esci");
        int scelta = myscanner.nextInt();
        int sceltaPlay = 0;
        do {
            switch (scelta) {
                case 1 -> {
                    System.out.println("Quale elemento vuoi eseguire? Scegli da 1 a 5, 0 per uscire");
                    sceltaPlay = myscanner.nextInt();
                    if (sceltaPlay > 0 && sceltaPlay < player.length) {
                        player[sceltaPlay - 1].play();
                    } else {
                        System.out.println("Scelta non valida, selezionare di nuovo: ");
                    }
                }
                case 2 -> {
                    System.out.println("Scegli l'elemento da modificare: (1-5)");
                    int i = myscanner.nextInt();
                    if (i > 0 && i < player.length){
                        InterfacciaGenerale elemento = player[i];
                    }
                }

            }

        }while (sceltaPlay != 0) ;
        myscanner.close();
    }
}
