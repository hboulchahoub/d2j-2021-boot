package ma.cigma.pfe.module1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.cigma.pfe.module1.dao.ClientRepository;
import ma.cigma.pfe.module1.models.Client;

/**
 * this class is created to validate all rules related to 
 * business logic
 * @author Mr.BOULCHAHOUB
 * @date 21.12.2020
 */
@Service
public class ClientServiceImpl implements IClientService {
	@Autowired
	private ClientRepository dao;

	@Override
	@Transactional
	public Client insertClient(Client d) {
		System.out.println("Calling service Insert...");

		return dao.save(d);
	}

	@Override
	public boolean updateClient(Client d) {
		return false;
	}

	@Override
	public int deleteClient(int id) {
		
		return dao.deleteById(id);
	}

	@Override
	public boolean selectClient(Client d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Client> selectAll() {
		return (List<Client>) dao.findAll();
	}

	@Override
	public Client selectOne(int id) {
		return dao.findById(id).get();
	}

}
