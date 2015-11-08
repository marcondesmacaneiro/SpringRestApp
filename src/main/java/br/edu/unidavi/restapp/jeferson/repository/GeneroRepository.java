package br.edu.unidavi.restapp.jeferson.repository;

import br.edu.unidavi.restapp.jeferson.model.Genero;
import br.edu.unidavi.restapp.jeferson.model.Genero;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Jeferson Duwe <duwejeferson@gmail.com>
 */
@RepositoryRestResource(itemResourceRel = "genero", path = "genero")
public interface GeneroRepository extends PagingAndSortingRepository<Genero, Long> {

}
