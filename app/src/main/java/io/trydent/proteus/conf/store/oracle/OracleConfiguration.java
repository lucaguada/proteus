package io.trydent.proteus.conf.store.oracle;

import io.trydent.proteus.conf.base.DataSourceConfiguration;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.Oracle10gDialect;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

/**
 * Created by guada on 08/09/14.
 */
public interface OracleConfiguration extends DataSourceConfiguration {
	public default DataSource dataSource(OracleProperties oracle) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(oracle.getDriver());
		dataSource.setUrl(oracle.getUrl());
		dataSource.setUsername(oracle.getUsername());
		dataSource.setPassword(oracle.getPassword());

		return dataSource;
	}

	public default JpaVendorAdapter jpaVendorAdapter() {
		final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

		adapter.setDatabase(Database.ORACLE);
		adapter.setDatabasePlatform(Oracle10gDialect.class.getName());
		adapter.setGenerateDdl(true);
		adapter.setShowSql(true);

		return adapter;
	}
}
