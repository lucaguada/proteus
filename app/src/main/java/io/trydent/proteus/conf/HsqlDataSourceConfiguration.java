package io.trydent.proteus.conf;

import io.trydent.proteus.conf.store.hsql.HsqlConfiguration;
import io.trydent.proteus.conf.store.hsql.HsqlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

import static io.trydent.proteus.util.Constants.Profile.BUILD;

/**
 * Created by guada on 05/09/14.
 */
@Profile({ BUILD })
@Configuration
public class HsqlDataSourceConfiguration implements HsqlConfiguration {
	@Autowired
	private HsqlProperties hsql;

	@Bean
	public DataSource dataSource() { return dataSource(hsql); }
}
