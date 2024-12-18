package ProjetoAps.Service;

import java.util.List;
import java.util.Optional;

public interface AtividadeService {

    List<Atividade> listarTodos();
    Optional<Atividade> buscarPorId(Long id);
    Atividade salvar(Atividade atividade);
    void excluirPorId(Long id);
    Atividade atualizar(Atividade atividade);
}

// Implementação
@Service
public class AtividadeServiceImpl implements AtividadeService {

    private final AtividadeRepository repository;

    @Autowired
    public AtividadeServiceImpl(AtividadeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Atividade> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Atividade> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Atividade salvar(Atividade atividade) {
        return repository.save(atividade);
    }

    @Override
    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Atividade atualizar(Atividade atividade) {
        return repository.save(atividade);
    }
}