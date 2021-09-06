package code;

import java.util.ArrayList;

public class BoletimDisciplina {

	public ArrayList<Discente> discentes;
	public byte tipoMedia;
	
	public BoletimDisciplina() {
		this.tipoMedia = 0; 
		discentes      = new ArrayList<Discente>();
	}
	
	public float calculaMedia(Discente discente) {
		float media = 0;
		int peso    = 0;
		if (tipoMedia == 0)  { // media aritmética
			for (Nota nota : discente.notas) {
				media = media + nota.valor;
			}
			peso = discente.notas.size();
			media = media / peso;
		} else if (tipoMedia == 1)  { // media ponderada
			for (Nota nota : discente.notas) {
				media = media + nota.valor * nota.peso;
				peso  = peso + nota.peso;
			}
			media = media / peso;
		}
		return media;
	}
	
	public String determinarStatuseListar() {
		String s = "";
		for (Discente discente : discentes) {
			float media = calculaMedia(discente);
			s += discente.nome + " " + discente.matricula + " " + media;
			if (media >= 7) { // determinando status Aprovado
				s += " Aprovado";
			} else if (media < 7) { // determinando status Reprovado
				s += " Reprovado";
			}
			s += "\n";
		}
		return s; // retornado string que representa todos discentes
	}
	
}
