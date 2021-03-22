package ma.cigma.pfe.module1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.cigma.pfe.module1.dao.DemandRepository;
import ma.cigma.pfe.module1.models.Demand;

/**
 * this class is created to validate all rules related to 
 * business logic
 * @author Mr.BOULCHAHOUB
 * @date 21.12.2020
 */
@Service
public class DemandServiceImpl implements IDemandService {
	@Autowired
	private DemandRepository dao;

	@Override
	public Demand insertDemand(Demand d) {
		System.out.println("Calling service Insert...");

		return dao.save(d);
	}

	@Override
	public boolean updateDemand(Demand d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDemand(Demand d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectDemand(Demand d) {
		// TODO Auto-generated method stub
		return false;
	}

}
