package gestioneCondominiMaven;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("unused")
public class Appartamento {
	
	@Id
	@GeneratedValue
	private static final double COSTI_MANUTENZIONE = 150;
	private String proprietario;
	private double dimensione;
	private double costoSpese;

}
