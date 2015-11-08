//package br.edu.unidavi.restapp.jeferson;
//
//import br.edu.unidavi.restapp.jeferson.model.Musica;
//import br.edu.unidavi.restapp.jeferson.repository.MusicaRepository;
//import com.google.common.collect.Lists;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.config.EnableHypermediaSupport;
//import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Jeferson Duwe <duwejeferson@gmail.com>
// */
//@RestController
//@RequestMapping("musica")
//@EnableHypermediaSupport(type = HypermediaType.HAL)
//public class MusicaController {
//
//    @Autowired
//    MusicaRepository musicaRepository;
//
//    @RequestMapping(method = RequestMethod.GET)
//    HttpEntity<List<Musica>> getMusicas() {
//        ArrayList<Musica> musicas = Lists.newArrayList(musicaRepository.findAll());
//        for (Musica musica : musicas) {
//            musica.add(linkTo(ControllerLinkBuilder.methodOn(MusicaController.class).getMusicas()).withSelfRel());
//        }
//        return new ResponseEntity<List<Musica>>(musicas, HttpStatus.OK);
//    }
//
//}
