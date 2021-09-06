package code;

import java.util.ArrayList;

public class Discente {

	public String nome;
	public String matricula;
	public ArrayList<Nota> notas;
	
	public Discente(String nome, String matricula) {
		this.nome      = nome;
		this.matricula = matricula;
		this.notas = new ArrayList<Nota>();
	}

}
