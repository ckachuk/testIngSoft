import java.util.function.DoubleBinaryOperator;

public class Calculator<memory> implements CalculatorInterface {
    private String memory = null;

    public Calculator(String Memory){
        this.memory = Memory;
    }

    public  Calculator(){

    }

    public String getMemory(){
         return memory;
    }

    public void setMemory(String Memory){
        this.memory = Memory;
    }


    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    @Override
    public boolean clear() {
        if(getMemory() ==null ){
            return false;
        }
        else{
            setMemory(null);
            return true;
        }
    }

    @Override
    public double add(String a) throws Exception{
        if(!isNumeric(a)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        double result = Double.parseDouble(getMemory()) + Double.parseDouble(a);
        setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double add(String a, String b) throws Exception {
        if(!isNumeric(a) || !isNumeric(b)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }

        double result =  Double.parseDouble(a) + Double.parseDouble(b) ;
        setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double substract(String a) throws Exception {
        if(!isNumeric(a)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        double result = Double.parseDouble(getMemory()) - Double.parseDouble(a);
        setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double substract(String a, String b) throws Exception {
        if(!isNumeric(a) || !isNumeric(b)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }

        double result =  Double.parseDouble(a) - Double.parseDouble(b) ;
        setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double multiply(String a) throws Exception {
        if(!isNumeric(a)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        double result = Double.parseDouble(getMemory()) * Double.parseDouble(a);
        setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double multiply(String a, String b) throws Exception {
        if(!isNumeric(a) || !isNumeric(b)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        double result =  Double.parseDouble(a) * Double.parseDouble(b) ;
        setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double divide(String a) throws Exception {
        if(!isNumeric(a)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        else if(Double.valueOf(a) == 0.0){
            throw new Exception("Error por divisor igual a cero");
        }
        double result = Double.parseDouble(getMemory()) / Double.parseDouble(a);
        setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double divide(String a, String b) throws Exception {
        if(!isNumeric(a) || !isNumeric(b)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        else if(Double.parseDouble(b) == 0.0){
            throw new Exception("Error por divisor igual a cero");
        }
        double result =  Double.parseDouble(a) / Double.parseDouble(b) ;
        setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double pow(String base, String exponent) throws Exception {
        if(!isNumeric(base) || !isNumeric(exponent)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        double result = Double.parseDouble(base);

        if(Double.parseDouble(base) > 0 && exponent.contains(".")){
            Double newExponent = 1 / Double.parseDouble(exponent);
            result = root(base, String.valueOf(newExponent));
            setMemory(String.valueOf(result));
        }
        else{
            for (int i = 1; i <  Integer.parseInt(exponent); i++ ){
                result = result * Double.parseDouble(base);
                setMemory(String.valueOf(result));
            }
            if(Integer.parseInt(exponent) % 2 == 0){
                result = Math.abs(result);
                setMemory(String.valueOf(result));
            }
        }


        return result;
    }

    @Override
    public double root(String radicando, String radical){
        double result = 1;
        if(Double.parseDouble(radicando) < 0){
            result = -1;
        }
        else{
            result = Math.pow(Double.parseDouble(radicando), (1/Double.parseDouble(radical)));
            setMemory(String.valueOf(result));
        }

        return result;

    }

    @Override
    public double root(String radical){
        double result = 0;
        if(Double.parseDouble(getMemory()) < 0){
            result = -1;
        }
        else{
            result = Math.pow(Double.parseDouble(getMemory()), (1/Double.parseDouble(radical)));
            setMemory(String.valueOf(result));
        }

        return result;
    }


    @Override
    public long factorial() throws Exception {
        if(getMemory().contains(".")){
            throw new Exception("El valor pasado es un numero real y no puede ser aplicado el factorial de dicho numero");
        }
        long result = 1;
        long valueOfNFactorialInDouble = (int) Double.parseDouble(this.getMemory());

        for (int i = 1; i <= valueOfNFactorialInDouble; i++){
            result = result * i;
        }
        setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public long factorial(String a) throws Exception {
        if(a.contains(".")){
            throw new Exception("El valor pasado es un numero real y no puede ser aplicado el factorial de dicho numero");
        }
        long result = 1;

        long valueOfNFactorialInDouble = (int) Double.parseDouble(a);

        for (int i = 1; i <= valueOfNFactorialInDouble; i++){
            result = result * i;
        }
        setMemory(String.valueOf(result));
        return result;
    }





}
