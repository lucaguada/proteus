package io.trydent.proteus.mod.repo;

import io.trydent.proteus.mod.dom.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by guada on 17/09/14.
 */
@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
public interface CityRepository extends JpaRepository<City, Long> {
	@Query("select c from City c where c.name like %:value% OR c.state like %:value% OR c.country like %:value% OR c.map like %:value%")
	Page<City> findByValue(@Param("value") String value, Pageable pageable);
	City findByNameAndCountryAllIgnoringCase(@Param("name") String name, @Param("country") String country);
}