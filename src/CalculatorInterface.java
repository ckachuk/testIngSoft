public interface CalculatorInterface {


    boolean clear();

    double add(String a, String b) throws Exception;

    double add(String a) throws Exception;

    double substract(String a, String b) throws Exception;

    double substract(String a) throws Exception;

    double multiply(String a, String b) throws Exception;

    double multiply(String a) throws Exception;

    double divide(String a, String b) throws Exception;

    double divide(String a) throws Exception;

    double pow(String base, String exponent) throws Exception;

    double root(String a, String b) throws Exception;

    double root(String a) throws Exception;

    long factorial(String a) throws Exception;

    long factorial() throws Exception;
}
