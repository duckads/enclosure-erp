package kr.co.shield.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EntityScan(basePackages = "kr.co.shield.domain")
@EnableAutoConfiguration
public class DataSourceConfig {
	
	public static final String DATA_SOURCE = "dataSource";
	public static final String TRANSACTION_MANAGER = "transactionManager";
	public static final String ENTITY_MANAGER = "entityManager";
	public static final String ENTITY_MANAGER_FACTORY = "entityManagerFactory";
	
	@Bean(DATA_SOURCE)
	@ConfigurationProperties("spring.datasource.hikari")
	@Primary
	DataSource dataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean(ENTITY_MANAGER_FACTORY)
	@Primary
	LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("kr.co.shield.domain") // 첫번째 DB와 관련된 엔티티들이 있는 패키지(폴더) 경로
				.persistenceUnit("entityManager")
				.build();
	}
	
	@Bean(TRANSACTION_MANAGER)
	@Primary
	PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	@EnableJpaRepositories(
			entityManagerFactoryRef = "entityManagerFactory",
			basePackages = "kr.co.shield.repository",
			transactionManagerRef = "transactionManager"
	)
	static class JpaConfig {}
	
}
