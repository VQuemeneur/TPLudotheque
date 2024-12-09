package fr.eni.tpLudotheque.services;

import java.util.List;
import java.util.Optional;

import fr.eni.tpLudotheque.bo.Client;

public interface ClientService {

	void ajouterClient(Client client);

	List<Client> findAllClients();

	Client findClientById(Integer numeroClient);

	void modifierClient(Client client);

	void delete(int numeroClient);

}
