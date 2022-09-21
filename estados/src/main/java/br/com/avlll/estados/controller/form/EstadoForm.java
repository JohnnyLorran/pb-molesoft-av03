package br.com.avlll.estados.controller.form;


import br.com.avlll.estados.model.Estado;
import br.com.avlll.estados.model.Regiao;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class EstadoForm {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    private Regiao regiao;

    @NotNull
    private long populacao;

    @NotNull
    @NotEmpty
    private String capital;

    @NotNull(message = "não pode ser nulo")
    private BigDecimal area;

    public Estado converter(){
        return new Estado(nome,regiao,populacao,capital,area);
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
