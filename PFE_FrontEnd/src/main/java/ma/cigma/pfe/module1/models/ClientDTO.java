package ma.cigma.pfe.module1.models;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientDTO {

	private int id;
	private String nom;
	private String cin;
	
	private Set<DemandDTO> demands;


}
