package info.keik.tiple.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@MapperScan("info.keik.tiple.repository")
public class DataConfig {

	@Autowired
	DataSource dataSource;

	// @Bean
	// @Primary
	// @Autowired
	// protected PlatformTransactionManager createTransactionManager(
	// DataSource dataSource) {
	// return new DataSourceTransactionManager(dataSource);
	// }

	// @Bean
	// @Profile("prod")
	// public DataSource prodDataSource() {
	// return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
	// .addScript("classpath:import-mysql.sql").build();
	// }

	@Bean
	@Profile("dev")
	public DataSource devDataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
				.addScript("classpath:import-dev.sql").build();
	}

	@Bean
	@Autowired
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}

}
