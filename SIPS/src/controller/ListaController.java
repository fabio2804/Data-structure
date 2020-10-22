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
  public void adicionarFinal(Candidato novoCandidato) {
    if (verificarVazia()) {
      this.inicio = novoCandidato;
    } else {
      novoCandidato.setAnterior(fim);
      fim.setProx(novoCandidato);
    }

    this.fim = novoCandidato;
    this.qtdElementos++;
  }

  @Override
  public void removerPorCpf(String cpf) {

  }

  @Override
  public Candidato mostrarLista(Candidato aux) {
    if (verificarVazia()) {
      System.out.println("Lista Vazia");
      return null;
    }

    System.out.println("   { Nome: " + aux.getNome() + ", CPF: " + aux.getCpf() + ", Ano de nascimento: " +
            aux.getAnoNascimento() + ", Nota: " + aux.getNota() + " } ");

    if (aux.getProx() == null) {
      return null;
    }

    return mostrarLista(aux.getProx());
  }

  @Override
  public Candidato mostrarCandidatosAprovados(Candidato aux, int cont, int vagas) {
    if (verificarVazia()) {
      System.out.println("Lista Vazia");
      return null;
    }

    if (aux.getProx() == null) {
      return null;
    }

    if (cont <= vagas) {
      System.out.println("   { Nome: " + aux.getNome() + ", CPF: " + aux.getCpf() + ", Ano de nascimento: " +
              aux.getAnoNascimento() + ", Nota: " + aux.getNota() + " } ");
      cont++;
    }

    return mostrarCandidatosAprovados(aux.getProx(), cont, vagas);
  }

  @Override
  public void ordenarPorNome() {

  }

  @Override
  public void ordenarPorNota() {

  }

  public Candidato getInicio() {
    return inicio;
  }

  public void setInicio(Candidato inicio) {
    this.inicio = inicio;
  }

  public Candidato getFim() {
    return fim;
  }

  public void setFim(Candidato fim) {
    this.fim = fim;
  }

  public int getQtdElementos() {
    return qtdElementos;
  }

  public void setQtdElementos(int qtdElementos) {
    this.qtdElementos = qtdElementos;
  }

}
