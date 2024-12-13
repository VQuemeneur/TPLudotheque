package fr.eni.tpLudotheque.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.tpLudotheque.bo.Client;
import fr.eni.tpLudotheque.dal.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepo;

	public ClientServiceImpl(ClientRepository clientRepo) {
		super();
		this.clientRepo = clientRepo;
	}

	@Override
	public void ajouterClient(Client client) {
		System.out.println("NOM FORMULAIRE SERVICE : " + client.getNom());
		System.out.println("IDCLIENT SERVICE : " + client.getNumeroClient());
		clientRepo.ajouterClient(client);
	}

	@Override
	public List<Client> findAllClients() {
		return clientRepo.findAllClients();
	}

	@Override
	public Client findClientById(Integer numeroClient) {
		Client client = clientRepo.findById(numeroClient);

		return client;
	}

	@Override
	public void modifierClient(Client client) {
		Client clientExistant = clientRepo.findById(client.getNumeroClient());

		clientRepo.update(client);

	}

	@Override
	public void delete(int numeroClient) {
		clientRepo.delete(numeroClient);

	}

}
