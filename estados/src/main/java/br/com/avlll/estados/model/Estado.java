package br.com.avlll.estados.model;


import javax.persistence.*;

@Entity
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Regiao regiao;
    private long populacao;
    private String capital;
    private long area;

}
