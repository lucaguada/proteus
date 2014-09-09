package io.trydent.proteus.conf;

import io.trydent.proteus.conf.store.mysql.MySqlConfiguration;
import io.trydent.proteus.conf.store.mysql.MySqlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

import static io.trydent.proteus.util.Constants.Profile.DEV;
import static io.trydent.proteus.util.Constants.Profile.OPENSHIFT;

/**
 * Created by guada on 05/09/14.
 */
@Profile({ DEV, OPENSHIFT })
@Configuration
public class MySqlDataSourceConfiguration implements MySqlConfiguration {
	@Autowired
	private MySqlProperties mysql;

	@Bean
	public DataSource dataSource() { return dataSource(mysql); }
}
