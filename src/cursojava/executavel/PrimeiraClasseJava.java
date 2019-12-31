package cursojava.executavel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.classes.Secretario;
import cursojava.classesauxiliares.FuncaoAutenticacao;
import cursojava.constantes.StatusAluno;
import cursojava.excecao.ExcecaoProcessarNota;
import cursojava.interfaces.PermitirAcesso;


public class PrimeiraClasseJava {
    
    public static void main(String[] args) throws ExcecaoProcessarNota {
        
        try {
            
            // File fil = new File("arquivo.txt");
            // Scanner scanner = new Scanner(fil);

            String login = JOptionPane.showInputDialog(null, "Informe o login");
            String senha = JOptionPane.showInputDialog(null, "Informe a senha");

            // PermitirAcesso permitirAcesso = new Secretario(login, senha);
            PermitirAcesso permitirAcesso = new Diretor(login, senha);

            if (new FuncaoAutenticacao(permitirAcesso).autenticar()) { // vou travar o contrato para autorizar somente quem realmente tem o contrato 100% legítimo.

            List<Aluno> alunos = new ArrayList<Aluno>();
            // List<Aluno> alunos = null; teste para try catch

            // É uma lista que dentro dela temos uma chave que identifica uma sequência de valores.
            HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();


            for (int qnt = 0; qnt <= 1; qnt++){
            
                // aluno3 = new Aluno(); //é uma instância de classe (criação de objeto)
                //aluno3 é uma referência para o objeto aluno

                String nome = JOptionPane.showInputDialog(null, "Qual o nome do aluno " + qnt + "?");
                String idade = JOptionPane.showInputDialog(null, "Qual a idade?");
                // String dataNascimento = JOptionPane.showInputDialog(null, "Data de Nascimento?");
                // String rg = JOptionPane.showInputDialog(null, "Registro Geral?");
                // String cpf = JOptionPane.showInputDialog(null, "CPF?");
                // String mae = JOptionPane.showInputDialog(null, "Nome da mãe?");
                // String pai = JOptionPane.showInputDialog(null, "Nome do pai?");
                // String matricula = JOptionPane.showInputDialog(null, "Data da matricula?");
                // String serie = JOptionPane.showInputDialog(null, "Qual a série?");
                // String escola = JOptionPane.showInputDialog(null, "Nome da escola?");

                

                Aluno aluno3 = new Aluno();

                aluno3.setNome(nome);
                aluno3.setIdade(Integer.parseInt(idade));
                // aluno3.setDataNascimento(dataNascimento);
                // aluno3.setNomeEscola(escola);

                for (int pos = 0; pos < 1; pos ++) {
                    String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos);
                    String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + pos);

                    Disciplina disciplina = new Disciplina();
                    disciplina.setDisciplina(nomeDisciplina);
                    // disciplina.setNota(Double.parseDouble(notaDisciplina));

                    aluno3.getDisciplinas().add(disciplina);
                }
                
                int removerDisciplina = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina");

                if (removerDisciplina == 0) {

                    int continuarRemover = 0;
                    int posicao = 1;

                    while(continuarRemover == 0) {
                        String disciplinaRemover = JOptionPane.showInputDialog(null, "Qual disciplina 1, 2 , 3 ou 4?");
            
                        aluno3.getDisciplinas().remove(Integer.parseInt(disciplinaRemover) - posicao);
                        posicao++;
                        System.out.println(aluno3.getDisciplinas());
                        continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
                    }

                }
            
                alunos.add(aluno3);
            }

            // chaves inicializads para não dar erro no for 
            maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
            maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
            maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

            for (Aluno aluno: alunos) {
                if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
                    maps.get(StatusAluno.APROVADO).add(aluno);
                }
                else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                    maps.get(StatusAluno.RECUPERACAO).add(aluno);
                }
                else {
                    maps.get(StatusAluno.REPROVADO).add(aluno);
                }

            }

            System.out.println("-------------Lista dos aprovados-------------");
            for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
                System.out.println(aluno.getAlunoAprovado2() + " com média " + aluno.getMediaNota());
            }
            System.out.println("-------------Lista dos que estão em recuperação-------------");
            for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
                System.out.println(aluno.getAlunoAprovado2() + " com média " + aluno.getMediaNota());
            }
            System.out.println("-------------Lista dos reprovados-------------");
            for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
                System.out.println(aluno.getAlunoAprovado2() + " com média " + aluno.getMediaNota());
            }

            // for (int pos = 0; pos < alunos.size(); pos++) {
                
            //     Aluno aluno = alunos.get(pos); 

            //     if (aluno.getNome().equalsIgnoreCase("Kevin")) {
            //         Aluno trocar = new Aluno();
            //         trocar.setNome("Aluno foi trocado");

            //         Disciplina disciplina = new Disciplina();
            //         disciplina.setDisciplina("Matemática");
            //         disciplina.setNota(96);

            //         trocar.getDisciplinas().add(disciplina);

            //         alunos.set(pos, trocar);
            //         aluno = alunos.get(pos);
            //         // aluno = trocar;
            //     }
                
            //     System.out.println("Aluno = " + aluno.getNome());
            //     System.out.println("Média do aluno = " + aluno.getMediaNota());
            //     System.out.println("Resultado = " + aluno.getAlunoAprovado2());
            //     System.out.println("------------------------------------------");

            //     for (Disciplina disc: aluno.getDisciplinas()) {
            //         System.out.println("Disciplina " + disc.getDisciplina());
            //         System.out.println("Nota: " + disc.getNota());
            //     }
            // }

            // for (Aluno aluno : alunos) {

            //     if (aluno.getNome().equalsIgnoreCase("Kevin")){
            //         alunos.remove(aluno);
            //     }
            //     System.out.println("Média do aluno " + aluno.getNome() + ": " + aluno.getMediaNota());
            //     System.out.println("Resultado = " + (aluno.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
            //     System.out.println("----------------------------------------------------------");
            //     // break;
            // }
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorreto(s)");
            }
        }
        catch (NumberFormatException e) {

            StringBuilder saida = new StringBuilder();

            // imprime erro no console
            e.printStackTrace();

            //mensagem de erro ou causa
            System.out.println("Mensagem: " + e.getMessage());

            for (int i = 0; i < e.getStackTrace().length; i++ ){
                saida.append("\nClasse de erro: " + e.getStackTrace()[i].getClassName()); 
                saida.append("\nMétodo de erro: " + e.getStackTrace()[i].getMethodName()); 
                saida.append("\nLinha: " + e.getStackTrace()[i].getLineNumber()); 
                saida.append("\nClass: " + e.getClass().getName()); 
            }

            JOptionPane.showMessageDialog(null, "Erro de conversão de número: " + saida.toString());
        }

        catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Opa, um nullpointerexception " + e.getClass().getName());
        }

        catch(Exception e) {
            e.printStackTrace();
            throw new ExcecaoProcessarNota();
        }

        finally{ //sempre é executado, ocorrendo erros ou não.
            //Finally sempre é usado quando se precisa executar um processo acontecendo erro ou não em um sistema.
            // Normalmente usado para fechar transações em bancos de dados, que deve ser fechada acontecendo erros ou não.
            JOptionPane.showMessageDialog(null, "Obrigado por aprender Java!");
        }

    }
}