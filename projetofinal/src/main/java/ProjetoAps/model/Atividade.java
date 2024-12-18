package ProjetoAps.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String objetivo;

    private String publicoAlvo;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Categoria categoria;

    @OneToMany(mappedBy = "atividade")
    private List<Evidencia> evidencias;

    // Construtores, Getters e Setters
    public Atividade() {}

    public Atividade(String nome, String objetivo, String publicoAlvo) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.publicoAlvo = publicoAlvo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Evidencia> getEvidencias() {
        return evidencias;
    }

    public void setEvidencias(List<Evidencia> evidencias) {
        this.evidencias = evidencias;
    }
}