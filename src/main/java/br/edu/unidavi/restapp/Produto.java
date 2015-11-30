package br.edu.unidavi.restapp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import org.springframework.hateoas.ResourceSupport;

@Entity
@SequenceGenerator(name = "produto_id_seq", sequenceName = "produto_id_seq", allocationSize = 1)
public class Produto extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_id_seq")
    private Long id;

    @NotNull(message = "O Nome do Produto não pode ser nulo!")
    @Column(unique = true, nullable = false, updatable = false, length = 30)
    private String nome;

    @NotNull(message = "O Valor não pode ser nulo!")
    @Column(nullable = false, length = 6)
    private float valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    
}
