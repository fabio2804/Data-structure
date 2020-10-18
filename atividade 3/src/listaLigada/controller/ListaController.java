package listaLigada.controller;

import listaLigada.model.Curso;

import javax.swing.JOptionPane;

public class ListaController {
  private Curso primeiroLista;
  private Curso ultimoLista;
  private int qtdElementos;

  public ListaController() {
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
      this.primeiroLista = novoCurso;
      this.ultimoLista = novoCurso;
    } else {
      novoCurso.setProx(primeiroLista);
      this.primeiroLista = novoCurso;
    }
    this.qtdElementos++;
  }

  public void adicionaFinal(Curso novoCurso) {
    if (listaVazia()) {
      this.primeiroLista = novoCurso;
    } else {
      ultimoLista.setProx(novoCurso);
    }
    this.ultimoLista = novoCurso;
    this.qtdElementos++;
  }

  public void adicionaPosicao(int posicao, Curso novoCurso) {
    if (posicao == this.qtdElementos + 1) adicionaFinal(novoCurso);

    else if (posicao == 1) adicionaInicio(novoCurso);

    else if (posicao > (this.qtdElementos + 1) || posicao < 1) {
      JOptionPane.showMessageDialog(null, "Posição inválida!");
    } else {

      Curso aux = this.primeiroLista;

      for (int i = 0; i < (posicao - 2); i++) {
        aux = aux.getProx();
      }
      novoCurso.setProx(aux.getProx());
      aux.setProx(novoCurso);
      this.qtdElementos++;
    }

  }

  public void removeInicio() {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
    }
    else{
      Curso aux = this.primeiroLista;
      this.primeiroLista = aux.getProx();
      this.qtdElementos--;
    }
  }

  public void removeFinal() {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
      return;
    }
    Curso aux = primeiroLista;

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
      Curso aux = this.primeiroLista;
      Curso aux2;

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
      Curso aux = primeiroLista;
      System.out.print("[ ");
      for (int i = 0; i < (this.qtdElementos); i++) {
        System.out.print("{ "+ aux.getId() + ", " + aux.getNome() + ", " + aux.getArea() +
                ", " + aux.getQtdSemestre() + ", " + aux.getPeriodo() + " } ");
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
      Curso aux = this.primeiroLista;
      for (int i = 0; i < (pos - 1); i++) {
        aux = aux.getProx();
      }

      System.out.print(" { "+ aux.getId() + ", " + aux.getNome() + ", " + aux.getArea() +
              ", " + aux.getQtdSemestre() + ", " + aux.getPeriodo() + " } ");
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
