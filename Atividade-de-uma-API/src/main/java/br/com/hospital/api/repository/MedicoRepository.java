package br.com.hospital.api.repository;

import br.com.hospital.api.medicos.Especialidade;
import br.com.hospital.api.medicos.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    Medico findAllByEspecialidade(Especialidade especialidade);
}
