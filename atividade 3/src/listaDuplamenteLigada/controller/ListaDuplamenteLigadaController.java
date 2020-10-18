package listaDuplamenteLigada.controller;

import listaDuplamenteLigada.model.Curso;

import javax.swing.JOptionPane;

public class ListaDuplamenteLigadaController {
  private Curso primeiroLista;
  private Curso ultimoLista;
  private int qtdElementos;

  public ListaDuplamenteLigadaController() {
    this.primeiroLista = null;
    this.ultimoLista = null;
    this.qtdElementos = 0;
  }

  public boolean listaVazia() {
    return qtdElementos == 0;
  }

  public void adicionaInicio(Curso novoCurso) {

    if (listaVazia()) {
      novoCurso.setProx(primeiroLista);
      primeiroLista = novoCurso;
      ultimoLista = novoCurso;
    } else {
      primeiroLista.setAnterior(novoCurso);
      novoCurso.setProx(primeiroLista);
      primeiroLista = novoCurso;
    }
    this.qtdElementos++;
  }

  public void removeInicio() {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
    } else if (qtdElementos == 1) {
      primeiroLista = null;
      qtdElementos--;
    } else {
      Curso aux = primeiroLista;
      primeiroLista = aux.getProx();
      primeiroLista.setAnterior(null);
      qtdElementos--;
    }
  }

  public void adicionaFinal(Curso novoCurso) {
    if (listaVazia()) {
      adicionaInicio(novoCurso);
      return;
    }
    novoCurso.setAnterior(ultimoLista);
    ultimoLista.setProx(novoCurso);

    this.ultimoLista = novoCurso;
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

    Curso aux = ultimoLista.getAnterior();

    aux.setProx(null);

    qtdElementos--;
  }

  public void adicionaPosicao(Curso novoCurso, int pos) {
    if (pos == 1){
      adicionaInicio(novoCurso);
      return;
    }

    if (pos < 1 || pos > qtdElementos) {
      JOptionPane.showMessageDialog(null, "Posição inválida!");
      return;
    }

    if (pos == (qtdElementos)) {
      adicionaFinal(novoCurso);
      return;
    }

    Curso aux = primeiroLista;

    for (int i = 0; i < pos - 2; i++) {
      aux = aux.getProx();
    }

    novoCurso.setProx(aux.getProx());
    novoCurso.setAnterior(aux);
    aux.setProx(novoCurso);
    qtdElementos++;
  }

  public void removePosicao(int pos) {
    if (pos < 1 || pos > qtdElementos) {
      JOptionPane.showMessageDialog(null, "Posição inválida!");
      return;
    }

    if (pos == 1){
      removeInicio();
      return;
    }

    if (pos == (qtdElementos)) {
      removeFinal();
      return;
    }

    Curso aux = primeiroLista;

    for (int i = 0; i < pos - 1; i++) {
      aux = aux.getProx();
    }

    aux.getAnterior().setProx(aux.getProx());
    aux.getProx().setAnterior(aux.getAnterior());
    qtdElementos--;
  }

  public Curso getPrimeiroLista() {
    return primeiroLista;
  }

  public void mostrarLista(Curso aux) {
    if (listaVazia()) {
      System.out.print("[]");
      System.out.println();
      return;
    }

    System.out.print("[");

    if (qtdElementos == 1) {
      System.out.print(" { " + aux.getId() + ", " + aux.getNome() + ", " + aux.getArea() + ", " + aux.getQtdSemestre() +
              ", " + aux.getPeriodo() + " } ");
    } else {
      while (aux != null) {
        System.out
                .print(" { " + aux.getId() + ", " + aux.getNome() + ", " + aux.getArea() + ", " + aux.getQtdSemestre() +
                        ", " + aux.getPeriodo() + " } ");
        aux = aux.getProx();
        }
      }
      System.out.print("]");
      System.out.println();
  }

  public Curso criaCurso() {
    int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do curso:"));
    String nome = JOptionPane.showInputDialog("Digite o nome do curso:");
    String area = JOptionPane.showInputDialog("Digite a area do curso:");
    int qtdSemestre = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de semestres do curso:"));
    String periodo = JOptionPane.showInputDialog("Digite o período do curso:");

    Curso curso = new Curso();

    curso.setId(id);
    curso.setNome(nome);
    curso.setArea(area);
    curso.setQtdSemestre(qtdSemestre);
    curso.setPeriodo(periodo);

    return curso;
  }

}
