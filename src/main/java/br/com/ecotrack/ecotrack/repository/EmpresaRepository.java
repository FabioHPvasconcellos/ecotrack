package br.com.ecotrack.ecotrack.repository;

import br.com.ecotrack.ecotrack.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {    // Aqui o Spring já te dá o .save(), .findAll(), .deleteById(), etc.
}