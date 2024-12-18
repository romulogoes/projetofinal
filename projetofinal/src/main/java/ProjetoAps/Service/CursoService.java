package ProjetoAps.Service;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> listarTodos();
    Optional<Curso> buscarPorId(Long id);
    Curso salvar(Curso curso);
    void excluirPorId(Long id);
    Curso atualizar(Curso curso);
}

// Implementação
@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;

    @Autowired
    public CursoServiceImpl(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Curso> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Curso salvar(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Curso atualizar(Curso curso) {
        return repository.save(curso);
    }
}
