package io.trydent.proteus.mod.repo.test;

import io.trydent.proteus.App;
import io.trydent.proteus.mod.dom.Person;
import io.trydent.proteus.mod.repo.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by guada on 09/09/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class PersonRepositoryIntegrationTest {

	@Autowired
	private PersonRepository repository;

	@Test
	public void findHanna() {
		Person hanna = this.repository.findByFirstName("Hanna");
		assertNotNull(hanna);
		assertEquals(hanna.getFirstName(), "Hanna");
	}
}
