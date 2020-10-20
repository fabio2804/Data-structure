package view;

import controller.CandidatoController;
import controller.EditalController;
import controller.ListaController;
import model.Candidato;
import model.Edital;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    int opc = 0;
    ListaController lista = new ListaController();
    CandidatoController candidato = new CandidatoController();
    EditalController edital = new EditalController();

    do {
      try {
        opc = Integer.parseInt(
                JOptionPane.showInputDialog("Menu de opções\n1- Criar edital\n2- Criar candidato\n3- Verificar " +
                        "lista vazia\n4- Remover candidato por CPF\n5- Ordenar lista de candidatos por nome\n6- " +
                        "Ordenar lista de candidatos por nota\n7- Mostrar lista\n8- Mostrar aprovados\n0- Finalizar " +
                        "programa"));

        switch (opc) {
          case 1:
            Edital novoEdital = edital.criarEdital();
            break;

          case 2:
            Candidato novoCandidato = candidato.criarCandidato();
            lista.adicionarFinal(novoCandidato);
            break;

          case 3:
            if (lista.verificarVazia()) JOptionPane.showMessageDialog(null, "A lista está vazia!");
            else JOptionPane.showMessageDialog(null, "A lista não está vazia");
            break;

          case 4:
            String cpf = JOptionPane.showInputDialog("Digite o CPF a ser removido:");
            lista.removerPorCpf(cpf);
            break;

          case 5:
            lista.ordenarPorNome();
            break;

          case 6:
            lista.ordenarPorNota();
            break;

          case 7:
            lista.mostrarLista();
            break;

          case 8:
            lista.mostrarCandidatosAprovados();
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
