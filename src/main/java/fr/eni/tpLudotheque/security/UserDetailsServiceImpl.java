package fr.eni.tpLudotheque.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Override
	/*
	 * Est appelée à chaque connexion utilisateur
	 * username : login saisi par l'utilisateur
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails user =null;
		
		if("bob".equals(username)) {
			
				user = User.withDefaultPasswordEncoder()
					.username("bob")
					.password("password")
					.roles("USER", "ADMIN")
					.build();
//			 	user = User.builder()
//			 		.username(username)
//			 		.password("{bcrypt}$2a$10$G3ElKcXPBaUSqx.pPy1UA.0K7R76ETfEt.lyoDntdN3prqV8upLLe")  //A aller chercher en BD
//			 		.roles("USER", "ADMIN")
//			 		.build();
//				return user;
		}
		throw new UsernameNotFoundException(username + " not found.");
	}

}

