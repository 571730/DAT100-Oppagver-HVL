import java.util.Scanner;


public class Oppgave3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv inn antall ord");
        int antallOrd = sc.nextInt();
        sc.nextLine();
        String[] ordListe = new String[antallOrd];
        int tallSekvens = 0;

        for(int i=0; i<antallOrd; i++){
            System.out.println("Skriv et ord og trykk enter");
            ordListe[i] = sc.nextLine();
        }
        System.out.println("Din liste: ");
        for (String s: ordListe)
        {
            System.out.print(s + " ");
        }

        // Oppagve B

        System.out.println("\n\nHvilken sekvens vil du telle?");
        String sekvens = sc.nextLine();

        for (String s: ordListe) {
            if (s.contains(sekvens)){
                tallSekvens++;
            }
        }
        System.out.println("\nSekvensen " + sekvens + " forekommer " + tallSekvens + " ganger i ordlisten.\n");

        // Oppgave C

        for (String ord: ordListe){
            if (ord.length() == 1){
                System.out.println("Bare en bokstav: " + ord);
            }
            else if ((ord.length()%2) == 0){
                char tegnEn = ord.charAt((ord.length()/2) - 1);
                char tegnTo = ord.charAt(((ord.length()/2)+1) - 1);
                System.out.println("Partall: " + String.valueOf(tegnEn)+String.valueOf(tegnTo));
            }
            else if ((ord.length()%2) != 0){
                if (ord.length()>=3){
                    int midt = (ord.length()+1)/2;
                    char tegnTo = ord.charAt((midt) - 1);
                    char tegnTre = ord.charAt((midt + 1) - 1);
                    char tegnEn = ord.charAt((midt - 1) - 1);
                    System.out.println("Oddetall:" + String.valueOf(tegnEn)+String.valueOf(tegnTo)+String.valueOf(tegnTre));
                }
                else {
                    System.out.println("Ordet er oddetal lengde, men mindre enn 3 tegn.");
                }
            }
            else {
                System.out.println("Noe gikk galt..");
            }
        }
    }
}
