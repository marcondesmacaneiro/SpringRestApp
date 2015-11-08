package br.edu.unidavi.restapp.jeferson.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author Jeferson Duwe <duwejeferson@gmail.com>
 */
@Entity
@SequenceGenerator(name = "artista_id_seq", sequenceName = "artista_id_seq", allocationSize = 1)
public class Artista extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artista_id_seq")
    @Column(name = "art_id")
    private Long id;

    @NotNull(message = "O nome do artista deve ser preenchido.")
    @Column(name = "art_nome", nullable = false, length = 250)
    private String nome;

    @Column(name = "art_popularidade", nullable = true)
    private Integer popularidade;

    @Column(name = "art_bibliografia", nullable = true, columnDefinition = "text")
    private String bibliografia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(Integer popularidade) {
        this.popularidade = popularidade;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

}
