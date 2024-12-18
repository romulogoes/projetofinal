package ProjetoAps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService service;

    @Autowired
    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Curso> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    public Curso salvar(@RequestBody Curso curso) {
        return service.salvar(curso);
    }

    @PutMapping("/{id}")
    public Curso atualizar(@PathVariable Long id, @RequestBody Curso curso) {
        Curso existing = service.buscarPorId(id).orElseThrow();
        existing.setNome(curso.getNome());
        existing.setDescricao(curso.getDescricao());
        return service.atualizar(existing);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Long id) {
        service.excluirPorId(id);
    }
}
