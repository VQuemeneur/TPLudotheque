package fr.eni.tpLudotheque.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				// Autoriser tout le monde pour ces endpoints
				.requestMatchers("/", "/login", "/images/*", "/chiffre").permitAll()

				// Autoriser uniquement les ADMIN pour la gestion des jeux
				.requestMatchers(HttpMethod.GET, "/jeu/creer", "/jeu/{numeroJeu}/ajouterExemplaire").hasRole("ADMIN")

				// Autoriser uniquement les USER pour la gestion des clients
				.requestMatchers(HttpMethod.GET, "/ajoutClient", "/client/{numeroClient}",
						"/client/modifier/{numeroClient}", "/client/supprimer/{numeroClient}",
						"/client/{numeroClient}/location", "/jeu/{numeroJeu}", "/jeu/{numeroJeu}/{numeroExemplaire}")
				.hasRole("USER")

				.requestMatchers(HttpMethod.POST).authenticated().anyRequest().authenticated())

				.formLogin((form) -> form.loginPage("/login").permitAll()).logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
	static RoleHierarchy roleHierarchy() {
		return RoleHierarchyImpl.withDefaultRolePrefix().role("ADMIN").implies("USER").build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
