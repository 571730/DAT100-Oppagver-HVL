import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Person {
    protected String etternamn;
    protected String fornamn;
    protected int fodtaar;
    protected char kjonn;

    public Person(String etternamn, String fornamn, int fodtaar, char kjonn){
        this.etternamn = etternamn;
        this.fornamn = fornamn;
        this.fodtaar = fodtaar;
        this.kjonn = kjonn;
    }

    public Person(){
        etternamn = null;
        fornamn = null;
        fodtaar = 0;
        kjonn = 'n';
    }

    public String getEtternamn() {
        return etternamn;
    }

    public String getFornamn() {
        return fornamn;
    }

    public int getFodtaar(){
        return fodtaar;
    }

    public char getKjonn(){
        return kjonn;
    }

    public String toString(){
        return "\nEtternamn: " + etternamn + "\nFornamn: " + fornamn + "\nFodt år:  " +
                fodtaar + "\nKjonn: " + kjonn;
    }
    public void tilHTMLfil() throws FileNotFoundException {


    }

}

