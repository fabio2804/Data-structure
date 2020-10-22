package controller;

import interfaces.CandidatoInterface;
import model.Candidato;

import javax.swing.JOptionPane;

public class CandidatoController implements CandidatoInterface {
  @Override
  public Candidato criarCandidato() {
    String nome = null;
    String cpf = null;
    int anoNascimento = 0;

    try {
      nome = JOptionPane.showInputDialog("Digite o nome do candidato:");
      cpf = JOptionPane.showInputDialog("Digite o CPF do candidato:");
      anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite a data de nascimento do candidato:"));
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Dados inválidos!");
    }

    return new Candidato(nome, cpf, anoNascimento);
  }

  @Override
  public void gerarNotas() {

  }
}
