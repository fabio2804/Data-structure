package interfaces;

import model.Candidato;

public interface ListaInterface {
  boolean verificarVazia();

  void adicionarFinal(Candidato candidato);

  void removerPorCpf(String cpf);

  Candidato mostrarLista(Candidato aux);

  Candidato mostrarCandidatosAprovados(Candidato aux, int cont, int vagas);

  void ordenarPorNome();

  void ordenarPorNota();

}
