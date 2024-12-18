package ProjetoAps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvidenciaRepository extends JpaRepository<Evidencia, Long> {
    List<Evidencia> findByAtividadeId(Long atividadeId);
}
