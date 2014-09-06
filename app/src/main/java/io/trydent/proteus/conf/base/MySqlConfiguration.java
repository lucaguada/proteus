package io.trydent.proteus.conf.base;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by guada on 05/09/14.
 */
public abstract class MySqlConfiguration implements DataSourceConfiguration {
	protected DataSource dataSource(MySqlProperties mysql) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(mysql.getDriver());
		dataSource.setUrl(mysql.getUrl());
		dataSource.setUsername(mysql.getUsername());
		dataSource.setPassword(mysql.getPassword());

		return dataSource;
	}

	public abstract DataSource dataSource();
}
