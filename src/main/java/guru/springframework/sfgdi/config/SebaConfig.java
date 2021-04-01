package guru.springframework.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SebaConfig {
	private final String username;
	private final String password;
	private final String jdbcurl;
	
	public SebaConfig(@Value("${guru.username}") String username,
					  @Value("${guru.password}") String password,
					  @Value("${guru.jdbcurl}") String jdbcurl) {
		super();
		this.username = username;
		this.password = password;
		this.jdbcurl = jdbcurl;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getJdbcurl() {
		return jdbcurl;
	}
	
	
	
}
