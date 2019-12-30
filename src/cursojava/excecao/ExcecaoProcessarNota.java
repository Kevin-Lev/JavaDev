package cursojava.excecao;

public class ExcecaoProcessarNota extends Exception {

    public ExcecaoProcessarNota(){
        super("Vish, um erro no processamento do arquivo ao processar nota do aluno! ");
    }

}