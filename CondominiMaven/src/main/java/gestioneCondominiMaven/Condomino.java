package gestioneCondominiMaven;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("unused")
public class Condomino {
	
	@Id
	@GeneratedValue
	private String nome;
	private ArrayList<Appartamento> Appartamenti;
	
	public Condominio (String nome){
		this.nome = nome;
	}

}
