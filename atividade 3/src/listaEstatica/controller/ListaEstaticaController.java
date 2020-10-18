package listaEstatica.controller;

import listaEstatica.model.Curso;

import javax.swing.JOptionPane;

public class ListaEstaticaController {
  public int tamanho = 0;
  Curso[] vet = new Curso[5];

  public boolean verificaVazia() {
    return tamanho == 0;
  }

  public boolean verificaCheia() {
    return (tamanho == vet.length);
  }

  public void adicionaInicio() {
    if (verificaCheia()) {
      System.out.println("Vetor cheio para adicionar valores!");
      return;
    }

    int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do curso:"));
    String nome = JOptionPane.showInputDialog("Digite o nome do curso:");
    String area = JOptionPane.showInputDialog("Digite a area do curso:");
    int qtdSemestre = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de semestres do curso:"));
    String periodo = JOptionPane.showInputDialog("Digite o período do curso:");

    Curso curso = new Curso(id, nome, area, qtdSemestre, periodo);

    if (vet[0] == null) {
      vet[0] = curso;
    } else {
      for (int i = (tamanho); i >= 0; i--) {
        if (i == 0) {
          vet[i] = curso;
          break;
        }
        vet[i] = vet[i - 1];
      }
    }
    tamanho++;
  }

  public void adicionaFinal() {
    if (verificaCheia()) {
      System.out.println("Vetor cheio para adicionar valores!");
      return;
    }

    int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do curso:"));
    String nome = JOptionPane.showInputDialog("Digite o nome do curso:");
    String area = JOptionPane.showInputDialog("Digite a area do curso:");
    int qtdSemestre = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de semestres do curso:"));
    String periodo = JOptionPane.showInputDialog("Digite o período do curso:");

    Curso curso = new Curso(id, nome, area, qtdSemestre, periodo);

    vet[tamanho] = curso;
    tamanho++;
  }

  public void adicionaMeio() {
    if (verificaCheia()) {
      System.out.println("Vetor cheio para adicionar valores!");
      return;
    }

    int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que quer adicionar um valor no vetor: "));

    try {
      if (pos == 1) {
        adicionaInicio();
      } else if (pos == vet.length) {
        adicionaFinal();
      } else {
        if ((pos - 1) < 0 || (pos - 1) > vet.length) {
          JOptionPane.showMessageDialog(null, "A lista não possui esta posição");
          return;
        }

        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do curso:"));
        String nome = JOptionPane.showInputDialog("Digite o nome do curso:");
        String area = JOptionPane.showInputDialog("Digite a area do curso:");
        int qtdSemestre = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de semestres do curso:"));
        String periodo = JOptionPane.showInputDialog("Digite o período do curso:");

        Curso curso = new Curso(id, nome, area, qtdSemestre, periodo);

        for (int i = (tamanho); i > 0; i--) {

          if (i == (pos - 1))
            vet[i] = curso;

          else
            vet[i] = vet[i - 1];
        }
        tamanho++;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      JOptionPane.showMessageDialog(null, "A lista não possui esta posi��o");
    }
  }

  public Curso[] excluirInicio() {
    if (verificaVazia()) {
      System.out.println("A lista está vazia!");
      return vet;
    }

    Curso aux = vet[0];

    for (int i = 0; i < (tamanho); i++) {
      if (i == (tamanho - 1)) {
        vet[i] = null;
        break;
      }
      vet[i] = vet[i + 1];
    }

    tamanho--;
    JOptionPane.showMessageDialog(null, "curso de id: " +aux.getId()+ " removido");
    return vet;
  }

  public Curso[] excluirFinal() {
    if (verificaVazia()) {
      System.out.println("A lista está vazia!");
      return vet;
    }

    Curso aux = vet[(tamanho - 1)];

    vet[tamanho - 1] = null;

    tamanho--;
    JOptionPane.showMessageDialog(null, "curso de id: " +aux.getId()+ " removido");
    return vet;
  }

  public void excluirMeio() {
    int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que quer excluir do vetor: "));
    try {

      if (verificaVazia()) {
        System.out.println("A lista está vazia!");
      }

      if (pos == 1) {
        vet = excluirInicio();
        return;
      } else if (pos == vet.length) {
        vet = excluirFinal();
        return;
      } else {
        if ((pos - 1) < 0 || (pos - 1) > vet.length) {
          JOptionPane.showMessageDialog(null, "A lista não possui esta posição");
          return;
        }

        int id = vet[pos-1].getId();

        for (int i = 0; i < tamanho - 1; i++) {
          if (i >= (pos - 1))
            vet[i] = vet[i + 1];
        }
      JOptionPane.showMessageDialog(null, "Curso de id: " +id+ " removido");
      }
      tamanho--;
    } catch (ArrayIndexOutOfBoundsException e) {
      JOptionPane.showMessageDialog(null, "A lista não possui esta posição");
    }
  }

  public void mostraVetor() {
    System.out.print("[");
    for (int i = 0; i < tamanho; i++) {
      System.out.print(" { " + vet[i].getId() + ", " + vet[i].getNome() + ", " + vet[i].getArea() + ", " +
              vet[i].getQtdSemestre() + ", " + vet[i].getPeriodo()+ " }");
    }
    System.out.print(" ]");
    System.out.println();

  }

}
