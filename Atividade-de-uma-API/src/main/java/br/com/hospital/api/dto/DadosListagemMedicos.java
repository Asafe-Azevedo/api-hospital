package br.com.hospital.api.dto;

import br.com.hospital.api.endereco.Endereco;
import br.com.hospital.api.medicos.Especialidade;
import br.com.hospital.api.medicos.Medico;

public record DadosListagemMedicos(Long id, String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {

    public DadosListagemMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
