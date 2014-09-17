package io.trydent.proteus.conf;

import io.trydent.proteus.conf.store.mysql.MySqlConfiguration;
import io.trydent.proteus.conf.store.oracle.OracleConfiguration;
import io.trydent.proteus.conf.store.oracle.OracleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

import static io.trydent.proteus.util.Constants.Profile.DEV;
import static io.trydent.proteus.util.Constants.Profile.HEAVY;
import static io.trydent.proteus.util.Constants.Profile.OPENSHIFT;

/**
 * Created by guada on 05/09/14.
 */
@Profile({ HEAVY })
@Configuration
public class OracleDataSourceConfiguration implements OracleConfiguration {
	@Autowired
	private OracleProperties oracle;

	@Bean
	public DataSource dataSource() { return dataSource(oracle); }
}
