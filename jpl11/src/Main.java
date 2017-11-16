import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        Tegnbar[] liste = new Tegnbar[3];
        Firkant firkant = new Firkant(5);
        Person person = new Person();
        Bil bil = new Bil();
        try{
            for (int i = 2; i<100; i++){
                bil.tegnOpp(i);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println("Bla");
        }

        liste[0] = firkant;
        liste[1] = person;
        liste[2] = bil;
        /*
        for (Tegnbar tegning : liste){
            tegning.tegnOpp();
        }*/
    }
}
