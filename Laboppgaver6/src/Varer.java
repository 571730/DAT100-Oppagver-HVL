import java.util.Arrays;
import java.util.Scanner;

public class Varer {
    private int varenummer;
    private String navn;
    private double pris;

    public Varer(int varenummer, String navn, double pris) {
        this.varenummer = varenummer;
        this.navn = navn;
        this.pris = pris;
    }

    public Varer() {
    }

    public int getVarenummer() {
        return varenummer;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public void setVarenummer(int varenummer) {
        this.varenummer = varenummer;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public double moms() {
        return (pris / 100) * 20;
    }

    public boolean billigereEnn(Varer v) {
        return pris < v.pris;
    }

    @Override
    public String toString() {
        return "Varer{" +
                "varenummer=" + varenummer +
                ", navn='" + navn + '\'' +
                ", pris=" + pris +
                '}';
    }
}

class Klient {
    public static void main(String[] args) {
        Meny meny = new Meny();
        meny.menyen();

    }
}

class Varelager {
    private final static int STDK = 100;
    private int antall;
    private Varer[] lager;

    @Override
    public String toString() {
        return "Varelager{" +
                "antall=" + antall +
                ", lager=" + Arrays.toString(lager) +
                '}';
    }

    public Varelager() {
        this(STDK);
    }

    public int getAntall() {
        return antall;
    }

    public Varer[] getLager() {
        return lager;
    }

    public Varelager(int startkapasitet) {
        lager = new Varer[startkapasitet];
        antall = 0;
    }

    public void leggTil(Varer v) {
        if (antall < lager.length) {
            lager[antall] = v;
            System.out.println("La til varen " + v.getNavn() + " i lageret.");
            antall++;
        } else {
            utvid();
            lager[antall] = v;
            System.out.println("La til varen " + v.getNavn() + " i lageret.");
            antall++;
        }

    }

    void utvid() {
        System.out.println("Utvider lageret med 5 plasser");
        Varer[] lagerKopi = new Varer[lager.length + 5];
        for (int i = 0; i < lager.length; i++) {
            lagerKopi[i] = lager[i];
        }
        lager = lagerKopi;
    }

    void skrivUtPent() {
        System.out.println("Antall varer på lager: " + antall);
        for (int i = 0; i < antall; i++) {
            System.out.println("\nVarenummer: " + lager[i].getVarenummer());
            System.out.println("Navn: " + lager[i].getNavn());
            System.out.println("Pris: " + lager[i].getPris() + " kr");
        }
    }

    public boolean sokVare(int nr) {
        boolean funnet = false;
        try {
            for (Varer v : lager) {
                if (v.getVarenummer() == nr) {
                    funnet = true;
                    break;
                }
            }
            return funnet;
        } catch (java.lang.NullPointerException e) {
            System.out.println("Finner ikke varen på lageret");
            return funnet;
        }

    }

    public double totalPris() {
        double totPris = 0;

        for (int i = 0; i < antall; i++) {
            totPris += lager[i].getPris();
        }
        return totPris;
    }

    public void slett(int vareNr) {
        if (!sokVare(vareNr)) {
            System.out.println("Fant ikke varen, så kan heller ikke slette den.");
        } else {
            for (int i = 0; i < antall; i++) {
                int lagerVare = lager[i].getVarenummer();
                if (lagerVare == vareNr) {
                    System.out.println("Sletter varen " + lager[i].getNavn() + " fra lageret.");
                    for (int n = i; n < antall - 1; n++) {
                        lager[n] = lager[n + 1];
                    }
                    antall--;
                }
            }
        }
    }
}

class Grensesnitt {
    public void leggTilVare(Varelager varelager) {
        Scanner sc = new Scanner(System.in);
        boolean acceptInput = false;
        int vareNummer;
        String vareNavn;
        double varePris;

        do {
            try {
                System.out.println("Skriv inn varenummer:");
                vareNummer = sc.nextInt();
                sc.nextLine();
                System.out.println("Skriv inn varens navn:");
                vareNavn = sc.nextLine();
                System.out.println("Skriv inn varens pris:");
                varePris = sc.nextDouble();
                System.out.println("Sjekker om varen alt finnes på lageret..");
                Varer vare = new Varer(vareNummer, vareNavn, varePris);
                if (!varelager.sokVare(vareNummer)) {
                    varelager.leggTil(vare);
                    acceptInput = true;
                } else {
                    System.out.println("Dette varenummeret finnes allerede på lageret.\n" +
                            "Prøv med et annet varenummer.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Error! Feil i input, fix asap!");
                sc.next();
            }
        } while (!acceptInput);
    }

    public void slettVare(Varelager varelager) {
        Scanner sc = new Scanner(System.in);
        boolean acceptInput = false;
        System.out.println(varelager.toString());
        System.out.println("Skriv inn varenummer på varen du vil slette:");

        do {
            try {
                int slettNr = sc.nextInt();
                sc.nextLine();
                System.out.println("Prøver å slette varenummer " + slettNr + "..");
                varelager.slett(slettNr);
                acceptInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Feil i input, prøv igjen.");
            }

        } while (!acceptInput);
    }

    public void printSortert(Varelager varelager) {
        System.out.println("Skriver ut varelager sortert etter varenummer");
        int[] nrListe = new int[varelager.getAntall()];
        Varer[] lager = varelager.getLager();

        for (int i = 0; i < varelager.getAntall(); i++) {
            nrListe[i] = lager[i].getVarenummer();
        }
        Arrays.sort(nrListe);
        for (int tall : nrListe) {
            for (int i = 0; i<nrListe.length; i++) {
                if (tall == lager[i].getVarenummer()){
                    System.out.println(lager[i]);
                }
            }
        }
    }

}

class Meny {
    public void menyen() {
        System.out.println("---  Velkommen til lageret  ---\n\n");
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        Varelager lager = new Varelager(5);
        int dittValg;
        Grensesnitt gui = new Grensesnitt();

        do {
            System.out.println("\n1) Se på lageret\n2) Legg til vare i lageret\n" +
                    "3) Slett vare fra lageret\n" +
                    "4) Se totalpris av alle varer på lageret\n" +
                    "5) Se lager sortert etter varenummer\n9) Avslutt programmet");
            try {
                dittValg = sc.nextInt();
                sc.nextLine();

                switch (dittValg) {
                    case 1:
                        lager.skrivUtPent();
                        break;
                    case 2:
                        gui.leggTilVare(lager);
                        break;
                    case 3:
                        gui.slettVare(lager);
                        break;
                    case 4:
                        System.out.format("Total pris på varer i lageret: %.2f kr%n", lager.totalPris());
                        break;
                    case 5:
                        gui.printSortert(lager);
                        break;
                    case 9:
                        run = false;
                        System.out.println("Avlsutter programmet..");
                        break;
                    default:
                        System.out.println("Ikke et gyldig menyvalg");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ditt menyvalg var ikke gyldig");
            }

        } while (run);
    }
}














