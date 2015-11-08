package br.edu.unidavi.restapp.jeferson.repository;

import br.edu.unidavi.restapp.jeferson.model.Artista;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Jeferson Duwe <duwejeferson@gmail.com>
 */
@RepositoryRestResource(collectionResourceRel = "artista", path = "artista")
public interface ArtistaRepository extends PagingAndSortingRepository<Artista, Long> {

}
