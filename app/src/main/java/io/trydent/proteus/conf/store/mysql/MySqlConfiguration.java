package io.trydent.proteus.conf.store.mysql;

import io.trydent.proteus.conf.base.DataSourceConfiguration;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

/**
 * Created by guada on 08/09/14.
 */
public interface MySqlConfiguration extends DataSourceConfiguration {
	public default DataSource dataSource(MySqlProperties mysql) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(mysql.getDriver());
		dataSource.setUrl(mysql.getUrl());
		dataSource.setUsername(mysql.getUsername());
		dataSource.setPassword(mysql.getPassword());

		return dataSource;
	}

	public default JpaVendorAdapter jpaVendorAdapter() {
		final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

		adapter.setDatabase(Database.MYSQL);
		adapter.setDatabasePlatform(MySQL5InnoDBDialect.class.getName());
		adapter.setGenerateDdl(true);
		adapter.setShowSql(true);

		return adapter;
	}
}
