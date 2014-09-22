package io.trydent.proteus.conf.store.hsql;

import io.trydent.proteus.conf.base.DataSourceConfiguration;
import org.hibernate.dialect.HSQLDialect;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

/**
 * Created by guada on 08/09/14.
 */
public interface HsqlConfiguration extends DataSourceConfiguration {
	public default DataSource dataSource(HsqlProperties hsql) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(hsql.getDriver());
		dataSource.setUrl(hsql.getUrl());
		dataSource.setUsername(hsql.getUsername());
		dataSource.setPassword(hsql.getPassword());

		return dataSource;
	}

	public default JpaVendorAdapter jpaVendorAdapter() {
		final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

		adapter.setDatabase(Database.HSQL);
		adapter.setDatabasePlatform(HSQLDialect.class.getName());
		adapter.setGenerateDdl(true);
		adapter.setShowSql(true);

		return adapter;
	}
}
