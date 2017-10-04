import java.util.Arrays;

public class Matrix {
    public static int[][] matrixOne = {{1, 2, 3, 4, 5, 6}, {3, 2, 1, 4, 5, 6}, {7, 3, 4, 1, 5, 6}};
    public static int[][] matrixTwo = {{1, 2, 3, 4, 5, 6}, {3, 2, 1, 4, 5, 6}, {7, 3, 4, 1, 5, 6}};
    public static int[][] matrixKvad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},};
    public static int[] liste1 = {1,2,3,4,5,6,7,8,9};
    public static int[] liste2 = {7,32,4,46,54,63,71,58,19};
    public static int[] eqOne = {1,4,5,6};
    public static int[] eqTwo = {1,4,5,6};


    public static void main(String[] args){
        skrivUtv1();
        System.out.println();
        skrivUtv2();
        System.out.println();
        int [][] skalertMatrix = skaler(1,matrixOne);
        skrivUtAlle(skalertMatrix);
        System.out.println();
        skrivUtAlle(matrixKvad);
        System.out.println();
        int [][] speilMatrix = speile(matrixKvad);
        skrivUtAlle(speilMatrix);
        System.out.println();
        int[] flettet = flette(liste1, liste2);
        skrivUt1d(flettet);
        System.out.println();
        erLik(eqOne,eqTwo);
        System.out.println();
        System.out.println(erLik2d(matrixOne, matrixTwo));
        taTid();

    }

    public static void skrivUtv1(){
        for (int row=0; row<matrixOne.length; row++){
            for (int col=0; col<matrixOne[row].length; col++){
                System.out.print(matrixOne[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void skrivUtv2(){
        for (int[] row : matrixOne){
            for (int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void skrivUtAlle(int[][] matrix){
        for (int[] row : matrix){
            for (int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    public static void skrivUt1d(int[] liste){
        for (int tall:liste
             ) {
            System.out.print(tall + " ");
        }
    }

    public static int[][] skaler(int tall, int[][] matrise){
        for (int row=0; row<matrise.length; row++) {
            for (int col=0; col<matrise[row].length; col++) {
                matrise[row][col] = matrise[row][col] * tall;
            }
        }

        return matrise;
    }

    public static int[][] speile(int [][] matrise){
        //int [][] copyMatrix = matrise;
        int [][] speilMatrix = new int[matrise.length][matrise[0].length];
        for (int row=0; row<matrise.length; row++){
            for (int num=0; num<matrise[row].length; num++){
                speilMatrix[num][row] = matrise[row][num];
            }
        }
        return speilMatrix;
    }

    public static int[] flette (int[] tabell1,int[] tabell2){
        int totLengde = tabell1.length + tabell2.length;
        int[] nyListe = new int[totLengde];
        for (int i=0; i<tabell1.length; i++){
            nyListe[i] = tabell1[i];
        }
        for (int i=0; i<tabell2.length; i++){
            nyListe[i+tabell1.length] = tabell2[i];
        }
        Arrays.sort(nyListe);

        return nyListe;
    }

    public static void erLik(int[] listeEn, int[] listeTo){
        if (Arrays.equals(listeEn, listeTo)){
            System.out.println("Listene er like");
        }
        else {
            System.out.println("Listene er ikke like");
        }
    }

    public static boolean erLik2d(int[][] matrise1,int[][] matrise2){
        boolean like = false;
        for (int row=0; row<matrise1.length; row++){
            for (int tall=0; tall<matrise1[row].length; tall++){
                if (matrise1[row][tall]!=matrise2[row][tall]){
                    like = false;
                }
                else {
                    like = true;
                }
            }
        }
        return like;
    }

    public static void taTid(){
        for (int tall=0; tall<1000000000; tall=tall+1000000){
            int[] langListe = new int[tall];
            for (int i=0; i<langListe.length; i++){
                langListe[i] = (int)(Math.random()*100);
            }
            long tidStart = System.currentTimeMillis();
            Arrays.sort(langListe);
            long tidStop = System.currentTimeMillis();
            System.out.println(tidStop-tidStart + " millisekunder for " + tall + " tall");
        }

    }


}
