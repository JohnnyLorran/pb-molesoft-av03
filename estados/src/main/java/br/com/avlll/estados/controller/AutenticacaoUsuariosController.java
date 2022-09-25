package br.com.avlll.estados.controller;

import br.com.avlll.estados.controller.dto.TokenDto;
import br.com.avlll.estados.controller.form.UsuarioLoginForm;
import br.com.avlll.estados.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/autenticacao")
public class AutenticacaoUsuariosController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid UsuarioLoginForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token,"Bearer "));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }

    }

}
