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
    ListaController listaController = new ListaController();
    CandidatoController candidatoController = new CandidatoController();
    EditalController editalController = new EditalController();
    Edital edital = null;

    do {
      try {
        opc = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Menu de opções\n1- Criar edital\n2- Criar candidato\n3- Verificar " +
                                "lista vazia\n4- Remover candidato por CPF\n5- Ordenar lista de candidatos por nome\n6- " +
                                "Ordenar lista de candidatos por nota\n7- Mostrar lista\n8- Mostrar aprovados\n9- Gerar notas\n0- Finalizar " +
                                "programa"));

        switch (opc) {
          case 1:
            Edital novoEdital = editalController.criarEdital();
            JOptionPane.showMessageDialog(null, "Edital cadastrado!!");
            edital = novoEdital;
            break;

          case 2:
            if (editalController.verificarEditalVazio(edital)) {
              JOptionPane.showMessageDialog(null, "É necessário criar um edital primeiro!");
              break;
            }

            Candidato novoCandidato = candidatoController.criarCandidato();
            listaController.adicionarFinal(novoCandidato);
            JOptionPane.showMessageDialog(null, "Candidato adicionado à lista.");
            break;

          case 3:
            if (listaController.verificarVazia())
              JOptionPane.showMessageDialog(null, "A lista está vazia!");
            else JOptionPane.showMessageDialog(null, "A lista não está vazia");
            break;

          case 4:
            String cpf = JOptionPane.showInputDialog("Digite o CPF a ser removido:");
            listaController.removerPorCpf(cpf);
            JOptionPane.showMessageDialog(null,
                    "O candidato do CPF: " + cpf + " foi removido da lista.");
            break;

          case 5:
            listaController.ordenarPorNome();
            JOptionPane.showMessageDialog(null, "Lista de candidatos ordenado por nome.");
            break;

          case 6:
            listaController.ordenarPorNota(edital, listaController, listaController.getInicio());
            JOptionPane.showMessageDialog(null, "Lista de candidato ordenado por nota.");
            break;

          case 7:
            System.out.println("[");
            listaController.mostrarLista(listaController.getInicio());
            System.out.println("]");
            break;

          case 8:
            if (editalController.verificarEditalVazio(edital)) {
              JOptionPane.showMessageDialog(null, "É necessário criar um edital primeiro!");
              break;
            }

            listaController.mostrarCandidatosAprovados(listaController.getInicio(), 0,
                    edital.getQtdVagas());
            break;

          case 9:
            candidatoController.gerarNotas(listaController.getInicio());
            JOptionPane.showMessageDialog(null, "As notas dos candidatos foram geradas!");
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
