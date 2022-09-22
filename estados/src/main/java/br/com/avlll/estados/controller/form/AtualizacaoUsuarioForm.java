package br.com.avlll.estados.controller.form;

import br.com.avlll.estados.model.Usuario;
import br.com.avlll.estados.respository.UsuarioRepository;


public class AtualizacaoUsuarioForm {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
