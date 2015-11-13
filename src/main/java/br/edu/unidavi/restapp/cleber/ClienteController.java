package br.edu.unidavi.restapp.cleber;


import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marcondes
 */

@RestController
@RequestMapping("/clienteteste")
@EnableHypermediaSupport(type = {HypermediaType.HAL})
public class ClienteController {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    @RequestMapping(method=RequestMethod.GET)
    public HttpEntity<List<Cliente>> getClientes(){
        ArrayList<Cliente> clientes = Lists.newArrayList(clienteRepository.findAll());
        for(Cliente cliente : clientes){
            cliente.add(linkTo(ControllerLinkBuilder.methodOn(ClienteController.class).getClientes()).withSelfRel());
        }
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }
    
    //Novo cliente
    @RequestMapping(value="/", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Cliente> deleteCliente( @RequestBody Cliente clienteNovo){      
        clienteRepository.save(clienteNovo);
        return new ResponseEntity<Cliente>(clienteNovo, HttpStatus.OK);
    }
    
    //Alterar cliente
    @RequestMapping(value="/{cpf}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Cliente> setCliente(@PathVariable String cpf, @RequestBody Cliente clienteNovo){
        ArrayList<Cliente> clientes = Lists.newArrayList(clienteRepository.findByCpf(cpf));
        Cliente cliente = clientes.get(0);
        
        cliente.setNome(clienteNovo.getNome());
        cliente.setDataNascimento(clienteNovo.getDataNascimento());
        cliente.setRG(clienteNovo.getRG());
        cliente.setProfissao(clienteNovo.getProfissao());
        cliente.setEstado(clienteNovo.getEstado());
        cliente.setCidade(clienteNovo.getCidade());
        cliente.setRua(clienteNovo.getRua());
        cliente.setBairro(clienteNovo.getBairro());
        cliente.setComplemento(clienteNovo.getComplemento());
        clienteRepository.save(cliente);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
    
    //Deletar cliente - precisa Arumar
    @RequestMapping(value="/{cpf}", method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Cliente> deleteCliente(@PathVariable String cpf, @RequestBody Cliente clienteNovo){
        ArrayList<Cliente> clientes = Lists.newArrayList(clienteRepository.findByCpf(cpf));
        Cliente cliente = clientes.get(0);
        clienteRepository.delete(cliente);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
    
    
}
