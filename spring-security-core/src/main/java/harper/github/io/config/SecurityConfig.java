/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package harper.github.io.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.LinkedList;
import java.util.List;

@EnableWebSecurity
public class SecurityConfig {

	// @formatter:off
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();

		UserDetails user2 = User.withDefaultPasswordEncoder().username("harper").password("password").roles("USER").build();

		System.out.println(user.getPassword());
		return new InMemoryUserDetailsManager(user,user2);
	}
	// @formatter:on


	@Bean
	public AuthenticationManager authenticationManager() {
		List<AuthenticationProvider> list = new LinkedList<>();
		list.add(daoAuthenticationProvider());
//		list.add(anonymousAuthenticationProvider());

		ProviderManager providerManager = new ProviderManager(list);

		return providerManager;
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

		return daoAuthenticationProvider;
	}

	@Bean
	public RunAsImplAuthenticationProvider runAsImplAuthenticationProvider() {
		RunAsImplAuthenticationProvider runAsImplAuthenticationProvider = new RunAsImplAuthenticationProvider();
		return runAsImplAuthenticationProvider;
	}

//	@Bean
//	public AnonymousAuthenticationProvider anonymousAuthenticationProvider() {
//		return new AnonymousAuthenticationProvider("10");
//	}
//
	// 指定编码
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	//
//	@Bean
//	public RememberMeServices rememberMeServices() {
//		//
//		RememberMeServices rememberMeServices = new TokenBasedRememberMeServices("user", userDetailsService());
//		return rememberMeServices;
//	}

//	@Bean
//	public RememberMeServices rememberMeServices() {
//		return new PersistentTokenBasedRememberMeServices("user",userDetailsService(),persistentTokenRepository());
//	}
//
//	@Bean
//	public PersistentTokenRepository persistentTokenRepository() {
//		JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//		jdbcTokenRepository.setDataSource(dataSource);
//		return jdbcTokenRepository;
//
//	}
//
//	@Bean
//	public RememberMeAuthenticationFilter rememberMeFilter() {
//		return new RememberMeAuthenticationFilter(authenticationManager(), rememberMeServices());
//	}


}
