package br.com.hospital.api.medicos;

import br.com.hospital.api.dto.DadosAtualizacao;
import br.com.hospital.api.dto.DadosCadastroMedicos;
import br.com.hospital.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedicos dadosCadastroMedicos){
        this.ativo = true;
        this.nome = dadosCadastroMedicos.nome();
        this.email = dadosCadastroMedicos.email();
        this.crm = dadosCadastroMedicos.crm();
        this.especialidade = dadosCadastroMedicos.especialidade();
        this.endereco = new Endereco(dadosCadastroMedicos.endereco());
    }

    public void atualizarInfo(DadosAtualizacao medicos) {
        if (medicos.nome() != null) {
            this.nome = medicos.nome();
        }
        if (medicos.email() != null) {
            this.email = medicos.email();
        }
        if (medicos.endereco() != null) {
            this.endereco.atualizarInformacoes(medicos.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }




}
