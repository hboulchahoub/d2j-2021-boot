package ma.cigma.pfe.module1.service;

import java.util.List;

import ma.cigma.pfe.module1.models.Facture;
/**
 * this interface contains signatures of methods to be called 
 * by the controllers (presentation layer)
 * @author Mr.BOULCHAHOUB
 * @date 21.12.2020
 */
public interface IFactureService {
	Facture insertFacture(Facture f);
	Facture updateFacture(Facture f);
	void deleteFacture(int id);
	List<Facture> selectAll();
	Facture selectOne(int id);
}
