package br.com.avlll.estados.controller.form;

import br.com.avlll.estados.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {

    @NotNull @NotEmpty
    private String nome;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull @NotEmpty
    private String senha;

    public Usuario converter() {
        return new Usuario(nome,email,new BCryptPasswordEncoder().encode(senha));
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
