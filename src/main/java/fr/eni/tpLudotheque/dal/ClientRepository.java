package fr.eni.tpLudotheque.dal;

import java.util.List;

import fr.eni.tpLudotheque.bo.Client;

public interface ClientRepository {

	void ajouterClient(Client client);

	public List<Client> findAllClients();

	Client findById(Integer numeroClient);

	void update(Client client);

	void delete(int numeroClient);

}
