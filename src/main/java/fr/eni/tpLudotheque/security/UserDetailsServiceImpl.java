package fr.eni.tpLudotheque.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.eni.tpLudotheque.bo.Utilisateur;
import fr.eni.tpLudotheque.services.UtilisateurService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private PasswordEncoder passwordEncoder;

	private UtilisateurService utilisateurService;

	public UserDetailsServiceImpl(PasswordEncoder passwordEncoder, UtilisateurService utilisateurService) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.utilisateurService = utilisateurService;
	}

	/*
	 * Est appelée à chaque connexion utilisateur username : login saisi par
	 * l'utilisateur
	 */
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Optional<Utilisateur> utilOpt = utilisateurService.findUtilisateurByLogin(login);

		UserDetails user = null;

		if (utilOpt.isPresent()) {
			Utilisateur utilisateur = utilOpt.get();
			user = User.builder().username(login).password(utilisateur.getPassword()).roles(utilisateur.getRole())
					.build();
			return user;
		}

		throw new UsernameNotFoundException(login + " not found.");
	}

}
