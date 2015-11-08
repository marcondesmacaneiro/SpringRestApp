package br.edu.unidavi.restapp.jeferson.repository;

import br.edu.unidavi.restapp.jeferson.model.Album;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Jeferson Duwe <duwejeferson@gmail.com>
 */
@RepositoryRestResource(collectionResourceRel = "album", path = "album")
public interface AlbumRepository extends PagingAndSortingRepository<Album, Long> {

}
