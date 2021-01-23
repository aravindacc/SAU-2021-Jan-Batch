import java.util.Scanner;
import java.math.*;

public class ArithmeticOperation
{
  static float division(int number1, int number2) throws ArithmeticException
  { 
    if(number2==0){
        throw new ArithmeticException("Division by Zero");
    }
    else{
        return (float)(number1/number2);
    }
  }
  static void bigdecimal(BigDecimal a, BigDecimal b) throws ArithmeticException{
    int scale=5;
    boolean set=true;
    if(set){
        BigDecimal ans=a.divide(b,scale,RoundingMode.DOWN);
        System.out.println("Answer: "+ans);
    }
    else{
        BigDecimal c=a.divide(b);
        throw new ArithmeticException("No precision and mode.");
    }
  }
  public static void main(String args[])
  {
    int number1,number2;
    Scanner scanner=new Scanner(System.in);
    System.out.print("Enter Dividend:");
    number1=scanner.nextInt();
    System.out.print("Enter Divisor:");
    number2=scanner.nextInt();
    BigDecimal a = new BigDecimal(1); 
    BigDecimal b = new BigDecimal(6);
    try
    {
      float ans = division(number1,number2);
      System.out.println("Answer: "+ans);
    }
    catch(ArithmeticException e)
    {
      System.out.println("caught: " + e);
    }
    try{
        bigdecimal(a,b);
    }
    catch(ArithmeticException e){
        System.out.println("caught: "+e);
        
    }
  }
}