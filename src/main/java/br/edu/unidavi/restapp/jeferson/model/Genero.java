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
 *
 * @author Jeferson Duwe <duwejeferson@gmail.com>
 */
@Entity
@SequenceGenerator(name = "genero_id_seq", sequenceName = "genero_id_seq", allocationSize = 1)
public class Genero extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genero_id_seq")
    @Column(name = "gen_id")
    private Long id;

    @NotNull(message = "O nome do gênero deve ser preenchido.")
    @Column(name = "gen_nome", nullable = false, length = 250)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
