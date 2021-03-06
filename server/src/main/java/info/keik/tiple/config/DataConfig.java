package info.keik.tiple.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
@MapperScan("info.keik.tiple.repository")
public class DataConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory(ApplicationContext context)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setConfigLocation(context.getResource("classpath:mybatis-config.xml"));
		sessionFactory.setMapperLocations(context.getResources("classpath:sql/**/*.xml"));
		return sessionFactory.getObject();
	}

}
