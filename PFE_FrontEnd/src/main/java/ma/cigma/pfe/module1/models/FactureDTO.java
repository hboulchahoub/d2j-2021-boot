package ma.cigma.pfe.module1.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FactureDTO {
	private int id;
	private String descri;
	private double montant;
}
