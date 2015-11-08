//package br.edu.unidavi.restapp.jeferson;
//
//import br.edu.unidavi.restapp.jeferson.model.Album;
//import br.edu.unidavi.restapp.jeferson.repository.AlbumRepository;
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
//@RequestMapping("album")
//@EnableHypermediaSupport(type = HypermediaType.HAL)
//public class AlbumController {
//
//    @Autowired
//    AlbumRepository albumRepository;
//
//    @RequestMapping(method = RequestMethod.GET)
//    HttpEntity<List<Album>> getAlbuns() {
//        ArrayList<Album> albuns = Lists.newArrayList(albumRepository.findAll());
//        for (Album album : albuns) {
//            album.add(linkTo(ControllerLinkBuilder.methodOn(AlbumController.class).getAlbuns()).withSelfRel());
//        }
//        return new ResponseEntity<List<Album>>(albuns, HttpStatus.OK);
//    }
//
//}
