import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Student extends Person {
    private int studentnummer;
    private String klasse;

    public Student(String etternamn, String fornamn, int fodtaar, char kjonn, int studentnummer, String klasse) {
        super(etternamn, fornamn, fodtaar, kjonn);
        this.studentnummer = studentnummer;
        this.klasse = klasse;
    }

    @Override
    public String toString() {
        return "\nEtternamn: " + etternamn + "\nFornamn: " + fornamn + "\nFodt år:  " + fodtaar +
                "\nKjonn: " + kjonn
                + "\nStudentnummer: " + studentnummer + "\nKlasse: " + klasse;
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
                "\n<li>" + studentnummer + " " + klasse + "</li>" +
                "\n</ul>\n</html>";
    }
    @Override
    public void tilHTMLfil() throws FileNotFoundException {
        String filnavn = etternamn + ".html";
        File fil = new File(filnavn);
        PrintWriter pw = new PrintWriter(fil);
        String htmlTekst = toHTML();
        pw.print(htmlTekst);
        pw.close();

    }

}
