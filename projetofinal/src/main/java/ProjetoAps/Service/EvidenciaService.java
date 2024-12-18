package ProjetoAps.Service;

import java.util.List;
import java.util.Optional;

public interface EvidenciaService {

    List<Evidencia> listarTodos();
    Optional<Evidencia> buscarPorId(Long id);
    Evidencia salvar(Evidencia evidencia);
    void excluirPorId(Long id);
    Evidencia atualizar(Evidencia evidencia);
}

// Implementação
@Service
public class EvidenciaServiceI implements EvidenciaService {

    private final EvidenciaRepository repository;

    @Autowired
    public EvidenciaServiceI(EvidenciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Evidencia> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Evidencia> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Evidencia salvar(Evidencia evidencia) {
        return repository.save(evidencia);
    }

    @Override
    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Evidencia atualizar(Evidencia evidencia) {
        return repository.save(evidencia);
    }
}