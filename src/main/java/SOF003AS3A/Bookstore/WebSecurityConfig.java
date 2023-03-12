package SOF003AS3A.Bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

	@Bean
   public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		http
        .authorizeHttpRequests()
        	.requestMatchers("/css/**").permitAll() // Enable css when logged out
        	.requestMatchers("/delete/{id}").hasRole("ADMIN")
        	.anyRequest().authenticated()
        	.and()
      .formLogin()
      .loginPage("/login")
      .defaultSuccessUrl("/booklist")
      .permitAll()
      .and()
      .logout()
      .logoutUrl("/logout")
      .logoutSuccessUrl("/login")
      .permitAll()
          .and()
      .httpBasic();
      return http.build();
	
     
     

	
	
	
	
	}

	 @Bean
	    public UserDetailsService userDetailsService() {
	        List<UserDetails> users = new ArrayList<UserDetails>();

	        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	        UserDetails user1 = User
	        		.withUsername("user")
	        		.password(passwordEncoder.encode("user"))
	        		.roles("USER")
	        		.build();

	        users.add(user1);

	        UserDetails user2 = User
	        		.withUsername("admin")
	        		.password(passwordEncoder.encode("admin"))
	        		.roles("USER", "ADMIN")
	        		.build();

	    	users.add(user2);

	        return new InMemoryUserDetailsManager(users);
	    }

	 
	 }
