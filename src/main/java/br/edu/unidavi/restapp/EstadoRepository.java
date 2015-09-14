package br.edu.unidavi.restapp;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "estado", path = "estado")
public interface EstadoRepository extends PagingAndSortingRepository<Estado, Long> {

	List<Estado> findByUf(@Param("uf") String name);

}
