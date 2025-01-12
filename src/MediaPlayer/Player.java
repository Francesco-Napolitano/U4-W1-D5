package MediaPlayer;

import Interfacce.Luminosita;
import Interfacce.Volume;
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
        System.out.println("\n Scegli cosa fare adesso:");
        System.out.println(" 1-Esegui un elemento \n 2-Modifica un elemento (volume o luminosità) \n 3-Esci");
        int scelta = myscanner.nextInt();
        boolean esci = false;
        do {
            switch (scelta) {
                case 1 -> {
                    System.out.println("Quale elemento vuoi eseguire? Scegli da 1 a 5, 0 per uscire");
                    int sceltaPlay = myscanner.nextInt();
                    if (sceltaPlay > 0 && sceltaPlay < player.length) {
                        player[sceltaPlay - 1].play();
                    } else if (sceltaPlay!= 0){
                        System.out.println("Scelta non valida, selezionare di nuovo.");
                    } else {
                        esci = true;
                        System.out.println("Sistema terminato");
                    }
                }
                case 2 -> {
                    System.out.println("Scegli l'elemento da modificare: (1-5) esci con 0");
                    int i = myscanner.nextInt();
                    if (i > 0 && i < player.length){
                        InterfacciaGenerale elemento = player[i-1];
                            boolean modifica = true;
                            while (modifica) {
                                System.out.println("Seleziona i seguenti numeri per modificare: \n  1-Luminosità su | 2-Luminositù giù | 3-Volume su | 4-Volume giù | 0-Esci");
                                int modificaScelta = myscanner.nextInt();
                                switch (modificaScelta){
                                    case 0 -> {
                                        modifica = false;
                                    }
                                    case 1 -> {
                                        if (elemento instanceof Luminosita){
                                            ((Luminosita) elemento).aumentaLuminosita();
                                            System.out.println("Comando eseguito! ");
                                        } else {
                                            System.out.println("Luminosità non disponibile per questo elemento.");
                                        }
                                    } case 2 -> {
                                        if (elemento instanceof Luminosita){
                                            ((Luminosita) elemento).diminuisciLuminosita();
                                            System.out.println("Comando eseguito! ");
                                        } else {
                                            System.out.println("Luminosità non disponibile per questo elemento.");
                                        }
                                    }case 3 -> {
                                        if (elemento instanceof Volume){
                                            ((Volume) elemento).alzaVolume();
                                            System.out.println("Comando eseguito! ");
                                        } else {
                                            System.out.println("Volume non disponibile per questo elemento.");
                                        }
                                    }case 4 -> {
                                        if (elemento instanceof Volume){
                                            ((Volume) elemento).abbassaVolume();
                                            System.out.println("Comando eseguito! ");
                                        } else {
                                            System.out.println("Volume non disponibile per questo elemento.");
                                        }
                                    }
                                    default -> {
                                        System.out.println("Scelta non valida");
                                        modificaScelta = myscanner.nextInt();
                                    }
                                }
                            }


                    } else if (i==0){
                        esci = true;
                        System.out.println("Chiusura del programma.");
                    } else {
                        System.out.println("L'elemento non è valido");
                    }
                }
                case 3 ->{
                    esci = true;
                    System.out.println("Arrivederci!");
                }
                default -> System.out.println("Scelta sbagliata");
            }
        }while (!esci ) ;
        myscanner.close();
    }
}
