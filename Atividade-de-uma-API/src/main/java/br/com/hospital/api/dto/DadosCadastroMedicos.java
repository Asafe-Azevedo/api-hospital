package br.com.hospital.api.dto;

import br.com.hospital.api.endereco.DadosEndereco;
import br.com.hospital.api.endereco.Endereco;
import br.com.hospital.api.medicos.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedicos(

        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotBlank
        @Email
        String email,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco
)

        {
}
