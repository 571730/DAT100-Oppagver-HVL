import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Pinkoder {
    private HashMap<Integer,Integer> pinkoder;

    public Pinkoder() {
        pinkoder = new HashMap<>();
    }

    public void registrerPinkode(Integer kortnummer, Integer pinkode){
        pinkoder.put(kortnummer, pinkode);
    }

    public boolean sjekkPinkode(Integer kortnummer, Integer pinkode){
        if (pinkoder.containsKey(kortnummer)) {
            return (pinkoder.get(kortnummer)).equals(pinkode);
        }else {
            System.out.println("kortnummeret finnes ikke");
            return false;
        }
    }

    public Integer verdi(Integer kortnummer){
        return pinkoder.get(kortnummer);
    }
    public void skrivUt(){
        Set set = pinkoder.entrySet();
        Iterator i = set.iterator();

        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
}

class TestPink{
    public static void main(String[] args){
        Pinkoder pinkoder = new Pinkoder();
        pinkoder.registrerPinkode(123456, 654321);
        pinkoder.registrerPinkode(123, 6543);
        System.out.println(pinkoder.verdi(123));
        System.out.println(pinkoder.sjekkPinkode(123, 6543));
        System.out.println(pinkoder.sjekkPinkode(123, 6544));
        System.out.println(pinkoder.sjekkPinkode(1234, 6544));
        pinkoder.registrerPinkode(123, 6543);
        pinkoder.registrerPinkode(123, 6546);
        pinkoder.skrivUt();

    }
}
