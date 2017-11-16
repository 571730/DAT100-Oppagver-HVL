import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Skole {

    public static void main(String[] args){
        Samling liste = new Samling(1);
        try{
            liste = fraFil("src/db.txt");
        }catch (FileNotFoundException e){
            System.out.println("Fant ikke filen");
        }

        liste.skrivUt();
        System.out.println("\nDen eldste i samlingen er: ");
        Person eldst = liste.eldst();
        System.out.println(eldst.toString());

        //Printer alle studenter til filer og lager en  liste av alle i index.html

        File fil = new File("index.html");
        try{
            PrintWriter pw = new PrintWriter(fil);
            pw.println("<html>");
            pw.println("<ul>");
            for (Person p:liste.getListe()){
                try {
                    p.tilHTMLfil();
                    String s = "<li><a href=\"" + p.getEtternamn() + ".html\">" +
                            p.getEtternamn() +  " " + p.getFornamn() + "</a></li>";
                    pw.println(s);
                }catch (FileNotFoundException e){
                    System.out.println("Fikk ikke laget filen " + e.getMessage());
                }
            }
            pw.println("</ul>");
            pw.println("</html>");
            pw.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    private static Samling fraFil(String filnavn) throws FileNotFoundException{

        File fil = new File(filnavn);
        Scanner sc = new Scanner(fil);

        int antallLinjer = Integer.parseInt(sc.nextLine());
        Samling liste = new Samling(antallLinjer);
        int teller = 0;

        while (sc.hasNextLine()){
            String linje = sc.nextLine();
            String[] splittet = linje.split(" ");
            if (splittet[0].equals("L")){
                Person p = new Laerer(splittet[1], splittet[2],Integer.parseInt(splittet[3]),
                        splittet[4].charAt(0), Integer.parseInt(splittet[5]), Integer.parseInt(splittet[6]));
                liste.leggTil(p);
            }else {
                Person p = new Student(splittet[1], splittet[2],Integer.parseInt(splittet[3]),
                        splittet[4].charAt(0), Integer.parseInt(splittet[5]), splittet[6]);
                liste.leggTil(p);
            }

        }
        sc.close();
        return liste;
    }

}
