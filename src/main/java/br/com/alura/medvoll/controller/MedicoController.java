package br.com.alura.medvoll.controller;

import br.com.alura.medvoll.endereco.Endereco;
import br.com.alura.medvoll.medico.DadosCadastroMedico;
import br.com.alura.medvoll.medico.Medico;
import br.com.alura.medvoll.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repositorio;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repositorio.save(new Medico(dados));
    }

}
