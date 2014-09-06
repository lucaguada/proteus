package io.trydent.proteus.conf;

import io.trydent.proteus.conf.base.MySqlConfiguration;
import io.trydent.proteus.conf.prop.DevelopmentMySqlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

import static io.trydent.proteus.util.Constants.Profile.DEVELOPMENT;

/**
 * Created by guada on 05/09/14.
 */
@Profile(DEVELOPMENT)
@Configuration
public class DevelopmentConfiguration extends MySqlConfiguration {
	@Autowired
	private DevelopmentMySqlProperties mysql;

	@Bean
	public DataSource dataSource() { return dataSource(mysql); }
}
