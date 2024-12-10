package fr.eni.tpLudotheque.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private PasswordEncoder passwordEncoder;

	public UserDetailsServiceImpl(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	/*
	 * Est appelée à chaque connexion utilisateur username : login saisi par
	 * l'utilisateur
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetails user = null;
		
		if ("bob".equals(username)) {
			user = User.builder().username(username).password(passwordEncoder.encode("password")) // A aller chercher en
																									// BD
					.roles("USER", "ADMIN").build();
			return user;
		}
		throw new UsernameNotFoundException(username + " not found.");
	}

}
