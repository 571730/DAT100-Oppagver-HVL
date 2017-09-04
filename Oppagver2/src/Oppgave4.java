import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by Mikkel on 04.09.2017.
 */
public class Oppgave4 {
    public static void main(String[] args){
        String txtNedre = showInputDialog("Skriv inn nedre grense: ");
        String txtOvre = showInputDialog("Skriv inn ovre grense: ");
        int nedre = Integer.parseInt(txtNedre);
        int ovre = Integer.parseInt(txtOvre);
        List<Integer> liste = new ArrayList<Integer>();

        for (int i=nedre; i<=ovre; i++){
            int rest = i%2;
            if (rest != 0){
                liste.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : liste){
            sb.append(i);
            sb.append(", ");
        }
        showMessageDialog(null, "Resultat: "+sb.toString());
    }
}
