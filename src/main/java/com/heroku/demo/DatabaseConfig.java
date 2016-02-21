package com.heroku.demo;

import java.net.URI;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableJpaRepositories(basePackages={"com.heroku"})
public class DatabaseConfig {

	@Bean
	public DataSource dataSource() {
		try {
				//URI dbUri = new URI("postgres://zxlatqfyhhujyt:Lqmb_HuLOjoQon0vgJWyWHxChZ@ec2-54-83-198-111.compute-1.amazonaws.com:5432/d7li96963voj6v");

				
				URI dbUri = new URI(System.getenv("DATABASE_URL"));
			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
			
	/* String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' +
			  dbUri.getPort() + dbUri.getPath()
			 +"?sslmode=require&user="+username+"&password="+ password;*/
			
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUrl(dbUrl);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			return dataSource;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}