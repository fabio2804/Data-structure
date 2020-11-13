package controller;

import interfaces.CandidatoInterface;
import model.Candidato;

import javax.swing.JOptionPane;
import java.util.Random;

public class CandidatoController implements CandidatoInterface {
  Random gerador = new Random();
  float nota = 0;

  @Override
  public Candidato criarCandidato() {
    String nome;
    String cpf;
    int anoNascimento;

    try {
      nome = JOptionPane.showInputDialog("Digite o nome do candidato:");
      anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento do candidato:"));
      cpf = JOptionPane.showInputDialog("Digite o CPF do candidato:");
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Dados inválidos!");
      return null;
    }

    return new Candidato(nome, cpf, anoNascimento);
  }

  @Override
  public Candidato gerarNotas(Candidato aux) {

    if (aux.getNota() == 0) {
      nota = gerador.nextFloat() * 100;
      aux.setNota(nota);
    }

    if (aux.getProx() == null) {
      return null;
    }

    return gerarNotas(aux.getProx());
  }
}
