import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 * Created by Mikkel on 04.09.2017.
 */
public class Oppgave2 {
    public static void main(String[] args){
        String txtInput = showInputDialog("Skriv inn bruttoinntekt: ");
        double inntekt = Double.parseDouble(txtInput);
        double dinSkatt;

        if (inntekt < 164101){
            double sats = 0;
            dinSkatt = BeregnSkatt(inntekt, sats);
            ShowMessage(inntekt, dinSkatt, sats);
        }
        else if (inntekt < 230951){
            double sats = 0.93;
            dinSkatt = BeregnSkatt(inntekt, sats);
            ShowMessage(inntekt, dinSkatt, sats);
        }
        else if (inntekt < 580651){
            double sats = 2.41;
            dinSkatt = BeregnSkatt(inntekt, sats);
            ShowMessage(inntekt, dinSkatt, sats);
        }
        else if (inntekt < 934051){
            double sats = 11.52;
            dinSkatt = BeregnSkatt(inntekt, sats);
            ShowMessage(inntekt, dinSkatt, sats);
        }
        else if (inntekt >= 934051){
            double sats = 14.52;
            dinSkatt = BeregnSkatt(inntekt, sats);
            ShowMessage(inntekt, dinSkatt, sats);
        }
    }

    private static double BeregnSkatt(double inntekt, double sats){
        return inntekt * (sats/100);
    }

    private static void ShowMessage(double inntekt, double dinSkatt, double sats){
        showMessageDialog(null, "Med en inntekt paa "+inntekt+"kr " +
                "betaler du "+ dinSkatt+"kr skatt med en sats paa "+sats+"%");
    }
}
