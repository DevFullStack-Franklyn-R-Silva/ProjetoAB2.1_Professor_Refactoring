package code;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		BoletimDisciplina boletim = new BoletimDisciplina();
		// Cadastrar discentes
		while (true) {
			String nome = JOptionPane.showInputDialog(null, "Digite o nome:");
			String matricula = JOptionPane.showInputDialog(null, "Digite a matricula:");
			boletim.discentes.add(new Discente(nome, matricula));

			int opc = JOptionPane.showOptionDialog(null, "Deseja cadatrar outro discente?", "Continuar cadastro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (opc == JOptionPane.NO_OPTION) {
				break;
			}
		}
		int tipoMedia = JOptionPane.showOptionDialog(null, "Deseja utilizar a média aritmética?", "Definir tipo de média", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (tipoMedia == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Será utilizada a média ponderada!"); 
			boletim.tipoMedia = 1;
		} else {
			JOptionPane.showMessageDialog(null, "Será utilizada a média aritmética!");
		}
		for (Discente discente : boletim.discentes) {
			// Cadastrar notas
			while (true) {
				if (boletim.tipoMedia == 0) { // media aritmetica
					String msg = "Digite a nota para " + discente.nome + ":";
					float valor = Float.parseFloat(JOptionPane.showInputDialog(null, msg));
					discente.notas.add(new Nota(valor, 1));
				} else if (boletim.tipoMedia == 1) { // media ponderada
					String msg = "Digite a nota para " + discente.nome + ":";
					float valor = Float.parseFloat(JOptionPane.showInputDialog(null, msg));
					msg = "Digite o peso para a nota " + discente.nome + ":";
					int peso = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
					discente.notas.add(new Nota(valor, peso));
				}
				int opc = JOptionPane.showOptionDialog(null, "Deseja inserir uma nova nota para o discente?", "Continuar cadastro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (opc == JOptionPane.NO_OPTION) {
					break;
				}
			}
		}
		String msg = "=== Boletim === \n";
		msg += "| Nome | Matricula | Média | Status | \n";
		msg += boletim.determinarStatuseListar();
		JOptionPane.showMessageDialog(null, msg);
	}

}
