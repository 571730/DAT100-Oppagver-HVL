import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by Mikkel on 04.09.2017.
 */
public class Oppgave3 {
    public static void main(String[] args){
        String txtInput = showInputDialog("Skriv inn heltall > 0:");
        int input = Integer.parseInt(txtInput);
        int fakultet = 1;

        for (int i=1; i<=input; i++){
            fakultet = fakultet * i;
        }
        showMessageDialog(null, input+" fakultet blir "+fakultet);
    }
}
