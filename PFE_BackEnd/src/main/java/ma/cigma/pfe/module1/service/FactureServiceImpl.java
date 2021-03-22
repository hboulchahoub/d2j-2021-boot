package ma.cigma.pfe.module1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.cigma.pfe.module1.dao.FactureRepository;
import ma.cigma.pfe.module1.models.Facture;

@Service
@Transactional
public class FactureServiceImpl implements IFactureService{
	@Autowired
	private FactureRepository factureRepository;
	@Override
	public Facture insertFacture(Facture f) {
		return factureRepository.save(f);
	}

	@Override
	public Facture updateFacture(Facture f) {
		Facture old = factureRepository.findById(f.getId()).get();
		old.setDescri(f.getDescri());
		old.setMontant(f.getMontant());
		return factureRepository.save(old);
	}

	@Override
	public void deleteFacture(int id) {
		factureRepository.deleteById(id);
	}

	@Override
	public List<Facture> selectAll() {
		return (List<Facture>) factureRepository.findAll();
	}

	@Override
	public Facture selectOne(int id) {
		return factureRepository.findById(id).get();
	}

}
