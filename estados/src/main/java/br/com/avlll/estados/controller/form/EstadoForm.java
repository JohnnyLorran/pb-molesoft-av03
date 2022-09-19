package br.com.avlll.estados.controller.form;


import br.com.avlll.estados.model.Regiao;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EstadoForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private Regiao regiao;
    @NotNull @NotEmpty
    private long populacao;
    @NotNull @NotEmpty
    private String capital;
    @NotNull @NotEmpty
    private long area;


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

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }
}
