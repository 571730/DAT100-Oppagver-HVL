public class Kvadrat {
    int sidelengde;

    public Kvadrat(int sidelengde) {
        this.sidelengde = sidelengde;
    }

    void areal(){
        System.out.println("Kvadratet har areal " + (sidelengde*sidelengde));
    }

    void omkrets(){
        System.out.println("Kvadratet har omkrets " + (sidelengde*4));
    }

    void diagonal(){
        double sideDouble = (double) sidelengde;
        System.out.println("Kvadratet har diagonal " +
                (Math.hypot(sideDouble, sideDouble)));
    }

    void skrivUt(){
        for (int i=0; i<sidelengde; i++){
            for (int n=0; n<sidelengde; n++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
class Run {
    Kvadrat kv3 = new Kvadrat(3);
    Kvadrat kv4 = new Kvadrat(4);
    Kvadrat kv5 = new Kvadrat(5);

}
