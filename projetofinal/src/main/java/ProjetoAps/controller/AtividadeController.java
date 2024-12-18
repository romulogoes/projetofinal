package ProjetoAps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atividades")
public class AtividadeController {

    private final AtividadeService service;

    @Autowired
    public AtividadeController(AtividadeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Atividade> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Atividade buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    public Atividade salvar(@RequestBody Atividade atividade) {
        return service.salvar(atividade);
    }

    @PutMapping("/{id}")
    public Atividade atualizar(@PathVariable Long id, @RequestBody Atividade atividade) {
        Atividade existing = service.buscarPorId(id).orElseThrow();
        existing.setNome(atividade.getNome());
        existing.setObjetivo(atividade.getObjetivo());
        return service.atualizar(existing);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Long id) {
        service.excluirPorId(id);
    }
}
