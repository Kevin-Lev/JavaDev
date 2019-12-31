package cursojava.executavel;

import java.util.Arrays;
import java.util.List;

public class SplitArray {

    public static void main(String[] args) {
        
        String texto = "alex, curso Java, 80, 70, 90, 89";

        String valoresArray[] = texto.split(",");

        // System.out.println(valoresArray[0]);
        // System.out.println(valoresArray[1]);
        // System.out.println(valoresArray[2]);
        // System.out.println(valoresArray[3]);
        // System.out.println(valoresArray[4]);
        // System.out.println(valoresArray[5]);

        List<String> list = Arrays.asList(valoresArray); //Converte array para lista

        for (String valorString: list) {
            System.out.println(valorString);
        }

        String conversaoArray[] = list.toArray(new String[6]);

        System.out.println(conversaoArray[0]);

    }

}