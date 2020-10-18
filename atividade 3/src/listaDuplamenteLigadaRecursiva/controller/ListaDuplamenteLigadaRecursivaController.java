package listaDuplamenteLigadaRecursiva.controller;

import listaDuplamenteLigadaRecursiva.model.Curso;

import javax.swing.JOptionPane;

public class ListaDuplamenteLigadaRecursivaController {
  private Curso primeiroLista;
  private Curso ultimoLista;
  private int qtdElementos;

  public ListaDuplamenteLigadaRecursivaController() {
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

  public Curso getPrimeiroLista() {
    return primeiroLista;
  }

  public Curso mostrarLista(Curso aux) {
    if (listaVazia()) {
      return null;
    }
    if (aux.getProx() == null) {
      System.out.print("{ " + aux.getId() + ", " + aux.getNome() + ", " + aux.getArea() + ", " + aux.getQtdSemestre() +
              ", " + aux.getPeriodo() + " } ");
      return null;
    } else {
      System.out.print("{ " + aux.getId() + ", " + aux.getNome() + ", " + aux.getArea() + ", " + aux.getQtdSemestre() +
              ", " + aux.getPeriodo() + " } ");
      return mostrarLista(aux.getProx());
    }
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
