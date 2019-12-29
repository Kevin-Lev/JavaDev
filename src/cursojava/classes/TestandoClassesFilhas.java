package cursojava.classes;

public class TestandoClassesFilhas {

    public static void main(String[] args) {
        
        Aluno aluno = new Aluno();
        aluno.setNome("Alex JDev - Treinamento");
        aluno.setIdade(20);

        Diretor diretor = new Diretor();
        diretor.setRegistroGeral("registro");
        diretor.setNome("Akira");

        Secretario secretario = new Secretario();
        secretario.setIdade(33);
        secretario.setNome("nhe");

        System.out.println(aluno.pessoaMaiorIdade());
        System.out.println(secretario.pessoaMaiorIdade());
        secretario.pessoaMaiorIdade();

        System.out.println("Salário Alu igual a = " + aluno.salario());
        System.out.println("Salário Dir igual a = " + diretor.salario());
        System.out.println("Salário Secre igual a = " + secretario.salario());

        // Pessoa pessoa = new Aluno();

        // pessoa = secretario;

        // pessoa.get

        // System.out.println(diretor.toString());


        teste(aluno);
        teste(diretor);
        teste(secretario);

    }

    public static void teste(Pessoa pessoa) {
        System.out.println("Essa pessoa é demais = " + pessoa.getNome() + " e o salário é de " + pessoa.salario());
    }

}