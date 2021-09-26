import java.util.function.DoubleBinaryOperator;
import java.util.regex.Pattern;

public class Calculator implements CalculatorInterface {
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
        if(Pattern.matches("^[a-zA-Z]+$", str)){
            return false;
        }
        return true;
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
    public double add(String a) throws RuntimeException{
        if(!isNumeric(a)){//1
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//2
        }
        double result = Double.parseDouble(getMemory()) + Double.parseDouble(a);//3
        setMemory(String.valueOf(result));//4
        return result;//5
    }

    @Override
    public double add(String a, String b) throws RuntimeException {
        if(!isNumeric(a) || !isNumeric(b)){  //1 y 2
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//3
        }

        double result =  Double.parseDouble(a) + Double.parseDouble(b) ;//4
        setMemory(String.valueOf(result));//5
        return result;//6
    }//6

    @Override
    public double substract(String a) throws RuntimeException {
        if(!isNumeric(a)){ //1
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//2
        }
        double result = Double.parseDouble(getMemory()) - Double.parseDouble(a);//3
        setMemory(String.valueOf(result));//4
        return result;//5
    }//6

    @Override
    public double substract(String a, String b) throws RuntimeException {
        if(!isNumeric(a) || !isNumeric(b)){//1 y 2
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//3
        }

        double result =  Double.parseDouble(a) - Double.parseDouble(b);//4
        setMemory(String.valueOf(result));//5
        return result;//6
    }//7

    @Override
    public double multiply(String a) throws RuntimeException {
        if(!isNumeric(a)){//1
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//2
        }
        double result = Double.parseDouble(getMemory()) * Double.parseDouble(a);//3
        setMemory(String.valueOf(result));//4
        return result;//5
    }//6

    @Override
    public double multiply(String a, String b) throws RuntimeException {
        if(!isNumeric(a) || !isNumeric(b)){//1 y 2
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//3
        }
        double result =  Double.parseDouble(a) * Double.parseDouble(b);//4
        setMemory(String.valueOf(result));//5
        return result;//6
    }//7


    @Override
    public double divide(String a) throws RuntimeException {
        if(!isNumeric(a)){//1
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//2
        }
        else if(Double.parseDouble(getMemory()) == 0){//3
            throw new NumberFormatException("Error por divisor igual a cero");//4
        }
        double result =  Double.parseDouble(a) / Double.parseDouble(getMemory()) ;//5
        setMemory(String.valueOf(result));//6
        return result;//7
    }//8

    @Override
    public double divide(String a, String b) throws RuntimeException {
        if(!isNumeric(a) || !isNumeric(b)){//1 y 2
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//3
        }
        else if(Double.parseDouble(b) == 0){//4
            throw new NumberFormatException("Error por divisor igual a cero");//5
        }
        double result =  Double.parseDouble(a) / Double.parseDouble(b);//6
        setMemory(String.valueOf(result));//7
        return result;//8
    }//9

    @Override
    public double pow(String base, String exponent) throws RuntimeException {
        if(!isNumeric(base) || !isNumeric(exponent)){//1 y 2
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//3
        }
        double result = 1;//4

        if( exponent.contains(".") || Double.parseDouble(exponent) < 0){//5 y 6
            Double newExponent = 1 / Double.parseDouble(exponent);//7
            result = root(base, String.valueOf(newExponent));//8
            setMemory(String.valueOf(result));//9
        }
        else{
            for (int i = 1; i <=  Integer.parseInt(exponent); i++ ){//10 y 11
                result = result * Double.parseDouble(base);//11
            }
            setMemory(String.valueOf(result));//12
            if(Integer.parseInt(exponent) % 2 == 0 ){ //13
                result = Math.abs(result);//14
                setMemory(String.valueOf(result));//15
            }
        }


        return result;//16
    }//17

    //cambiar complejidad ciclo
    @Override
    public double root(String radicando, String radical) throws RuntimeException {
        double result = 0; //1
        if(!isNumeric(radicando) || !isNumeric(radical)){//2 y 3
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//4
        }
        else if(Double.parseDouble(radical) == 0){//5
            throw new NumberFormatException("El radical es igual a 0");//6
        }
        else if(Double.parseDouble(radicando) < 0 && Double.parseDouble(radical) > 0 ){//7 y 8
            throw new NumberFormatException("El radicando es negativo");//9
        }

        if (Double.parseDouble(radicando) < 0 && Double.parseDouble(radical) < 0 ){//10 y 11
            String radicandoPositivo = radicando.replace("-","");//12
            result = Math.pow(Double.parseDouble(radicandoPositivo), (1/Double.parseDouble(radical))) *-1;//12
        }
        else{//13
            result = Math.pow(Double.parseDouble(radicando), (1/Double.parseDouble(radical)));//14
        }

        setMemory(String.valueOf(result));//15

        return result;//16

    }//17

    @Override
    public double root(String radical) throws RuntimeException {
        double result = 0;//1
        if(!isNumeric(radical)){//2
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//3
        }
        else if(Double.parseDouble(radical) == 0){//4
            throw new NumberFormatException("El radical es igual a 0");//5
        }
        else if(Double.parseDouble(getMemory()) < 0 && Double.parseDouble(radical) > 0 ){//6
            throw new NumberFormatException("El radicando es negativo o radical igual a 0");//7
        }

        if (Double.parseDouble(getMemory()) < 0 && Double.parseDouble(radical) < 0 ){//9 y 10
            String radicandoPositivo = getMemory().replace("-","");//11
            result = Math.pow(Double.parseDouble(radicandoPositivo), (1/Double.parseDouble(radical))) *-1;//13
        }
        else{
            result = Math.pow(Double.parseDouble(getMemory()), (1/Double.parseDouble(radical)));//14
        }

        setMemory(String.valueOf(result));//15
        return result;//16
    }//17

    //cambiar complejidad ciclo
    @Override
    public long factorial() throws RuntimeException {
        if(Pattern.matches("^[1-9]+.0*+[0-9]+$", getMemory())){//1
            throw new NumberFormatException("El valor pasado es un numero real y no puede ser aplicado el factorial de dicho numero");//2
        }
        else if(getMemory().contains("-")){//3
            throw new NumberFormatException("El valor pasado es un valor negativo y por lo tanto no puede ser aplicado por el factorial");//4
        }

        long result = 1;//5
        long valueOfNFactorialInDouble = (int) Double.parseDouble(this.getMemory());//6

        for (int i = 1; i <= valueOfNFactorialInDouble; i++){//7 y 8
            result = result * i;//9
        }
        setMemory(String.valueOf(result));//10
        return result;//11
    }//12

    //cambiar complejidad ciclo
    @Override
    public long factorial(String a) throws RuntimeException {
        if(!isNumeric(a)){//1 y 2
            throw new NumberFormatException("El valor enviado por parametro no es un numero");//3
        }
        else if(Pattern.matches("^[1-9]+.0*+[0-9]+$", a)){//4
            throw new NumberFormatException("El valor pasado es un numero real y no puede ser aplicado el factorial de dicho numero");//5
        }
        else if(a.contains("-")){//6
            throw new NumberFormatException("El valor pasado es un valor negativo y por lo tanto no puede ser aplicado por el factorial");//7
        }

        long result = 1;//8

        long valueOfNFactorialInDouble = (int) Double.parseDouble(a);//9

        for (int i = 1; i <= valueOfNFactorialInDouble; i++){//10 y 11
            result = result * i;//12
        }
        setMemory(String.valueOf(result));//13
        return result;//14
    }//15





}
