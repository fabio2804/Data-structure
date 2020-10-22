package controller;

import interfaces.EditalInterface;
import model.Edital;

import javax.swing.JOptionPane;

public class EditalController implements EditalInterface {

  @Override
  public Edital criarEdital() {
    String faculdade = null;
    String curso = null;
    int qtdVagas = 0;

    try {
      faculdade = JOptionPane.showInputDialog("Digite o nome da faculdade respectiva ao edital:");
      curso = JOptionPane.showInputDialog("Digite o nome do curso respectivo ao edital:");
      qtdVagas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vagas respectivas ao curso:"));
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Dados inválidos!");
    }

    return new Edital(faculdade, curso, qtdVagas);
  }

  @Override
  public boolean verificarEditalVazio(Edital edital) {
    return edital == null;
  }

}
