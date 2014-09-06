package io.trydent.proteus.conf;

import io.trydent.proteus.conf.base.MySqlConfiguration;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "io.trydent.proteus.mod.repo")
public class OrmConfiguration {
	@Autowired
	private MySqlConfiguration mysql;

	@Bean
	public JpaVendorAdapter jpaVendorAdapter(final Environment environment) {
		final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

		adapter.setDatabase(Database.MYSQL);
		adapter.setDatabasePlatform(MySQL5InnoDBDialect.class.getName());
		adapter.setGenerateDdl(true);
		adapter.setShowSql(true);

		return adapter;
	}

	@Bean
	public FactoryBean<EntityManagerFactory> entityManagerFactory(final Environment environment, final JpaVendorAdapter jpaVendorAdapter) {
		if (environment.getActiveProfiles().length == 0) out.println("No active profiles found");
		Arrays.asList(environment.getActiveProfiles()).forEach(profile -> out.format("Profile found: %s\n", profile));
		final Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.generate_statistics", "false");
		properties.put("hibernate.hbm2ddl.auto", "create");

		final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("io.trydent.proteus.mod.dom_persist");
		factoryBean.setPackagesToScan("io.trydent.proteus.mod.dom");
		factoryBean.setJpaDialect(new HibernateJpaDialect());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setDataSource(mysql.dataSource());
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