package io.trydent.proteus.conf.base;

import org.springframework.orm.jpa.JpaVendorAdapter;

import javax.sql.DataSource;

/**
 * Created by guada on 05/09/14.
 */
public interface DataSourceConfiguration {
	public DataSource dataSource();
	public JpaVendorAdapter jpaVendorAdapter();
}
