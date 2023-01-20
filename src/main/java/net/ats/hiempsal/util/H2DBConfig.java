///////////////////////////////////////////////
//
// net.ats.hiempsal.util.H2DBConfig.java
// is conf class
//
///////////////////////////////////////////////
package net.ats.hiempsal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
*
* @author L KHERBICHE
* @since 0.0.1-RELEASE
*/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "h2dbEMF", transactionManagerRef = "h2dbTM", basePackages = "net.ats.hiempsal", enableDefaultTransactions = false)
public class H2DBConfig {
	
	@Bean("dataSource")
	@ConfigurationProperties(prefix = "spring.h2db.datasource")
	public DataSource h2DataSource() {
		return DataSourceBuilder.create().build();
	}
	@Bean(name = "emfb")
	public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
	   return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
	}
	@SuppressWarnings("unchecked")
	@Bean(name = "h2dbEMF")
	public LocalContainerEntityManagerFactoryBean h2dbEntityManagerFactory(@Qualifier("emfb")EntityManagerFactoryBuilder builder) {  
		return builder
				.dataSource(h2DataSource())
				.properties(hibernateProperties())
				.packages("net.ats.hiempsal")
				.persistenceUnit("h2dbPU")
				.build();
	}
	@Bean(name = "h2dbTM")
	public PlatformTransactionManager h2dbTransactionManager(@Qualifier("h2dbEMF") EntityManagerFactory entityMF) {
		return new JpaTransactionManager(entityMF);
	}
	private Map hibernateProperties() {
		Properties properties = new Properties() {
			private static final long serialVersionUID = 1L;
			{
				setProperty("hibernate.hbm2ddl.auto", "none");
				setProperty("hibernate.show_sql", "false");
				setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			}
		};
		return properties.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue()));
	}
}
