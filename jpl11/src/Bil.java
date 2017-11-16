public class Bil implements Tegnbar{

    @Override
    public void tegnOpp(int space) {
        System.out.println("\nBil\n");
        System.out.format("%" + space + "s%s"  ,""," __\n"  );
        System.out.format("%"+space+"s%s" ,"","/__\\____\n");
        System.out.format("%"+space+"s%s" ,"","|_-__-__|\n");
        System.out.format("%"+space+"s%s" ,"","  O  O\n");
        System.out.print(String.format("%0"+(space+20)+ "d", 0).replace("0", "_"));
    }
}
