package br.com.avlll.estados.controller;

import br.com.avlll.estados.controller.dto.EstadoDto;
import br.com.avlll.estados.controller.form.AtualizacaoEstadoForm;
import br.com.avlll.estados.controller.form.EstadoForm;
import br.com.avlll.estados.model.Estado;
import br.com.avlll.estados.model.Regiao;
import br.com.avlll.estados.respository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/estados")
@CrossOrigin
public class EstadosController {

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm estadoForm, UriComponentsBuilder uriBuilder){
        Estado estado = estadoForm.converter();
        estadoRepository.save(estado);
        URI uri = uriBuilder.path("/api/v1/estados/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).body(new EstadoDto(estado));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EstadoDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoEstadoForm estadoForm){
        Optional<Estado> optionalEstado = estadoRepository.findById(id);
        if(optionalEstado.isPresent()){
            Estado estado = estadoForm.atualizar(id, estadoRepository);
            return ResponseEntity.ok(new EstadoDto(estado));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<EstadoDto> listar(@RequestParam(required = false) Regiao regiao,
                                  @RequestParam(required = false, defaultValue = "regiao") String order) {

        Sort sort = Sort.by(order.toLowerCase(Locale.ROOT)).descending();
        List<Estado> estados;
            if (regiao != null && "regiao".equals(order)) {
                //Condição apenas com região / ordena por nome a-z
                sort = Sort.by("nome").ascending();
                estados = estadoRepository.findByRegiao(regiao, sort);
            } else if (!"".equals(order)) {
                //Condição sem paramêtro nenhum ou com order por area ou populacao/ orderna por região a-z
                if (!"populacao".equals(order) && !"area".equals(order)) {
                    //sem nenhum paramêtro
                    sort = Sort.by(order).ascending();
                }
                estados = estadoRepository.findAll(sort);
            } else {
                //Condição com região e order / orderna pela maior area ou população
                estados = estadoRepository.findByRegiao(regiao, sort);
            }
            return EstadoDto.converter(estados);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<EstadoDto> detalhar(@PathVariable Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        return estado.map(value -> ResponseEntity.ok(new EstadoDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id){
        Optional<Estado> optionalEstado = estadoRepository.findById(id);
        if(optionalEstado.isPresent()) {
            estadoRepository.deleteById(id);
            return  ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
