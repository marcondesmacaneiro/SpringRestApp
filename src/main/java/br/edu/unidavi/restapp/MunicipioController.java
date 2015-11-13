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
@RequestMapping("/municipioController")
@EnableHypermediaSupport(type = {HypermediaType.HAL})
public class MunicipioController {

   @Autowired
   MunicipioRepository municipioRepository;

   @RequestMapping(method = RequestMethod.GET)
   public HttpEntity<List<Municipio>> getMunicipios() {
      ArrayList<Municipio> municipios = Lists.newArrayList(municipioRepository.findAll());
      for (Municipio municipio : municipios) {
         municipio.add(linkTo(ControllerLinkBuilder.methodOn(EstadoController.class).getEstados()).withSelfRel());
      }
      return new ResponseEntity<List<Municipio>>(municipios, HttpStatus.OK);
   }

   @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
   public HttpEntity<Municipio> deleteMunicipio(@RequestBody Municipio municipioNovo) {
      municipioRepository.save(municipioNovo);
      return new ResponseEntity<Municipio>(municipioNovo, HttpStatus.OK);
   }

   @RequestMapping(value = "/{ibge}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
   public HttpEntity<Municipio> setMunicipio(@PathVariable Integer ibge, @RequestBody Municipio municipioNovo) {
      ArrayList<Municipio> municipios = Lists.newArrayList(municipioRepository.findByIbge(ibge));
      Municipio municipio = municipios.get(0);
      municipio.setNome(municipioNovo.getNome());
      municipioRepository.save(municipio);
      return new ResponseEntity<Municipio>(municipio, HttpStatus.OK);
   }

   @RequestMapping(value = "/{ibge}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public HttpEntity<Municipio> deleteMunicipio(@PathVariable Integer ibge, @RequestBody Municipio municipioNovo) {
      ArrayList<Municipio> municipios = Lists.newArrayList(municipioRepository.findByIbge(ibge));
      Municipio municipio = municipios.get(0);
      municipioRepository.delete(municipio);
      return new ResponseEntity<Municipio>(municipio, HttpStatus.OK);
   }

}
