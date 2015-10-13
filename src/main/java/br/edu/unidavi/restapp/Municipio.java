package br.edu.unidavi.restapp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import org.springframework.hateoas.ResourceSupport;

@Entity
@SequenceGenerator(name = "municipio_id_seq", sequenceName = "municipio_id_seq", allocationSize = 1)
public class Municipio extends ResourceSupport implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipio_id_seq")
   private Long id;

   @NotNull(message = "O IBGE do município não pode ser nulo!")
   @Column(unique = true, nullable = false, updatable = false, length = 7)
   private Integer ibge;

   @NotNull(message = "O Nome do município não pode ser nulo!")
   @Column(nullable = false, length = 50)
   private String nome;

   public Integer getIbge() {
      return ibge;
   }

   public void setIbge(Integer ibge) {
      this.ibge = ibge;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

}
