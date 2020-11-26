package controller;

import model.Candidato;
import model.Edital;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeradorDoc {

  public void gerarDoc(Edital edital, ListaController listaController) throws IOException {
    FileWriter arquivo = new FileWriter("Edital2020.txt");
    PrintWriter gravarArq = new PrintWriter(arquivo);
    Candidato candidato = listaController.getInicio();
    int colocacao = 1;

    gravarArq.printf("EDITAL 2020\n");
    gravarArq.printf("Faculdade: " + edital.getFaculdade() + ", Curso: " + edital.getCurso() + " Total de vagas: " + edital.getQtdVagas() + "\n");
    gravarArq.printf("------------------------------------------------------------------------------------\n");
    gravarArq.printf("Alunos Aprovados\n");

    do {
      gravarArq.printf( colocacao + "° colocado: Nome: " + candidato.getNome() + ", CPF: " + candidato.getCpf() + ", Ano de nascimento: " +
              candidato.getAnoNascimento() + ", Nota: " + candidato.getNota() + ".\n");

      colocacao++;
      candidato = candidato.getProx();

      if (candidato.getProx() == null) {
        gravarArq.printf( colocacao + "° colocado: Nome: " + candidato.getNome() + ", CPF: " + candidato.getCpf() + ", Ano de nascimento: " +
                candidato.getAnoNascimento() + ", Nota: " + candidato.getNota() + ".\n");

      }
    }while (candidato.getProx() != null);

    gravarArq.printf("-------------------------------------SIPS 2020--------------------------------------");

    arquivo.close();
  }
}
