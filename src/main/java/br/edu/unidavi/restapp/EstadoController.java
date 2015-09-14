package br.edu.unidavi.restapp;

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
@RequestMapping("/estadoteste")
@EnableHypermediaSupport(type = {HypermediaType.HAL})
public class EstadoController {
    
    @Autowired
    EstadoRepository estadoRepository;
    
    @RequestMapping(method=RequestMethod.GET)
    public HttpEntity<List<Estado>> getEstados(){
        ArrayList<Estado> estados = Lists.newArrayList(estadoRepository.findAll());
        for(Estado estado : estados){
            estado.add(linkTo(ControllerLinkBuilder.methodOn(EstadoController.class).getEstados()).withSelfRel());
        }
        return new ResponseEntity<List<Estado>>(estados, HttpStatus.OK);
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Estado> deleteEstado( @RequestBody Estado estadoNovo){      
        estadoRepository.save(estadoNovo);
        return new ResponseEntity<Estado>(estadoNovo, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{uf}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Estado> setEstado(@PathVariable String uf, @RequestBody Estado estadoNovo){
        ArrayList<Estado> estados = Lists.newArrayList(estadoRepository.findByUf(uf));
        Estado estado = estados.get(0);
        estado.setNome(estadoNovo.getNome());
        estadoRepository.save(estado);
        return new ResponseEntity<Estado>(estado, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{uf}", method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Estado> deleteEstado(@PathVariable String uf, @RequestBody Estado estadoNovo){
        ArrayList<Estado> estados = Lists.newArrayList(estadoRepository.findByUf(uf));
        Estado estado = estados.get(0);
        estadoRepository.delete(estado);
        return new ResponseEntity<Estado>(estado, HttpStatus.OK);
    }
    
    
}
