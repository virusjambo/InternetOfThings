package com.heroku.demo;

import java.net.URI;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

	@Bean
	@Autowired
	public DataSource dataSource() {
		try {
				//URI dbUri = new URI("postgres://ahfrbndexymzyd:RZH7D_e20MBegDzW0LVE04MEw8@ec2-54-225-194-162.compute-1.amazonaws.com:5432/d54rhig86urehd");

				
				URI dbUri = new URI(System.getenv("DATABASE_URL"));
			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
			
			/*  String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' +
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