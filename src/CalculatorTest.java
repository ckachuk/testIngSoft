import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


class CalculatorTest {


    private final Calculator calc = new Calculator("5");


    //TEST DE SUMA

    @Test
    @DisplayName("Test de suma con funcion de un parametro igual a una palabra")
    void addExceptionPalabra(){
        Assertions.assertThrows(NumberFormatException.class,()->calc.add("asd"));
    }

    @Test
    @DisplayName("Test  de la suma con funcion de dos parametros y uno es igual a una palabra")
    void addExceptionPalabraConDosParametros(){
        Assertions.assertThrows(NumberFormatException.class,()->calc.add("asd","6"));
    }

    @ParameterizedTest
    @ValueSource( strings = {"4", "-3"})
    @DisplayName("Test  de la suma con funcion con dos parametros")
    void addTestConDosParametros(String a) {
        Assertions.assertEquals(Double.parseDouble(a) + 2.0 , calc.add(a, "2.0"));
    }

    @ParameterizedTest
    @ValueSource( strings = {"4", "-3"})
    @DisplayName("Test de la suma con funcion de un parametro y memory")
    void addTestConUnParametro(String a) {
        Assertions.assertEquals(Double.parseDouble(a) + Double.parseDouble(calc.getMemory()) , calc.add(a));
    }

    //TEST DE RESTA

    @ParameterizedTest
    @ValueSource( strings = {"4", "-3"})
    @DisplayName("Test de la resta con funcion de dos parametros")
    void substractTestConDosParametros(String a) {
        Assertions.assertEquals(Double.parseDouble(a) - 2.0 , calc.substract(a,"2.0"));
    }

    @ParameterizedTest
    @ValueSource( strings = {"4", "-3"})
    @DisplayName("Test de la resta con funcion de un parametro")
    void substractTestConUnParametro(String a)  {
        Assertions.assertEquals( Double.parseDouble(calc.getMemory()) - Double.parseDouble(a) , calc.substract(a));
    }

    @Test
    @DisplayName("Test de la resta con funcion de un parametro igual a una palabra")
    void substractExceptionPalabra(){
        Assertions.assertThrows(NumberFormatException.class,()->calc.substract("asd"));
    }

    @Test
    @DisplayName("Test de la resta con funcion de dos parametros y uno es igual a una palabra")
    void substractExceptionPalabraConDosParametros(){
        Assertions.assertThrows(NumberFormatException.class,()->calc.substract("asd","6"));
    }

    //TEST DE MULTIPLICACION

    @Test
    @DisplayName("Test de la multiplicacion con funcion de un parametro igual a una palabra")
    void multiplyExceptionPalabra(){
        Assertions.assertThrows(NumberFormatException.class,()->calc.multiply("asd"));
    }

    @Test
    @DisplayName("Test de la multiplicacion con funcion de dos parametros y uno es igual a una palabra")
    void multiplyExceptionPalabraConDosParametros(){
        Assertions.assertThrows(NumberFormatException.class,()->calc.multiply("asd","6"));
    }

    @ParameterizedTest
    @ValueSource( strings = {"4", "-3"})
    @DisplayName("Test del producto con funcion de un a variable y b constante")
    void multiplyTestConDosParametros(String a) {
        Assertions.assertEquals(Double.parseDouble(a) * 2.0 , calc.multiply(a,"2.0"));
    }

    @ParameterizedTest
    @ValueSource( strings = {"4", "-3"})
    @DisplayName("Test del producto de funcion  con a variable y memory constante")
    void multiplyTestConUnParametro(String a)  {
        Assertions.assertEquals( Double.parseDouble(calc.getMemory()) * Double.parseDouble(a) , calc.multiply(a));
    }


    //TEST DE DIVISION

    //FUNCION CON DOS PARAMETROS
    @ParameterizedTest
    @ValueSource( strings = {"4","0"})
    @DisplayName("Test de la division de funcion con dividendo variable y divisor constante")
    void divideTestConDosParametros(String a)  {
        Assertions.assertEquals(Double.parseDouble(a) / 2 , calc.divide(a, "2"));
    }

    @ParameterizedTest
    @ValueSource( strings = {"-4", "-3"})
    @DisplayName("Test de la division de funcion con dividendo variable negativo y divisor constante negativo")
    void divideTestConDosParametrosNegativos(String a)  {
        Assertions.assertEquals(Double.parseDouble(a) / -2 , calc.divide(a, "-2"));
    }

    @ParameterizedTest
    @ValueSource( strings = {"-4", "3"})
    @DisplayName("Test de la division de funcion con dividendo constante y divisor variable")
    void divideTestConDosParametros2(String b)  {
        Assertions.assertEquals(2/ Double.parseDouble(b)  , calc.divide("2", b));
    }


    @Test
    @DisplayName("Test de la division de funcion con un dividendo positivo y divisor cero ")
    void divideTestConCeroComoDivisor() {
        Assertions.assertThrows(NumberFormatException.class, () -> calc.divide("2", "0"));
    }

    //FUNCION CON UN PARAMETRO

    @ParameterizedTest
    @ValueSource( strings = {"4","0"})
    @DisplayName("Test de la division de funcion con dividendo variable y divisor constante")
    void divideTestConUnParametro(String a)  {
        calc.setMemory("2");
        Assertions.assertEquals(Double.parseDouble(a) / 2 , calc.divide(a));
    }

    @ParameterizedTest
    @ValueSource( strings = {"-4", "-3"})
    @DisplayName("Test de la division de funcion con dividendo variable negativo y divisor constante negativo")
    void divideTestConUnParametrosNegativo(String a)  {
        calc.setMemory("-2");
        Assertions.assertEquals(Double.parseDouble(a) / -2 , calc.divide(a));
    }

    @ParameterizedTest
    @ValueSource( strings = {"-4", "3"})
    @DisplayName("Test de la division de funcion con dividendo constante y divisor variable")
    void divideTestConUnParametro2(String b)  {
        calc.setMemory(b);
        Assertions.assertEquals(2/ Double.parseDouble(b)  , calc.divide("2", b));
    }


    @Test
    @DisplayName("Test de la division de funcion con un dividendo positivo y divisor cero ")
    void divideTestUnParametroConCeroComoDivisor() {
        calc.setMemory("0");
        Assertions.assertThrows(NumberFormatException.class, () -> calc.divide("2"));
    }



    //TEST DE RAIZ

    //FUNCION CON DOS PARAMETROS

    @Test
    @DisplayName("Test de funcion raiz con dos parametros de radicando que es una palabra y un radical positivo ")
    void rootTestFuncDosParametrosPalabra() {
        Assertions.assertThrows(NumberFormatException.class, () -> calc.root("asd", "2"));
    }


    @Test
    @DisplayName("Test de funcion raiz con dos parametros de radicando variable y radical positivo")
    void rootTestConParametrosPositivos(){
        Assertions.assertEquals(5,calc.root("25","2"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3", "asd"})
    @DisplayName("Test excepcion de funcion raiz con dos parametros de radicando negativo y palabra")
    void rootTestExcepcionsFuncDosParametros(String a) {
        Assertions.assertThrows(NumberFormatException.class, () -> calc.root(a, "3"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "asd"})
    @DisplayName("Test excepcion de funcion raiz con dos parametros de radical cero y palabra")
    void rootTestExcepcionsRadicalFuncDosParametros(String a) {
        Assertions.assertThrows(NumberFormatException.class, () -> calc.root("2", a));
    }

    @ParameterizedTest
    @CsvSource(value = {"5,0.5848035476425733", "-5,-0.5848035476425733"})
    @DisplayName("Test excepcion de funcion raiz con dos parametros de radicando positivo y negativo y radical negativo impar")
    void rootTestExcepcionsRadicalNegativoFuncDosParametro(String radicando, Double expected ) {
        Assertions.assertEquals(expected, calc.root(radicando, "-3"));
    }

    //FUNCION CON UN PARAMETRO

    @Test
    @DisplayName("Test excepcion de funcion raiz con un parametro de un radicando que es una palabra y un radical positivo ")
    void rootTestUnParametroPalabra() {
        Assertions.assertThrows(NumberFormatException.class, () -> calc.root("asd"));
    }


    @Test
    @DisplayName("Test de funcion raiz con un parametro de radicando variable y radical positivo")
    void rootTestDeUnParametroPositivo(){
        calc.setMemory("25");
        Assertions.assertEquals(5,calc.root("2"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3", "asd"})
    @DisplayName("Test excepcion de funcion raiz con un parametro de radicando negativo y palabra")
    void rootTestExcepcionsRadicandoFuncUnParametro(String a) {
        calc.setMemory(a);
        Assertions.assertThrows(NumberFormatException.class, () -> calc.root( "3"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "asd"})
    @DisplayName("Test excepcion de funcion raiz con un parametro de radical cero y palabra")
    void rootTestExcepcionsRadicalFuncUnParametro(String a) {
        calc.setMemory("2");
        Assertions.assertThrows(NumberFormatException.class, () -> calc.root(a));
    }

    @ParameterizedTest
    @CsvSource(value = {"5,0.5848035476425733", "-5,-0.5848035476425733"})
    @DisplayName("Test excepcion de funcion raiz con un parametro de radicando positivo y negativo y radical negativo impar")
    void rootTestExcepcionsRadicalNegativoFuncUnParametro(String radicando, Double expected ) {
        calc.setMemory(radicando);
        Assertions.assertEquals(expected, calc.root("-3"));
    }


    //TEST DE FACTORIAL

    @ParameterizedTest
    @CsvSource(value = {"4,24", "0,1"})
    @DisplayName("Test de funcion factorial con parametro")
    void factorialTestConParametro(String a, String b)  {
        Assertions.assertEquals(Long.valueOf(b), calc.factorial(a));

    }

    @ParameterizedTest
    @CsvSource (value = {"4,24",  "0,1"})
    @DisplayName("Test de funcion factorial sin parametros (utiliza memory)")
    void factorialTestSinParametro(String a, String b) {
        calc.setMemory(a);
        Assertions.assertEquals(Long.valueOf(b), calc.factorial());

    }

    @ParameterizedTest
    @ValueSource( strings = {"asd", "6.4","-5"})
    @DisplayName("Test excepcion de funcion factorial con parametros ")
    void factorialExceptions(String a){
        Assertions.assertThrows(NumberFormatException.class,()->calc.factorial(a));
    }

    @ParameterizedTest
    @ValueSource( strings = {"-5","6.4"})
    @DisplayName("Test excepcion de funcion factorial sin parametros ")
    void factorialExceptionsConDosParametros(String a){
        calc.setMemory(a);
        Assertions.assertThrows(NumberFormatException.class,()->calc.factorial());
    }


    //TEST DE POTENCIA

    @ParameterizedTest
    @ValueSource( strings = {"4","0"})
    @DisplayName("Test de la funcion potencia con base variable y exponente constante")
    void powBaseTest(String base)  {
        Assertions.assertEquals(Math.pow(Double.parseDouble(base), 2) , calc.pow(base, "2"));
    }


    @ParameterizedTest
    @ValueSource( strings = {"-4", "0"})
    @DisplayName("Test de la funcion potencia con base constante y exponente variable")
    void powExponentTest(String exponent)  {
        Assertions.assertEquals(Math.pow(2, Double.parseDouble(exponent)), calc.pow("2.0",exponent));
    }


    @Test
    @DisplayName("Test de la funcion potencia con base constante y exponente variable")
    void powTestConPalabraPasadaPorParametro() {
        Assertions.assertThrows(NumberFormatException.class, () -> calc.pow("asd", "0"));
    }





}