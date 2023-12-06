package br.com.hospital.api.dto;

import br.com.hospital.api.endereco.DadosEndereco;
import br.com.hospital.api.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacao(

        @NotNull
        Long id,
        String nome,
        String email,
        DadosEndereco endereco) {
}
