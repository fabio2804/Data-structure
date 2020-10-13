package view;

import controller.ListaDuplamenteEncadeada;
import model.Aluno;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    int opc = 0;
    ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

    do {
      try {
        opc = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu de opções\n1- Verificar lista vazia\n2- Adicionar valor no início\n3- Adicionar valor no " +
                        "final\n4- Remover aluno início\n5- Remover aluno final\n6- Ordenar por nome\n7- Busca por " +
                        "nome\n8- Mostrar elementos\n0- Finalizar programa"));

        switch (opc) {
          case 1:
            if (lista.listaVazia()) System.out.println("A lista está vazia!");
            else System.out.println("A lista não está vazia!");
            break;

          case 2:
            Aluno alunoInicio = lista.criaAluno();
            lista.adicionaInicio(alunoInicio);
            break;

          case 3:
            Aluno alunoFinal = lista.criaAluno();
            lista.adicionaFinal(alunoFinal);
            break;

          case 4:
            lista.removeInicio();
            break;

          case 5:
            lista.removeFinal();
            break;

          case 6:
            lista.bubbleSort(lista.getPrimeiroLista());
            break;

          case 7:
            String nome = JOptionPane.showInputDialog("Digite um nome para fazer a busca: ");
            lista.buscaSequencial(lista.getPrimeiroLista(), nome);
            break;

          case 8:
            System.out.print("[ ");
            lista.mostrarLista(lista.getPrimeiroLista());
            System.out.print("]");
            System.out.println();
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
