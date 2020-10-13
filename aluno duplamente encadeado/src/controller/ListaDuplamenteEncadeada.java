package controller;

import model.Aluno;

import javax.swing.*;

public class ListaDuplamenteEncadeada {
  private Aluno primeiroLista;
  private Aluno ultimoLista;
  private int qtdElementos;

  public ListaDuplamenteEncadeada() {
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
      primeiroLista = novoAluno;
      ultimoLista = novoAluno;
    } else {
      primeiroLista.setAnterior(novoAluno);
      novoAluno.setProx(primeiroLista);
      primeiroLista = novoAluno;
    }
    this.qtdElementos++;
  }

  public void removeInicio() {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
    } else {
      Aluno aux = primeiroLista;
      primeiroLista = aux.getProx();
      primeiroLista.setAnterior(null);
      qtdElementos--;
    }
  }

  public void adicionaFinal(Aluno novoAluno) {
    if (listaVazia()) {
      adicionaInicio(novoAluno);
    } else {
      novoAluno.setAnterior(ultimoLista);
      ultimoLista.setProx(novoAluno);
    }
    this.ultimoLista = novoAluno;
    this.qtdElementos++;
  }

  public void removeFinal() {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
      return;
    }

    if (qtdElementos == 1) {
      primeiroLista = null;
      qtdElementos--;
      return;
    }

    Aluno aux = ultimoLista.getAnterior();

    aux.setProx(null);

    qtdElementos--;
  }

  public void bubbleSort(Aluno aux) {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos!");
      return;
    }
    if (aux.getProx() == null)
      return;

    Aluno aux2 = aux.getProx();
    if (aux.getNome().compareTo(aux2.getNome()) > 0) {
      String stringAux = aux.getNome();
      aux.setNome(aux2.getNome());
      aux2.setNome(stringAux);
    }

    bubbleSort(aux.getProx());
  }

  public Aluno buscaSequencial(Aluno aluno, String nome) {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para realizar a busca!");
      return null;
    }

    if (aluno.getNome().equals(nome)) {
      System.out.println("{ " + aluno.getId() + ", " + aluno.getNome() + ", " + aluno.getCurso() + " }");
      return aluno;
    }

    if (aluno.getProx() == null) {
      JOptionPane.showMessageDialog(null, "Este aluno não existe");
      return null;
    }
    return buscaSequencial(aluno.getProx(), nome);
  }

  public Aluno getPrimeiroLista() {
    return primeiroLista;
  }

  public Aluno mostrarLista(Aluno aux) {
    if (listaVazia()) {
      return null;
    }
    if (aux.getProx() == null) {
      System.out.print("{" + aux.getId() + ", " + aux.getNome() + ", " + aux.getCurso() + "} ");
      return null;
    } else {
      System.out.print("{" + aux.getId() + ", " + aux.getNome() + ", " + aux.getCurso() + "} ");
      return mostrarLista(aux.getProx());
    }
  }

  public Aluno criaAluno() {
    int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno:"));
    String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
    String curso = JOptionPane.showInputDialog("Digite o curso do aluno");

    Aluno aluno = new Aluno();

    aluno.setId(id);
    aluno.setNome(nome);
    aluno.setCurso(curso);
    return aluno;
  }

}
