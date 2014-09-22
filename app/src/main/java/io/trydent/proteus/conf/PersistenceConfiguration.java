package io.trydent.proteus.conf;

import io.trydent.proteus.conf.base.DataSourceConfiguration;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {
	@Autowired
	private DataSourceConfiguration dataSource;

	@Bean
	public JpaVendorAdapter jpaVendorAdapter(final Environment environment) {
		return dataSource.jpaVendorAdapter();
	}

	@Bean
	public FactoryBean<EntityManagerFactory> entityManagerFactory(final Environment environment, final JpaVendorAdapter jpaVendorAdapter) {
		if (environment.getActiveProfiles().length == 0) out.println("No active profiles found");
		Arrays.asList(environment.getActiveProfiles()).forEach(profile -> out.format("Profile found: %s\n", profile));
		final Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.generate_statistics", "false");
		properties.put("hibernate.hbm2ddl.auto", "validate");

		final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("io.trydent.proteus.mod.dom_persist");
		factoryBean.setPackagesToScan("io.trydent.proteus.mod.dom");
		factoryBean.setJpaDialect(new HibernateJpaDialect());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setDataSource(dataSource.dataSource());
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
		dataSource.setDataSourceClassName(OracleProperties.DRIVER);
		dataSource.addDataSourceProperty("url", OracleProperties.URL);
		dataSource.addDataSourceProperty("user", OracleProperties.USERNAME);
		dataSource.addDataSourceProperty("password", OracleProperties.PASSWORD);
		dataSource.addDataSourceProperty("cachePrepStmts", true);
		dataSource.addDataSourceProperty("prepStmtCacheSize", 250);
		dataSource.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
		dataSource.addDataSourceProperty("useServerPrepStmts", true);

		return dataSource;
	}*/
}