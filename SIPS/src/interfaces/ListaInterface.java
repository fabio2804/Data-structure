package interfaces;

import model.Candidato;

public interface ListaInterface {
  boolean verificarVazia();

  void adicionarFinal(Candidato candidato);

  void removerPorCpf(String cpf);

  void mostrarLista();

  void mostrarCandidatosAprovados();

  void ordenarPorNome();

  void ordenarPorNota();

}
