package io.trydent.proteus.mod.repo;

import io.trydent.proteus.mod.dom.Person;
import io.trydent.proteus.mod.repo.base.StrongEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import static io.trydent.proteus.util.Constants.Database;
import static io.trydent.proteus.util.Constants.RestApi;

/**
 * Created by guada on 04/09/14.
 */
@RepositoryRestResource(collectionResourceRel = Database.PEOPLE, path = RestApi.PEOPLE)
public interface PersonRepository extends StrongEntityRepository<Person>, JpaRepository<Person, Long> {
	public Person findByFirstName(@Param("firstName") String firstName);
}
