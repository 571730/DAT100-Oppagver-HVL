/**
 * Created by Mikkel on 11.09.2017.
 */
public class Oppgave4 {
    public static void main(String[] args){
        double radians = 0;
        double sinx = 0;
        double cosx = 0;

        System.out.println("  x i grader  x i radianer      sin(x)       cos(x)");
        System.out.println("----------------------------------------------------");

        /*Loop that goes trough degrees 0 to 180 in steps of 15 */
        for (int i=0; i <= 180;i = i+15){
            radians = Math.toRadians(i);
            sinx = Math.sin(radians);
            cosx = Math.cos(radians);
            System.out.format("%12d %12.3f %12.3f %12.3f%n", i, radians, sinx, cosx);
        }
        System.out.println("----------------------------------------------------");
    }
}
