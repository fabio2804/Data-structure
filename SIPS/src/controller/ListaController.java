package controller;

import interfaces.ListaInterface;
import model.Candidato;

public class ListaController implements ListaInterface {
  private Candidato inicio;
  private Candidato fim;
  private int qtdElementos;

  public ListaController() {
    this.inicio = null;
    this.fim = null;
    this.qtdElementos = 0;
  }

  @Override
  public boolean verificarVazia() {
    return qtdElementos == 0;
  }

  @Override
  public void adicionarFinal(Candidato candidato) {

  }

  @Override
  public void removerPorCpf(String cpf) {

  }

  @Override
  public void mostrarLista() {

  }

  @Override
  public void mostrarCandidatosAprovados() {

  }

  @Override
  public void ordenarPorNome() {

  }

  @Override
  public void ordenarPorNota() {

  }

}
