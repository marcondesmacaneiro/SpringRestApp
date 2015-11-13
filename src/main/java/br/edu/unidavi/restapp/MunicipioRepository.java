package br.edu.unidavi.restapp;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "municipio", path = "municipio")
public interface MunicipioRepository extends PagingAndSortingRepository<Municipio, Long> {

	List<Municipio> findByIbge(@Param("ibge") Integer name);

}
