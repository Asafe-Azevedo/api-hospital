package br.com.hospital.api.dto;

import br.com.hospital.api.endereco.Endereco;
import br.com.hospital.api.medicos.Especialidade;
import br.com.hospital.api.medicos.Medico;

public record DadosDetalhados(Long id, String email, String crm, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhados(Medico medico) {
        this(medico.getId(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }



}
