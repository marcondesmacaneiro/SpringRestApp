package br.edu.unidavi.restapp.jeferson.model;

import java.io.Serializable;
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
 *
 * @author Jeferson Duwe <duwejeferson@gmail.com>
 */
@Entity
@SequenceGenerator(name = "album_id_seq", sequenceName = "album_id_seq", allocationSize = 1)
public class Album extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_seq")
    @Column(name = "alb_id")
    private Long id;

    @NotNull(message = "O nome do álbum deve ser preenchido.")
    @Column(name = "alb_nome", nullable = false, length = 250)
    private String nome;

    @NotNull(message = "A data de lançamento deve ser preenchida.")
    @Column(name = "alb_ano_lancamento", nullable = false)
    private Integer anoLancamento;

    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name = "art_id", referencedColumnName = "art_id", nullable = false)
    private Artista artista;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

}
