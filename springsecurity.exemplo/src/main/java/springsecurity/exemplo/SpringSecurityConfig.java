package springsecurity.exemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/gerenciador/**").hasAnyRole("ADMIN")
			.and()
				.formLogin()
				.loginPage("/login").successForwardUrl("/gerenciador")
			.and()
				.logout()
				.logoutUrl("/logout")
				.permitAll();
	}
	
	@Autowired
	public void auth(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
	}
}
