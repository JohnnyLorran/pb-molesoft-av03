package br.com.avlll.estados.controller.dto;

import br.com.avlll.estados.model.Estado;
import br.com.avlll.estados.model.Regiao;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class EstadoDto {

    private long id;
    private String nome;
    private Regiao regiao;
    private long populacao;
    private String capital;
    private BigDecimal area;


    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.regiao = estado.getRegiao();
        this.populacao = estado.getPopulacao();
        this.capital = estado.getCapital();
        this.area = estado.getArea();
    }

    public static List<EstadoDto> converter(List<Estado> estados) {
        return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

