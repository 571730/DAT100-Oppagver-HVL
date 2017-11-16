import java.util.ArrayList;

public class SpilleListe {

    private ArrayList<Sang> sanger;
    public SpilleListe() {
        sanger = new ArrayList<Sang>();
    }

    public void leggTil(Sang sang) {
        sanger.add(sang);
    }

    public boolean leggTilSjekk(Sang sang) {
        if (sanger.contains(sang)){
            return false;
        }else {
            leggTil(sang);
            return true;
        }
    }

    public void visListe() {
        for (Sang sang : sanger){
            sang.skrivUt();
        }
    }

    public ArrayList<Sang> finnSanger(Sang.Sjanger sjanger) {
        ArrayList<Sang> nyListe = new ArrayList<>();

        for (Sang sang : sanger){
            if (sang.getGenre()==sjanger){
                nyListe.add(sang);
            }
        }
        return nyListe;
    }

    public static void main(String[] args){
        SpilleListe liste = new SpilleListe();
        Sang sang1 = new Sang("Feel it still", 138, Sang.Sjanger.POP);
        Sang sang2 = new Sang("Angie", 123, Sang.Sjanger.ROCK);
        Sang sang3 = new Sang("Evil friends", 235, Sang.Sjanger.POP);
        Sang sang4 = new Sang("November has come", 342, Sang.Sjanger.ANNET);
        liste.leggTil(sang1);
        liste.leggTil(sang2);
        liste.leggTil(sang3);
        liste.leggTil(sang4);
        liste.visListe();
        System.out.println("Prøver å legge til sang 1 på nytt..");
        System.out.println("La til sangen: " + liste.leggTilSjekk(sang1));
        System.out.println("Sorterer listen etter sjangeren POP");
        ArrayList<Sang> popListe = liste.finnSanger(Sang.Sjanger.POP);
        for (Sang sang : popListe){
            sang.skrivUt();
        }


    }
}
