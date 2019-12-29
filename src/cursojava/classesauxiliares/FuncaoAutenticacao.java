package cursojava.classesauxiliares;

import cursojava.classes.Secretario;
import cursojava.interfaces.PermitirAcesso;

// Realmente e somente receber alguém que tenha o contrato da interface de PermitirAcesso e chamar o autenticado

public class FuncaoAutenticacao {

    private PermitirAcesso permitirAcesso;

    public boolean autenticar() {
        return permitirAcesso.autenticar();
    }

    public FuncaoAutenticacao(PermitirAcesso acesso) {
        this.permitirAcesso = acesso;
    }

}