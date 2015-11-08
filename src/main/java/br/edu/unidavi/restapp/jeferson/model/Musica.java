package br.edu.unidavi.restapp.jeferson.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author Jeferson Duwe <duwejeferson@gmail.com>
 */
@Entity
@SequenceGenerator(name = "musica_id_seq", sequenceName = "musica_id_seq", allocationSize = 1)
public class Musica extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musica_id_seq")
    @Column(name = "mus_id")
    private Long id;

    @NotNull(message = "O nome da música deve ser preenchido.")
    @Column(name = "mus_nome", nullable = false, length = 250)
    private String nome;

    @NotNull(message = "A duração da música deve ser preenchida.")
    @Column(name = "mus_duracao", nullable = false)
    private Time duracao;

    @Column(name = "mus_popularidade", nullable = true)
    private Integer popularidade;

    @ManyToOne(targetEntity = Genero.class)
    @JoinColumn(name = "gen_id", referencedColumnName = "gen_id", nullable = false)
    private Genero genero;

    @ManyToOne(targetEntity = Album.class)
    @JoinColumn(name = "alb_id", referencedColumnName = "alb_id", nullable = true)
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Album album;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }

    public Integer getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(Integer popularidade) {
        this.popularidade = popularidade;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
