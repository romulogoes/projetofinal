package ProjetoAps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    List<Atividade> findByNomeContaining(String nome);
    List<Atividade> findByCursoId(Long cursoId);
}
