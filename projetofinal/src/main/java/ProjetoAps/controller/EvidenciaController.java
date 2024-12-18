package ProjetoAps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidencias")
public class EvidenciaController {

    private final EvidenciaService service;

    @Autowired
    public EvidenciaController(EvidenciaService service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<Evidencia> listarTodos() {
        return service.listarTodos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Evidencia buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).orElseThrow(() -> new RuntimeException("Evidência não encontrada"));
    }

    // Salvar
    @PostMapping
    public Evidencia salvar(@RequestBody Evidencia evidencia) {
        return service.salvar(evidencia);
    }

    // Atualizar
    @PutMapping("/{id}")
    public Evidencia atualizar(@PathVariable Long id, @RequestBody Evidencia evidencia) {
        Evidencia existing = buscarPorId(id);
        existing.setFoto(evidencia.getFoto());
        existing.setLegenda(evidencia.getLegenda());
        return service.atualizar(existing);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.excluirPorId(id);
    }
}