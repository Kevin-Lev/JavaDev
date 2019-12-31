package cursojava.executavel;

public class Matriz {


    public static void main(String[] args) {
        
        int notas[][] = new int[2][3];

        notas[0][0] = 80;
        notas[0][1] = 90;
        notas[0][2] = 70;

        notas[1][0] = 40;
        notas[1][1] = 60;
        notas[1][2] = 30;

        System.out.println(notas);

        System.out.println("Matriz de Notas: ");
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                System.out.println(notas[i][j]);
            }
        }

    }

}