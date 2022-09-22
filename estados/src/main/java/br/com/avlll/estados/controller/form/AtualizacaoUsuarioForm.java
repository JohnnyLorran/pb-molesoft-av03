package br.com.avlll.estados.controller.form;

import br.com.avlll.estados.model.Usuario;
import br.com.avlll.estados.respository.UsuarioRepository;

public class AtualizacaoUsuarioForm {
    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
        return new Usuario();
    }
}
