package filaSimplesmenteDinamica.controller;

import filaSimplesmenteDinamica.model.Curso;

import javax.swing.JOptionPane;

public class FilaController {
    private Curso primeiroLista;
    private Curso ultimoLista;
    private int qtdElementos;

    public FilaController() {
      this.primeiroLista = null;
      this.ultimoLista = null;
      this.qtdElementos = 0;
    }

    public boolean listaVazia() {
      return qtdElementos == 0;
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

  public void removerInicio() {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
    }
    else{
      Curso aux = this.primeiroLista;
      this.primeiroLista = aux.getProx();
      this.qtdElementos--;
    }
  }

    public void mostrarLista() {
      if (listaVazia()) System.out.println("[]");
      else {
        Curso aux = primeiroLista;
        System.out.print("[");
        for (int i = 0; i < (this.qtdElementos); i++) {
          System.out.print(" { "+ aux.getId() + ", " + aux.getNome() + ", " + aux.getArea() +
                  ", " + aux.getQtdSemestre() + ", " + aux.getPeriodo() + " } ");
          aux = aux.getProx();
        }
        System.out.print("]");
        System.out.println();
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
