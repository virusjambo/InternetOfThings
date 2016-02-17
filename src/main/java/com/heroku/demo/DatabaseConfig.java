package com.heroku.demo;

import java.net.URI;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
  /*  @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }*/
    
    @Bean
	@Autowired
	public DataSource dataSource() {
		try {
			
			URI dbUri = new URI(System.getenv("DATABASE_URL"));

		    String username = dbUri.getUserInfo().split(":")[0];
		    String password = dbUri.getUserInfo().split(":")[1];
		    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
		    
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUrl(dbUrl);
			dataSource.setUsername( username);
			dataSource.setPassword(password);
			return dataSource;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}