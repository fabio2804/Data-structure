package controller;

import model.Aluno;

import javax.swing.*;

public class ListaEncadeadaSimples {
  private Aluno primeiroLista;
  private Aluno ultimoLista;
  private int qtdElementos;

  public ListaEncadeadaSimples() {
    this.primeiroLista = null;
    this.ultimoLista = null;
    this.qtdElementos = 0;
  }

  public boolean listaVazia() {
    return qtdElementos == 0;
  }

  public void adicionaInicio(Aluno novoAluno) {

    if (listaVazia()) {
      novoAluno.setProx(primeiroLista);
      this.primeiroLista = novoAluno;
      this.ultimoLista = novoAluno;
    } else {
      novoAluno.setProx(primeiroLista);
      this.primeiroLista = novoAluno;
    }
    this.qtdElementos++;
  }

  public void adicionaFinal(Aluno novoAluno) {
    if (listaVazia()) {
      this.primeiroLista = novoAluno;
    } else {
      ultimoLista.setProx(novoAluno);
    }
    this.ultimoLista = novoAluno;
    this.qtdElementos++;
  }

  public void adicionaPosicao(int posicao, Aluno novoAluno) {
    if (posicao == this.qtdElementos + 1) adicionaFinal(novoAluno);

    else if (posicao == 1) adicionaInicio(novoAluno);

    else if (posicao > (this.qtdElementos + 1) || posicao < 1) {
      JOptionPane.showMessageDialog(null, "Posição inválida!");
    } else {
      Aluno aux = this.primeiroLista;

      for (int i = 0; i < (posicao - 2); i++) {
        aux = aux.getProx();
      }
      novoAluno.setProx(aux.getProx());
      aux.setProx(novoAluno);
      this.qtdElementos++;
    }

  }

  public void removeInicio() {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
    }
    else{
    Aluno aux = this.primeiroLista;
    this.primeiroLista = aux.getProx();
    this.qtdElementos--;
    }
  }

  public void removeFinal() {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
      return;
    }
    Aluno aux = primeiroLista;

    while (aux.getProx() != null) {
      aux = aux.getProx();
    }
    aux.setProx(null);

    this.qtdElementos--;
  }

  public void removePosicao(int posicao) {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
      return;
    }
    if (posicao > qtdElementos || posicao < 1) {
      JOptionPane.showMessageDialog(null, "Posição inválida!");
    } else if (posicao == 1) {
      removeInicio();
    } else if (posicao == this.qtdElementos) {
      removeFinal();
    } else {
      Aluno aux = this.primeiroLista;
      Aluno aux2;

      for (int i = 0; i < (posicao - 2); i++) {
        aux = aux.getProx();
      }
      aux2 = aux.getProx();
      aux.setProx(aux2.getProx());

      this.qtdElementos--;
    }
  }

  public void mostrarLista() {
    if (listaVazia()) System.out.println("[]");
    else {
      Aluno aux = primeiroLista;
      System.out.print("[ ");
      for (int i = 0; i < (this.qtdElementos); i++) {
        System.out.print("{"+ aux.getRa() + ", " + aux.getNome() + ", " + aux.getTurma() +
                ", " + aux.getSemestre() + "} ");
        aux = aux.getProx();
      }
      System.out.print("]");
      System.out.println();
    }
  }

  public void buscaPorPosicao(int pos) {
    if (listaVazia())
      JOptionPane.showMessageDialog(null, "Você deve preencher a lista primeiro");
    else if (pos < 1 || pos > this.qtdElementos)
      JOptionPane.showMessageDialog(null, "Posição inválida!");
    else {
      Aluno aux = this.primeiroLista;
      for (int i = 0; i < (pos - 1); i++) {
        aux = aux.getProx();
      }

      System.out.print("Valor referente à posição " + pos + " da lista\nR.A: " + aux.getRa() + ", nome: " +
              aux.getNome() + ", turma: " + aux.getTurma() + ", " +
              "semestre: " + aux.getSemestre());
    }
  }

  public Aluno criaAluno() {
    int ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o R.A do aluno:"));
    String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
    String turma = JOptionPane.showInputDialog("Digite a turma do aluno:");
    String semestre = JOptionPane.showInputDialog("Digite o semestre do aluno:");

    Aluno aluno = new Aluno();

    aluno.setRa(ra);
    aluno.setNome(nome);
    aluno.setTurma(turma);
    aluno.setSemestre(semestre);
    return aluno;
  }
}
