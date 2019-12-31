package cursojava.executavel;

// import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ArrayVetor {

    public static void main(String[] args) {
        
        Aluno aluno = new Aluno();
        aluno.setNome("Kevin");
        aluno.setNomeEscola("JDev Treinamento");
        
        Disciplina disciplina = new Disciplina();
        disciplina.setDisciplina("Curso de Java");
        
        Disciplina disciplina2 = new Disciplina();
        disciplina.setDisciplina("Lógica de Programação");

        double notas[] = {88, 87, 90, 67};
        double notasLogica[] = {68, 87, 150, 63};
        
        double maiorNota = 0.0;
        double menorNota = 0.0;

        disciplina.setNota(notas);
        disciplina2.setNota(notasLogica);
        
        aluno.getDisciplinas().add(disciplina);
        aluno.getDisciplinas().add(disciplina2);
        
        System.out.println("Nome do aluno: " + aluno.getNome() + " inscrito no curso: " + aluno.getNomeEscola());
        System.out.println("--------------Disciplinas do aluno--------------");
        
        for(Disciplina disc: aluno.getDisciplinas()){
            System.out.println("Disciplina: " + disc.getDisciplina());
            System.out.println("As notas da disciplina são: ");

            for (int i = 0; i < disc.getNota().length; i++) {

                if (i == 0){
                    maiorNota = disc.getNota()[i];
                    menorNota = disc.getNota()[i];
                }
                else{
                    if (disc.getNota()[i] > maiorNota) {
                        maiorNota = disc.getNota()[i];
                    }
                    if (disc.getNota()[i] < menorNota) {
                        menorNota = disc.getNota()[i];
                    }
                }

                System.out.println("Nota " + (i + 1) + " é igual = " + disc.getNota()[i]);
            }
        }

        System.out.println("Maior nota do aluno: " + maiorNota);
        System.out.println("Menor nota do aluno: " + menorNota);

        System.out.println("---------------------------------------------");

        Aluno arrayAlunos[] = new Aluno[1];

        arrayAlunos[0] = aluno;

        for (int i = 0; i < arrayAlunos.length; i++){
            System.out.println("Nome do aluno é: " + arrayAlunos[i].getNome());
        
            for (Disciplina disc: arrayAlunos[i].getDisciplinas()) {
                System.out.println("Nome da disciplina: " + disc.getDisciplina());

                for (int j = 0; j < disc.getNota().length; j++) {
                    System.out.println("Nota " + (j+1) + ": " + disc.getNota()[j]);
                }
            }
        }
    }

}