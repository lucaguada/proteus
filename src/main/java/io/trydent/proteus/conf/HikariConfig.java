package io.trydent.proteus.conf;

import io.trydent.proteus.conf.prop.MySqlProperties;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "io.trydent.proteus.mod.repo")
public class HikariConfig {
	@Bean
	public FactoryBean<EntityManagerFactory> entityManagerFactory(final Environment environment, final DataSource dataSource, final JpaVendorAdapter jpaVendorAdapter) {
		final Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.generate_statistics", "false");
		properties.put("hibernate.hbm2ddl.auto", "update");

		final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("io.trydent.proteus.mod.dom_persist");
		factoryBean.setPackagesToScan("io.trydent.proteus.mod.dom");
		factoryBean.setJpaDialect(new HibernateJpaDialect());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setDataSource(dataSource);
		factoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		factoryBean.setJpaPropertyMap(properties);
		return factoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(MySqlProperties.DRIVER);
		dataSource.setUrl(MySqlProperties.URL);
		dataSource.setUsername(MySqlProperties.USERNAME);
		dataSource.setPassword(MySqlProperties.PASSWORD);

		return dataSource;
	}

	/*
	@Bean
	public DataSource dataSource() {
		final HikariDataSource dataSource = new HikariDataSource();

		dataSource.setMaximumPoolSize(100);
		dataSource.setDataSourceClassName(MySqlProperties.DRIVER);
		dataSource.addDataSourceProperty("url", MySqlProperties.URL);
		dataSource.addDataSourceProperty("user", MySqlProperties.USERNAME);
		dataSource.addDataSourceProperty("password", MySqlProperties.PASSWORD);
		dataSource.addDataSourceProperty("cachePrepStmts", true);
		dataSource.addDataSourceProperty("prepStmtCacheSize", 250);
		dataSource.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
		dataSource.addDataSourceProperty("useServerPrepStmts", true);

		return dataSource;
	}*/
}