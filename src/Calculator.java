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
        double result = Double.valueOf(getMemory()) + Double.valueOf(a);
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double add(String a, String b) throws Exception {
        if(!isNumeric(a) || !isNumeric(b)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }

        double result =  Double.valueOf(a) + Double.valueOf(b) ;
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double substract(String a) throws Exception {
        if(!isNumeric(a)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        double result = Double.valueOf(getMemory()) - Double.valueOf(a);
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double substract(String a, String b) throws Exception {
        if(!isNumeric(a) || !isNumeric(b)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }

        double result =  Double.valueOf(a) - Double.valueOf(b) ;
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double multiply(String a) throws Exception {
        if(!isNumeric(a)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        double result = Double.valueOf(getMemory()) * Double.valueOf(a);
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double multiply(String a, String b) throws Exception {
        if(!isNumeric(a) || !isNumeric(b)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        double result =  Double.valueOf(a) * Double.valueOf(b) ;
        this.setMemory(String.valueOf(result));
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
        double result = Double.valueOf(getMemory()) / Double.valueOf(a);
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double divide(String a, String b) throws Exception {
        if(!isNumeric(a) || !isNumeric(b)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        else if(Double.valueOf(b) == 0.0){
            throw new Exception("Error por divisor igual a cero");
        }
        double result =  Double.valueOf(a) / Double.valueOf(b) ;
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double pow(String base, String exponent) throws Exception {
        if(!isNumeric(base) || !isNumeric(exponent)){
            throw new Exception("El valor enviado por parametro no es un numero");
        }
        double result = Double.valueOf(base);

        if(Double.valueOf(base) > 0 && exponent.contains(".")){
            Double newExponent = 1 / Double.valueOf(exponent);
            result = root(base, String.valueOf(newExponent));
            this.setMemory(String.valueOf(result));
        }
        else{
            for (int i = 1; i <  Integer.parseInt(exponent); i++ ){
                result = result * Double.valueOf(base);
                this.setMemory(String.valueOf(result));
            }
            if(Integer.valueOf(exponent) % 2 == 0){
                result = Math.abs(result);
                this.setMemory(String.valueOf(result));
            }
        }


        return result;
    }

    @Override
    public double root(String radicando, String radical){
        double result = 1;
        if(Double.valueOf(radicando) < 0){
            result = -1;
        }
        else{
            result = Math.pow(Double.valueOf(radicando), (1/Double.valueOf(radical)));
            this.setMemory(String.valueOf(result));
        }

        return result;

    }

    @Override
    public double root(String radical){
        double result = 0;
        if(Double.valueOf(getMemory()) < 0){
            result = -1;
        }
        else{
            result = Math.pow(Double.valueOf(getMemory()), (1/Double.valueOf(radical)));
            this.setMemory(String.valueOf(result));
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
        this.setMemory(String.valueOf(result));
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
        this.setMemory(String.valueOf(result));
        return result;
    }





}
