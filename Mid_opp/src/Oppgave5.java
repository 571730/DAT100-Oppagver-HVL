import java.util.Scanner;

/**
 * Created by Mikkel on 11.09.2017.
 */
public class Oppgave5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[] liste = new double[7];
        double snittTemp = 0;
        double maksTemp = -200;

        System.out.println("Skriv inn temperaturer for 7 dager");
        for (int i=0; i < 7; i++){
            System.out.print("Dag " + (i+1) + ": ");
            liste[i] = sc.nextDouble();
        }
        for (double temp : liste){
            snittTemp = snittTemp + temp;
            if (temp>maksTemp){
                maksTemp = temp;
            }
        }
        snittTemp = snittTemp/7;
        System.out.format("Gjennomsnittstemperaturen var %.1f grader\n", snittTemp);
        System.out.format("Maksimum for denne uken var %.1f grader\n", maksTemp);
    }
}
