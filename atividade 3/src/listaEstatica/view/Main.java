package listaEstatica.view;

import javax.swing.JOptionPane;

import listaEstatica.controller.ListaEstaticaController;

public class Main {
  public static void main(String[] args) {
    int opc;
    ListaEstaticaController lista = new ListaEstaticaController();

    do {
      opc = Integer.parseInt(JOptionPane.showInputDialog(
              "1 - Verificar lista vazia\n2 - Verifica lista cheia\n3 - Adicionar curso no início\n4 - Adicionar " +
                      "curso no final\n5 - Adicionar curso por posição\n6 - Mostrar lista\n7 - Excluir curso do " +
                      "inicio\n8 - Excluir curso do fim da lista\n9 - Excluir curso por posição\n0 - Finalizar " +
                      "programa"));

      switch (opc) {
        case 1:
          if (lista.verificaVazia())
            System.out.println("A lista está vazia!");
          else
            System.out.println("A lista não está vazia!");
          break;

        case 2:
          if (lista.verificaCheia())
            System.out.println("A lista está cheia!");
          else
            System.out.println("A lista não está cheia!");
          break;

        case 3:
          lista.adicionaInicio();
          break;

        case 4:
          lista.adicionaFinal();
          break;

        case 5:
          lista.adicionaMeio();
          break;

        case 6:
          lista.mostraVetor();
          break;

        case 7:
          lista.excluirInicio();
          break;

        case 8:
          lista.excluirFinal();
          break;

        case 9:
          lista.excluirMeio();
          break;

        case 0:
          JOptionPane.showMessageDialog(null, "Programa finalizado!");
          break;

        default:
          JOptionPane.showMessageDialog(null, "Opção inválida!");
          break;
      }

    } while (opc != 0);
  }
}
