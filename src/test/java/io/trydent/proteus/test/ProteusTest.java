package io.trydent.proteus.test;

import io.trydent.proteus.Proteus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Proteus.class)
public class ProteusTest {
	@Autowired
	ApplicationContext context;

	@Test
	public void testContextLoads() throws Exception {
		assertNotNull(this.context);
		assertTrue(this.context.containsBean("proteus"));
	}
}
