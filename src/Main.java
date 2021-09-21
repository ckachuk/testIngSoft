import static java.lang.Integer.parseInt;

public class Main {


    public static void main(String[] args) throws Exception{
        Calculator calcula = new Calculator();



        System.out.println(calcula.add("2.2", "2"));
        System.out.println(calcula.getMemory());

        System.out.println(calcula.divide("2","2"));
    }
}
