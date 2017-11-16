/**
 * Created by Mikkel on 13/09/2017.
 */
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Oppgave1 {
    public static void main(String[] args){
        int i = 1;
        //Loekken vil kjore 10 ganger
        while (i<11){
            String txtPoeng = showInputDialog("Skriv inn poengsum til student: ");
            int poeng = Integer.parseInt(txtPoeng);

            /* Sjekker om poengsum er gyldig
            Om ikke poengsummen er gyldig, trekker vi 1 fra i, slik at runden ikke teller mot de 10 innlesningene */
            if (poeng<0 || poeng>100){
                showMessageDialog(null, "Ugyldig poengsum! Poengsum maa vaere" +
                        " mellom 0 og 100");
                i = i-1;
            }
            //Skriver ut riktig karakter ut i fra poengsum
            else {
                if (poeng<40){
                    String karakter = "F";
                    VisMelding(poeng, karakter);
                }
                else if (poeng<50){
                    String karakter = "E";
                    VisMelding(poeng, karakter);
                }
                else if (poeng<60){
                    String karakter = "D";
                    VisMelding(poeng, karakter);
                }
                else if (poeng<80){
                    String karakter = "C";
                    VisMelding(poeng, karakter);
                }
                else if (poeng<90){
                    String karakter = "B";
                    VisMelding(poeng, karakter);
                }
                else if (poeng<100){
                    String karakter = "A";
                    VisMelding(poeng, karakter);
                }
            }

            i++;
        }
    }
    private static void VisMelding(int poeng, String karakter){
        showMessageDialog(null, "Med "+poeng+" poeng er din karakter "+karakter);
    }
}

