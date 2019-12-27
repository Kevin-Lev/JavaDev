package app;

import javax.swing.JOptionPane;

public class App {


    public static void main(String[] args) {

        String nota1 =  JOptionPane.showInputDialog(null, "Insira a nota 1: ");
        String nota2 =  JOptionPane.showInputDialog(null, "Insira a nota 2: ");
        String nota3 =  JOptionPane.showInputDialog(null, "Insira a nota 3: ");
        String nota4 =  JOptionPane.showInputDialog(null, "Insira a nota 4: ");

        double dNota1 = Double.parseDouble(nota1);
        double dNota2 = Double.parseDouble(nota2);
        double dNota3 = Double.parseDouble(nota3);
        double dNota4 = Double.parseDouble(nota4);

        double media = (dNota1 + dNota2 + dNota3 + dNota4) / 4;

        JOptionPane.showMessageDialog(null, "Média do Aluno: " + media);

        if (media >= 50) {
            if (media >= 70) {
                JOptionPane.showMessageDialog(null, "Aluno Aprovado!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Aluno em Recuperação!");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Aluno Reprovado !");
        }


        // String carros = JOptionPane.showInputDialog("Informe a quantidade de carros: ");
        // String pessoas = JOptionPane.showInputDialog("Informe a quantidade de pessoas: ");

        // double carroNumero = Double.parseDouble(carros);
        // double pessoaNumero = Double.parseDouble(pessoas);

        // int divisao = (int) (carroNumero / pessoaNumero);

        // int resto = (int) (carroNumero % pessoaNumero);

        // System.out.println(carros);
        // System.out.println(pessoas);

        // System.out.println("Divisão para pessoas deu: " + divisao);
        
        // int respostaDivisao = JOptionPane.showConfirmDialog(null, "Deseja ver o resultado da divisão?");

        // // System.out.println(resposta);

        // if (respostaDivisao == 0) {
        //     JOptionPane.showMessageDialog(null, "Divisão para pessoas deu: " + divisao + " carros");
        // }

        // int respostaResto = JOptionPane.showConfirmDialog(null, "Deseja ver o resto da divisão?");

        // if (respostaResto == 0) {
        //     JOptionPane.showMessageDialog(null, "O resto da divisão é: " + resto);
        // }

    }
}