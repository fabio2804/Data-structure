package filaSimplesmenteDinamica.view;

import filaSimplesmenteDinamica.controller.FilaController;
import filaSimplesmenteDinamica.model.Curso;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    int opc = 0;
    FilaController fila = new FilaController();

    do {
      try {
        opc = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu de opções\n1- Verificar lista vazia\n2- Adicionar curso no final\n3- Mostrar pilha\n" +
                        "4- Remover no inicio\n0- " + "Finalizar programa"));

        switch (opc) {
          case 1:
            if (fila.listaVazia()) System.out.println("A lista está vazia");
            else System.out.println("A lista não está vazia");
            break;

          case 2:
            Curso pilhaFinal = fila.criaCurso();
            fila.adicionaFinal(pilhaFinal);
            break;

          case 3:
            fila.mostrarLista();
            break;

          case 4:
            fila.removerInicio();
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
