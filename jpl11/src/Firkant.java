public class Firkant implements Tegnbar {
    private int lengde;

    public Firkant(int lengde) {
        this.lengde = lengde;
    }

    public void tegnOpp(int space){
        System.out.println("\nFirkant\n");
        for(int i = 0; i< lengde; i++){
            for (int n = 0; n<lengde; n++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
