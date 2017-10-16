import java.util.Arrays;
import java.util.Random;

public class Terning {
    public static void main(String[] args) {
        Random terning = new Random();
        int[] terningKast = new int[100];
        int[] antallPerTall = new int[6];
        double snitt = 0;
        int sekser = 0;

        for (int i = 0; i < terningKast.length; i++) {
            terningKast[i] = terning.nextInt(6) + 1;
            teller(antallPerTall, terningKast[i]);
            snitt += terningKast[i];
        }

        snitt = snitt / terningKast.length;

        skrivUt(terningKast);
        System.out.println("Antall kast: " + terningKast.length);

        int teller = 1;
        for (int talt : antallPerTall) {
            System.out.println("Du kastet " + teller + ": " + talt + " ganger");
            teller++;
        }

        System.out.format("Snitt: %.3f%n", snitt);
        sekser = finnTall(terningKast, 6);
        System.out.println("Foerste sekser ble funnet etter " + sekser + " kast");
        int flestKast = finnStorste(antallPerTall);
        System.out.println("Det ble trillet flest " + flestKast + "ere.");

    }

    static void skrivUt(int[] array) {
        for (int n = 0; n < array.length; n++) {
            if (n % 20 == 0) {
                System.out.println();
                System.out.format("%4d", array[n]);
            } else {
                System.out.format("%4d", array[n]);
            }
        }
        System.out.println();
    }

    static int[] teller(int[] array, int tall) {
        switch (tall) {
            case 1:
                array[0] += 1;
                break;
            case 2:
                array[1] += 1;
                break;
            case 3:
                array[2] += 1;
                break;
            case 4:
                array[3] += 1;
                break;
            case 5:
                array[4] += 1;
                break;
            case 6:
                array[5] += 1;
                break;
        }

        return array;
    }

    static int finnTall(int[] array, int tall) {
        int kast = 1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == tall) {
                break;
            } else {
                kast++;
            }
        }

        return kast;
    }

    static int finnStorste(int[] array) {
        int flestKast = 0;
        int storst = 0;

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            if (temp > storst) {
                flestKast = i + 1;
                storst = temp;
            }
        }
        return flestKast;
    }
}
