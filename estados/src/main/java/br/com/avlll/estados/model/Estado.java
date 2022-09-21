package br.com.avlll.estados.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ESTADOS")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Regiao regiao;
    private long populacao;
    private String capital;
    private BigDecimal area;

    public Estado() {
    }

    public Estado(String nome, Regiao regiao, long populacao, String capital, BigDecimal area){}

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

    public BigDecimal getArea() {return area;}

    public void setArea(BigDecimal area) {this.area = area;}
}
