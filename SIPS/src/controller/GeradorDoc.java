package controller;

import model.Candidato;
import model.Edital;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class GeradorDoc {

  public void gerarDoc(Edital edital, Candidato[] arrayCandidatos) throws IOException {
    FileWriter arquivo = new FileWriter(edital.getCurso() + "Edital.txt");
    PrintWriter gravarArq = new PrintWriter(arquivo);

    gravarArq.printf("EDITAL 2020\n");
    gravarArq.printf("Faculdade: " + edital.getFaculdade() + ", Curso: " + edital.getCurso() + " Total de vagas: "
        + edital.getQtdVagas() + "\n");
    gravarArq.printf("------------------------------------------------------------------------------------\n");
    gravarArq.printf("Alunos Aprovados\n");

    int pos = 1;

    for (int i = arrayCandidatos.length - 1; i > ((arrayCandidatos.length - 1) - edital.getQtdVagas()); i--) {
      if (i < 0) {
        gravarArq.printf("-------------------------------------SIPS 2020--------------------------------------");

        arquivo.close();

        return;
      }

      String notaFormatada = new DecimalFormat("##.##").format(arrayCandidatos[i].getNota());

      gravarArq.printf(pos + "° colocado: Nome: " + arrayCandidatos[i].getNome() + ", CPF: "
          + arrayCandidatos[i].getCpf() + ", Ano de nascimento: " + arrayCandidatos[i].getAnoNascimento() + ", Nota: "
          + notaFormatada + ".\n");

      pos++;

    }
  }
}
