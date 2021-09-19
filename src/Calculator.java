public class Calculator<memory> implements CalculatorInterface {
    private String memory = null;



    public String getMemory(){
         return memory;
    }

    public void setMemory(String Memory){
        this.memory = Memory;
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
    public double add(String a) {
        double result = Double.valueOf(getMemory()) + Double.valueOf(a);
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double add(String a, String b) {
        double result =  Double.valueOf(a) + Double.valueOf(b) ;
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double substract(String a) {
        double result = Double.valueOf(getMemory()) - Double.valueOf(a);
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double substract(String a, String b) {
        double result =  Double.valueOf(a) - Double.valueOf(b) ;
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double multiply(String a) {
        double result = Double.valueOf(getMemory()) * Double.valueOf(a);
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double multiply(String a, String b) {
        double result =  Double.valueOf(a) * Double.valueOf(b) ;
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double divide(String a) {
        double result = Double.valueOf(getMemory()) / Double.valueOf(a);
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double divide(String a, String b) {
        double result =  Double.valueOf(a) / Double.valueOf(b) ;
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double pow(String base, String exponent) {
        double result = Math.pow(Double.valueOf(base), Double.valueOf(exponent));
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double squareRoot(String a, String b) {
        double result = Math.sqrt(Double.valueOf(a), Double.valueOf(b));
        this.setMemory(String.valueOf(result));
        return result;
    }

    @Override
    public double squareRoot(String a) {
        double result = Math.pow( Double.valueOf(getMemory()), Double.valueOf(a));
        this.setMemory(String.valueOf(result));
        return result;
    }


}
