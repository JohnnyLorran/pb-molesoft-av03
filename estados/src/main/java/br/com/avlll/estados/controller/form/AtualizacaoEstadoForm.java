package br.com.avlll.estados.controller.form;

import br.com.avlll.estados.model.Estado;
import br.com.avlll.estados.model.Regiao;
import br.com.avlll.estados.respository.EstadoRepository;
import br.com.avlll.estados.utils.funcoes.VerificaRegiao;

import java.math.BigDecimal;

public class AtualizacaoEstadoForm {

    private String nome;

    private Regiao regiao;

    private long populacao;

    private String capital;

    private BigDecimal area;

    public Estado atualizar(Long id, EstadoRepository estadoRepository) {
        Estado estado = estadoRepository.getReferenceById(id);

        if(this.nome != null){
            estado.setNome(this.nome);
        }

        VerificaRegiao verificaRegiao = new VerificaRegiao();
        if(verificaRegiao.validaRegiao(this.regiao)){
            estado.setRegiao(this.regiao);
        }

        if(this.populacao > 0){
            estado.setPopulacao(this.populacao);
        }

        if(this.capital != null){
            estado.setCapital(this.capital);
        }

        if (this.area != null){
            estado.setArea(this.area);
        }

        return estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }
}
