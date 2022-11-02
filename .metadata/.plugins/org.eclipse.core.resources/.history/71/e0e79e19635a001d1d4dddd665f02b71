package com.user.security;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.user.security.jwt.AuthEntryPointJwt;
import com.user.security.jwt.JwtFliter;
import com.user.service.UserImplementation;
import com.user.service.UserService;


@Configuration
@EnableWebSecurity

@EnableGlobalMethodSecurity(
	    prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserImplementation userDetailsService;
	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.userDetailsService(userDetailsService);
//	}

	@Bean
	public PasswordEncoder passwordEncoder () 
	{
		return new BCryptPasswordEncoder();
	}


	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
		
		
	}
	
	 @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(userDetailsService);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }

//	@Bean
//	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    http.cors().and().csrf().disable()
//	        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//	        .authorizeRequests().antMatchers("/User/**").permitAll()
//	        .anyRequest().authenticated();
//	    
//	    http.authenticationProvider(authenticationProvider());
//
//
//
//	   http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//	    
//	    return http.build();
//	  }
	
//	@Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        final List<GlobalAuthenticationConfigurerAdapter> configurers = new ArrayList<>();
//        configurers.add(new GlobalAuthenticationConfigurerAdapter() {
//                    @Override
//                    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//                        // auth.doSomething()
//                    }
//                }
//        );
//        return authConfig.getAuthenticationManager();
//    }
//	
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//      http.
//             cors()
//            .and()
//            .csrf()
//            .disable()
//            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//            .authorizeRequests().antMatchers("/welcome", "User/registration","User/login").permitAll()
//            .anyRequest().authenticated();
//      
//      http.authenticationProvider(daoAuthenticationProvider());
//
//
//
//
//
//    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//      
//      return http.build();
//    }
//	
//	@Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider()
//    {
//        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//        provider.setUserDetailsService(this.userDetailsService);
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }
	@Bean
	public JwtFliter authenticationJwtTokenFilter() {
		return new JwtFliter();
	}

	
	public void configure(HttpSecurity httpSecurity) throws Exception {

		
		
		
		
		httpSecurity.csrf().disable();
		

	}

}
