package br.edu.unidavi.restapp.cleber;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import org.springframework.hateoas.ResourceSupport;

/* 
Sempre limpar e construir

Para adicionar qualquer variavel, só precisa adicionar aqui
e no insert

*/
@Entity
@SequenceGenerator(name = "cliente_id_seq", sequenceName = "cliente_id_seq", allocationSize = 1)
public class Cliente extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_id_seq")
    private Long id;

    @NotNull(message = "O CPF do Cliente não pode ser nulo!")
    @Column(unique = true, nullable = false, updatable = false, length = 14)
    private String cpf;

    @NotNull(message = "O Nome do Cliente não pode ser nulo!")
    @Column(nullable = false, length = 50)
    private String nome;
    
    @NotNull(message = "#")
    @Column(nullable = false, length = 10)
    private String dataNascimento;
    
    @NotNull(message = "#")
    @Column(nullable = false, length = 10)
    private String RG;
    
    @NotNull(message = "#")
    @Column(nullable = false, length = 50)
    private String profissao;
    
    @NotNull(message = "#")
    @Column(nullable = false, length = 50)
    private String estado;
    
    @NotNull(message = "#")
    @Column(nullable = false, length = 50)
    private String cidade;
    
    @NotNull(message = "#")
    @Column(nullable = false, length = 50)
    private String rua;
    
    @NotNull(message = "#")
    @Column(nullable = false, length = 50)
    private String bairro;
    
    @NotNull(message = "#")
    @Column(nullable = false, length = 50)
    private String complemento;

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}

