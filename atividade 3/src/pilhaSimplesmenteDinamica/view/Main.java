package pilhaSimplesmenteDinamica.view;

import pilhaSimplesmenteDinamica.model.Curso;
import pilhaSimplesmenteDinamica.controller.PilhaController;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    int opc = 0;
    PilhaController pilha = new PilhaController();

    do {
      try {
        opc = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu de opções\n1- Verificar lista vazia\n2- Adicionar curso no final\n3- Mostrar pilha\n" +
                        "4- Remover no final\n0- " + "Finalizar programa"));

        switch (opc) {
          case 1:
            if (pilha.listaVazia()) System.out.println("A lista está vazia");
            else System.out.println("A lista não está vazia");
            break;

          case 2:
            Curso pilhaFinal = pilha.criaCurso();
            pilha.adicionaFinal(pilhaFinal);
            break;

          case 3:
            pilha.mostrarLista();
            break;

          case 4:
            pilha.removerFinal();
            break;

          case 0:
            JOptionPane.showMessageDialog(null, "Programa finalizado!");
            break;

          default:
            JOptionPane.showMessageDialog(null, "Opção inválida!");
            break;
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Opção inválida!");
      }

    } while (opc != 0);
  }

}
