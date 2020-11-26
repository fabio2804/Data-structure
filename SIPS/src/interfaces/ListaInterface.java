package interfaces;

import controller.ListaController;
import model.Candidato;
import model.Edital;

public interface ListaInterface {
  boolean verificarVazia();

  void adicionarFinal(Candidato candidato);

  void removerPorCpf(String cpf, Candidato candidatoAux);

  Candidato mostrarLista(Candidato aux);

  void mostrarCandidatosAprovados(Edital edital, ListaController lista, Candidato aux);

  void MostrarCandidatosPorNome(Edital edital, ListaController lista, Candidato aux);

  Boolean cpfJaExiste(String cpf, ListaController listaController);

}
