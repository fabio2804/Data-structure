package interfaces;

import controller.ListaController;
import model.Candidato;
import model.Edital;

public interface ListaInterface {
  boolean verificarVazia();

  void adicionarFinal(Candidato candidato);

  void removerPorCpf(String cpf, Candidato candidatoAux);

  Candidato mostrarLista(Candidato aux);

  Candidato mostrarCandidatosAprovados(Candidato aux, int cont, int vagas);

  void ordenarPorNome();

  Candidato ordenarPorNota(Edital edital, ListaController lista, Candidato aux);

}
