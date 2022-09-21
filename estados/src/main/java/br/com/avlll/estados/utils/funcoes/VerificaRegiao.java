package br.com.avlll.estados.utils.funcoes;


import br.com.avlll.estados.model.Regiao;

public class VerificaRegiao {

    public boolean validaRegiao(Regiao r){
        Regiao[] regiao = Regiao.values();
        for (Regiao reg: regiao) {
            if(reg.equals(r)){
                return true;
            }
        }
    return false;
    }


}
