package br.com.hospital.api.controller;

import br.com.hospital.api.dto.DadosAtualizacao;
import br.com.hospital.api.dto.DadosCadastroMedicos;
import br.com.hospital.api.dto.DadosDetalhados;
import br.com.hospital.api.dto.DadosListagemMedicos;
import br.com.hospital.api.medicos.*;
import br.com.hospital.api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public DadosCadastroMedicos cadastrar(@RequestBody @Valid DadosCadastroMedicos dados){
        repository.save(new Medico(dados));

        return dados;
    }
    @GetMapping
    public Page<DadosListagemMedicos> listar(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacao medicos){
        var medico = repository.getReferenceById(medicos.id());
        medico.atualizarInfo(medicos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

    @GetMapping("/{id}")
    public DadosDetalhados buscaPorId(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return new DadosDetalhados(medico);
    }

    @GetMapping("/{especialidade}")
    public Page<DadosDetalhados> listaPorEspecialidade(@PathVariable Especialidade especialidade){
        Medico medico = repository.findAllByEspecialidade(especialidade);
        return (Page<DadosDetalhados>) ResponseEntity.ok();
    }

}
