package view;

import controller.CandidatoController;
import controller.EditalController;
import controller.GeradorDoc;
import controller.ListaController;
import model.Candidato;
import model.Edital;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) throws IOException {
    int opc = 0;
    ListaController listaController = new ListaController();
    CandidatoController candidatoController = new CandidatoController();
    EditalController editalController = new EditalController();
    GeradorDoc geradorDoc = new GeradorDoc();
    Edital edital = null;

    do {
      try {
        opc = Integer
            .parseInt(JOptionPane.showInputDialog("Menu de opções\n1- Criar edital\n2- Criar candidato\n3- Verificar "
                + "lista vazia\n4- Remover candidato por CPF\n5- Mostrar candidatos por nome\n6- "
                + "Mostrar candidatos aprovados\n7- Mostrar lista\n8- Gerar " + "notas\n9- Gerar txt\n0- Finalizar "
                + "programa"));

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

            if (novoCandidato == null)
              break;

            if (listaController.cpfJaExiste(novoCandidato.getCpf(), listaController)) {
              JOptionPane.showMessageDialog(null, "Candidato com este CPF já cadastrado!");
              break;
            }

            listaController.adicionarFinal(novoCandidato);
            JOptionPane.showMessageDialog(null, "Candidato adicionado à lista.");
            break;

          case 3:
            if (editalController.verificarEditalVazio(edital)) {
              JOptionPane.showMessageDialog(null, "É necessário criar um edital primeiro!");
              break;
            }

            if (listaController.verificarVazia())
              JOptionPane.showMessageDialog(null, "A lista está vazia!");
            else
              JOptionPane.showMessageDialog(null, "A lista não está vazia");
            break;

          case 4:
            if (editalController.verificarEditalVazio(edital)) {
              JOptionPane.showMessageDialog(null, "É necessário criar um edital primeiro!");
              break;
            }

            String cpf = JOptionPane.showInputDialog("Digite o CPF a ser removido:");
            listaController.removerPorCpf(cpf, listaController.getInicio());
            JOptionPane.showMessageDialog(null, "O candidato do CPF: " + cpf + " foi removido da lista.");
            break;

          case 5:
            if (editalController.verificarEditalVazio(edital)) {
              JOptionPane.showMessageDialog(null, "É necessário criar um edital primeiro!");
              break;
            }

            System.out.println("[");
            listaController.MostrarCandidatosPorNome(edital, listaController, listaController.getInicio());
            System.out.println("]");
            JOptionPane.showMessageDialog(null, "Lista de candidatos ordenado por nome.");
            break;

          case 6:
            if (editalController.verificarEditalVazio(edital)) {
              JOptionPane.showMessageDialog(null, "É necessário criar um edital primeiro!");
              break;
            }
            System.out.println("[");
            listaController.mostrarCandidatosAprovados(edital, listaController, listaController.getInicio());
            System.out.println("]");
            JOptionPane.showMessageDialog(null, "Candidatos aprovados no console");
            break;

          case 7:
            System.out.println("[");
            System.out.println("Lista de candidatos");
            listaController.mostrarLista(listaController.getInicio());
            System.out.println("]");
            break;

          case 8:
            candidatoController.gerarNotas(listaController.getInicio());
            JOptionPane.showMessageDialog(null, "As notas dos candidatos foram geradas!");
            break;

          case 9:
            geradorDoc.gerarDoc(edital, listaController.getArray());
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
