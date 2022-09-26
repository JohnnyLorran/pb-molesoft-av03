package br.com.avlll.estados.controller;

import br.com.avlll.estados.controller.dto.UsuarioDto;
import br.com.avlll.estados.controller.form.AtualizacaoUsuarioForm;
import br.com.avlll.estados.controller.form.UsuarioForm;
import br.com.avlll.estados.model.Usuario;
import br.com.avlll.estados.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder){
        Usuario usuario = usuarioForm.converter();
        Optional<Usuario> usuarioCheck = usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioCheck.isEmpty()){
            System.out.println(usuario.getSenha());
            usuarioRepository.save(usuario);
            URI uri = uriBuilder.path("/api/v1/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
            return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoUsuarioForm atualizacaoUsuarioForm){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isPresent()){
            Usuario usuario = atualizacaoUsuarioForm.atualizar(id, usuarioRepository);
            return ResponseEntity.ok(new UsuarioDto(usuario));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<UsuarioDto> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll(Sort.by("id").ascending());
        return UsuarioDto.converter(usuarios);
    }

}
