import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Samling {
    private int antall;
    private Person[] liste;

    public Samling(int storrelse) {
        liste = new Person[storrelse];
        antall = 0;
    }
    public Person[] getListe(){
        return liste;
    }

    public void leggTil(Person p) {
        if (liste.length == antall) {
            Person[] utvidetListe = new Person[liste.length * 2];
            System.arraycopy(liste, 0, utvidetListe, 0, antall);
            liste = utvidetListe;
        }
        liste[antall] = p;
        antall++;

    }

    public void skrivUt() {
        for (int i = 0; i < antall; i++) {
            System.out.println(liste[i].toString());
        }
    }

    public Person eldst() {
        int eldstPlass = 0;

        for (int i = 1; i < antall; i++) {
            if (liste[i].getFodtaar() < liste[eldstPlass].getFodtaar()) {
                eldstPlass = i;
            }
        }

        return liste[eldstPlass];
    }

    public void statistikk(){
        int kvinner = 0;
        int menn = 0;
        int studenter = 0;
        int learere = 0;

        for (int i = 0; i<antall; i++){
            if (liste[i].getKjonn() == 'm'){
                menn++;
            }if(liste[i] instanceof Student){
                studenter++;

            }else {
                kvinner++;
                learere++;
            }
        }
        System.out.println("\nStatistikk\nKvinner: " + kvinner + "\nMenn: " + menn +
                "\nStudenter: " + studenter + "\nLærere: " + learere +
            "\nTotalt antall personer: " + antall);
    }

}
