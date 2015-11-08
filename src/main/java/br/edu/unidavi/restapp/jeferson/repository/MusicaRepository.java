package br.edu.unidavi.restapp.jeferson.repository;

import br.edu.unidavi.restapp.jeferson.model.Musica;
import br.edu.unidavi.restapp.jeferson.model.Musica;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Jeferson Duwe <duwejeferson@gmail.com>
 */
@RepositoryRestResource(itemResourceRel = "musica", path = "musica")
public interface MusicaRepository extends PagingAndSortingRepository<Musica, Long> {

}
