package listaDuplamenteLigada.view;

import listaDuplamenteLigada.controller.ListaDuplamenteLigadaController;
import listaDuplamenteLigada.model.Curso;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    int opc = 0;
    ListaDuplamenteLigadaController lista = new ListaDuplamenteLigadaController();

    do {
      try {
        opc = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu de opções\n1- Verificar lista vazia\n2- Adicionar curso no início\n3- Adicionar curso no " +
                        "final\n4- Remover curso início\n5- Remover curso final\n6- Adicionar por posição\n7- " +
                        "remover por posição\n8- Mostrar elementos\n0- Finalizar programa"));

        switch (opc) {
          case 1:
            if (lista.listaVazia()) System.out.println("A lista está vazia!");
            else System.out.println("A lista não está vazia!");
            break;

          case 2:
            Curso cursoInicio = lista.criaCurso();
            lista.adicionaInicio(cursoInicio);
            break;

          case 3:
            Curso cursoFinal = lista.criaCurso();
            lista.adicionaFinal(cursoFinal);
            break;

          case 4:
            lista.removeInicio();
            break;

          case 5:
            lista.removeFinal();
            break;

          case 6:
            Curso cursoMeio = lista.criaCurso();
            int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja adicionar o " +
                    "elemento:"));
            lista.adicionaPosicao(cursoMeio, pos);
            break;

          case 7:
            int posRemove = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja adicionar o " +
                    "elemento:"));
            lista.removePosicao(posRemove);
            break;

          case 8:
            lista.mostrarLista(lista.getPrimeiroLista());
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
