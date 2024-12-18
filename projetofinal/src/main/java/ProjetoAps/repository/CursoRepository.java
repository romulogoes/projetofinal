package ProjetoAps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNomeContaining(String nome);
    Optional<Curso> findByNome(String nome);
}
