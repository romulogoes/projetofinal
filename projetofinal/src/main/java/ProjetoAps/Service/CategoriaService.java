package ProjetoAps.Service;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> listarTodos();
    Optional<Categoria> buscarPorId(Long id);
    Categoria salvar(Categoria categoria);
    void excluirPorId(Long id);
    Categoria atualizar(Categoria categoria);
}

// Implementação
@Service
public class CategoriaServiceI implements CategoriaService {

    private final CategoriaRepository repository;

    @Autowired
    public CategoriaServiceI(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Categoria atualizar(Categoria categoria) {
        return repository.save(categoria);
    }
}
