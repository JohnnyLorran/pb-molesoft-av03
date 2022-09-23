package br.com.avlll.estados.config.security;


import br.com.avlll.estados.model.Usuario;
import br.com.avlll.estados.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoUsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
        if(usuario.isPresent()){
            return usuario.get();
        }

        throw new UsernameNotFoundException("Dados inválidos, tente novamente !");
    }

}