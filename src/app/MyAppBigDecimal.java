package app;

import java.math.BigDecimal;

public class MyAppBigDecimal {

    /**
     * @param args
     */
    // public static void main(String[] args) {
    //     System.out.println(2.00 - 1.1);
    //     System.out.println(2.00 - 1.2);
    //     System.out.println(2.00 - 1.3);
    //     System.out.println(2.00 - 1.4);
    //     System.out.println(2.00 - 1.5);
    //     System.out.println(2.00 - 1.6);
    //     System.out.println(2.00 - 1.7);
    //     System.out.println(2.00 - 1.8);
    //     System.out.println(2.00 - 1.9);
    //     System.out.println(2.00 - 2);

    // }

    public static void main(String[] args) {
         System.out.println("Subtrai");
         System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1")));
 
         System.out.println("");
         System.out.println("Soma");
         System.out.println(new BigDecimal("2.00").add(new BigDecimal("1.2")));
 
         System.out.println("");
         System.out.println("Compara");
         System.out.println(new BigDecimal("2.00").compareTo(new BigDecimal("1.3")));
 
         System.out.println("");
         System.out.println("Divide");
         System.out.println(new BigDecimal("2.00").divide(new BigDecimal("2.00")));
 
         System.out.println("");
         System.out.println("Máximo");
         System.out.println(new BigDecimal("2.00").max(new BigDecimal("11.5")));
 
         System.out.println("");
         System.out.println("Mínimo");
         System.out.println(new BigDecimal("2.00").min(new BigDecimal("1.6")));
 
         System.out.println("");
         System.out.println("Potência");
         System.out.println(new BigDecimal("2.00").pow(2));
 
         System.out.println("");
         System.out.println("Multiplica");
         System.out.println(new BigDecimal("2.00").multiply(new BigDecimal("1.8")));
 
     }

}