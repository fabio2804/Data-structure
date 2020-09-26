package view;

import controller.ListaEncadeadaSimples;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    int opc = 0;
    ListaEncadeadaSimples listaEncadeadaSimples = new ListaEncadeadaSimples();

    do {
      try {
        opc = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu de opções\n1- Verificar lista vazia\n2- Adicionar valor no início\n3- Adicionar valor no final\n" +
                        "4- Adicionar" + " valor por posição\n5- Mostrar lista\n6- Excluir valor do inicio\n7- Excluir " +
                        "valor por pos" + "ição\n8- Excluir valor do final\n9- Buscar elemento por posição\n" + "0- " +
                        "F" + "" + "inalizar programa"));

        switch (opc) {
          case 1:
            if (listaEncadeadaSimples.listaVazia()) System.out.println("A lista está vazia");
            else System.out.println("A lista não está vazia");
            break;

          case 2:
            float valorTempInicio = Float.parseFloat(JOptionPane.showInputDialog("Digite uma temperatura a ser inserida" +
                    " no início da lista"));
            listaEncadeadaSimples.adicionaInicio(valorTempInicio);
            break;

          case 3:
            float valorTempFinal = Float.parseFloat(JOptionPane.showInputDialog("Digite uma temperatura a ser inserida" +
                    " no final da lista"));
            listaEncadeadaSimples.adicionaFinal(valorTempFinal);
            break;

          case 4:
            int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja adicionar a temperatura" +
                    ""));
            float valorTempPos = Float.parseFloat(JOptionPane.showInputDialog("Digite uma temperatura a ser inserida no" +
                    " final da lista"));
            listaEncadeadaSimples.adicionaPosicao((pos), valorTempPos);
            break;

          case 5:
            listaEncadeadaSimples.mostrarLista();
            break;

          case 6:
            listaEncadeadaSimples.removeInicio();
            break;

          case 7:
            int posRemove = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja remover da lista"));
            listaEncadeadaSimples.removePosicao(posRemove);
            break;

          case 8:
            listaEncadeadaSimples.removeFinal();
            break;

          case 9:
            int posBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que deseja buscar na lista"));
            listaEncadeadaSimples.buscaPorPosicao(posBusca);
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
