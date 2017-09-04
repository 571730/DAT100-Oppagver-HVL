

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by Mikkel on 04.09.2017.
 */
public class Oppgave5 {
    public static void main(String[] args){
        String txtTall = showInputDialog("Skriv inn tall som skal tas potens av: ");
        String txtPotens = showInputDialog("Grad av potens: ");
        double tall = Double.parseDouble(txtTall);
        double potens = Double.parseDouble(txtPotens);

        double mathResultat = Math.pow(tall, potens);
        double forResultat = tall;

        for (int i=1; i<potens; i++){
            forResultat = forResultat * tall;
        }
        showMessageDialog(null, tall+" opphoyd i "+potens+
                ", er via Math funksjonen lik "+mathResultat+", og via for loekke lik "+forResultat);
    }
}
