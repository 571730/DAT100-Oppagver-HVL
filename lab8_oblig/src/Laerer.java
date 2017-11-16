import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Laerer extends Person {
    private int maanedlonn;
    private int kontonummer;

    public Laerer(String etternamn, String fornamn, int fodtaar, char kjonn, int maanedlonn, int kontonummer) {
        super(etternamn, fornamn, fodtaar, kjonn);
        this.maanedlonn = maanedlonn;
        this.kontonummer = kontonummer;
    }
    public int getMaanedlonn(){
        return maanedlonn;
    }
    public int getKontonummer(){
        return kontonummer;
    }

    @Override
    public String toString() {
        return "\nEtternamn: " + etternamn + "\nFornamn: " + fornamn + "\nFodt år:  " +
                fodtaar + "\nKjonn: " + kjonn
                + "\nMaanedslonn: " + maanedlonn + "\nKontonummer: " + kontonummer;
    }

    public String toHTML(){
        String kjonnString;
        if (kjonn == 'm'){
            kjonnString = "MANN";
        }else {
            kjonnString = "KVINNE";
        }
        return "<html>\n<ul>\n<li>" + fornamn + " " + etternamn + "</li>" +
                "\n<li>" + kjonnString + " " + fodtaar + "</li>" +
                "\n<li>" + kontonummer + " " + maanedlonn + "</li>" +
                "\n</ul>\n</html>";
    }

    public void tilHTMLfil() throws FileNotFoundException {
        String filnavn = etternamn + ".html";
        File fil = new File(filnavn);
        PrintWriter pw = new PrintWriter(fil);
        String htmlTekst = toHTML();
        pw.print(htmlTekst);
        pw.close();

    }

}
