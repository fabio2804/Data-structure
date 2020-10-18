package listaLigada.view;

import listaLigada.controller.ListaController;
import listaLigada.model.Curso;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    int opc = 0;
    ListaController lista = new ListaController();

    do {
      try {
        opc = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu de opções\n1- Verificar lista vazia\n2- Adicionar valor no início\n3- Adicionar valor no " +
                        "final\n" +
                        "4- Adicionar valor por posição\n5- Mostrar lista\n6- Excluir valor do inicio\n7- Excluir " +
                        "valor por pos" + "ição\n8- Excluir valor do final\n9- Buscar elemento por posição\n" + "0- " +
                        "F" + "" + "inalizar programa"));

        switch (opc) {
          case 1:
            if (lista.listaVazia()) System.out.println("A lista está vazia");
            else System.out.println("A lista não está vazia");
            break;

          case 2:
            Curso cursoInicio = lista.criaCurso();
            lista.adicionaInicio(cursoInicio);
            break;

          case 3:
            Curso pilhaFinal = lista.criaCurso();
            lista.adicionaFinal(pilhaFinal);
            break;

          case 4:
            int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja adicionar um aluno" +
                    ""));
            Curso cursoMeio = lista.criaCurso();
            lista.adicionaPosicao((pos), cursoMeio);
            break;

          case 5:
            lista.mostrarLista();
            break;

          case 6:
            lista.removeInicio();
            break;

          case 7:
            int posRemove =
                    Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja remover da lista"));
            lista.removePosicao(posRemove);
            break;

          case 8:
            lista.removeFinal();
            break;

          case 9:
            int posBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja buscar na lista"));
            lista.buscaPorPosicao(posBusca);
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
