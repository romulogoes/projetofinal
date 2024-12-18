package ProjetoAps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
        return service.salvar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria existing = service.buscarPorId(id).orElseThrow();
        existing.setNome(categoria.getNome());
        existing.setDescricao(categoria.getDescricao());
        return service.atualizar(existing);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Long id) {
        service.excluirPorId(id);
    }
}
