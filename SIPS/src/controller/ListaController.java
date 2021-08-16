package controller;

import interfaces.ListaInterface;
import model.Candidato;
import model.Edital;

import javax.swing.text.MaskFormatter;
import java.text.DecimalFormat;
import java.text.ParseException;

public class ListaController implements ListaInterface {
  private Candidato inicio;
  private Candidato fim;
  private int qtdElementos;
  private Candidato[] arrayCandidatos;

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
  public void removerPorCpf(String cpf, Candidato candidatoAux) {
    if (verificarVazia()) {
      System.out.println("A lista está vazia!");
      return;
    }

    if (candidatoAux.getCpf().equals(cpf)) {
      if (qtdElementos == 1) {
        inicio = null;
        fim = null;
        qtdElementos--;
        return;
      }

      if (candidatoAux.getAnterior() != null && candidatoAux.getProx() == null) {
        candidatoAux.getAnterior().setProx(null);
        fim = candidatoAux.getAnterior();
        qtdElementos--;
        return;
      }

      if (candidatoAux.getAnterior() == null && candidatoAux.getProx() != null) {
        candidatoAux.getProx().setAnterior(null);
        inicio = candidatoAux.getProx();
        qtdElementos--;
        return;
      }

      candidatoAux.getAnterior().setProx(candidatoAux.getProx());
      candidatoAux.getProx().setAnterior(candidatoAux.getAnterior());
      qtdElementos--;
      return;
    }

    removerPorCpf(cpf, candidatoAux.getProx());
  }

  @Override
  public Candidato mostrarLista(Candidato aux) {
    if (verificarVazia()) {
      System.out.println("Lista Vazia");
      return null;
    }

    String notaFormatada = new DecimalFormat("##.##").format(aux.getNota());

    String cpfFormatado = null;

    try {
      cpfFormatado = formatarString(aux.getCpf(), "###.###.###-##");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    System.out.println("   { Nome: " + aux.getNome() + ", CPF: " + cpfFormatado + ", Ano de nascimento: "
        + aux.getAnoNascimento() + ", Nota: " + notaFormatada + " } ");

    if (aux.getProx() == null) {
      return null;
    }

    return mostrarLista(aux.getProx());
  }

  @Override
  public Boolean cpfJaExiste(String cpf, ListaController lista) {
    Candidato candidatoAux = lista.getInicio();

    while (candidatoAux != null) {
      if (candidatoAux.getCpf().equals(cpf))
        return true;

      candidatoAux = candidatoAux.getProx();
    }

    return false;
  }

  @Override
  public void mostrarCandidatosAprovados(Edital edital, ListaController lista, Candidato aux) {
    if (verificarVazia()) {
      System.out.println("Lista Vazia");
      return;
    }

    arrayCandidatos = new Candidato[qtdElementos];

    for (int i = 0; i < qtdElementos; i++) {
      arrayCandidatos[i] = aux;
      aux = aux.getProx();
    }

    quicksortNota(0, arrayCandidatos.length - 1);

    System.out.println("Lista de aprovados");

    int pos = 1;

    for (int i = arrayCandidatos.length - 1; i > ((arrayCandidatos.length - 1) - edital.getQtdVagas()); i--) {
      if (i < 0)
        return;

      String notaFormatada = new DecimalFormat("##.##").format(arrayCandidatos[i].getNota());

      String cpfFormatado = null;

      try {
        cpfFormatado = formatarString(arrayCandidatos[i].getCpf(), "###.###.###-##");
      } catch (ParseException e) {
        e.printStackTrace();
      }

      System.out.println("   " + pos + "°  { Nome: " + arrayCandidatos[i].getNome() + ", CPF: " + cpfFormatado
          + ", Ano de nascimento: " + arrayCandidatos[i].getAnoNascimento() + ", Nota: " + notaFormatada + " } ");

      pos++;
    }
  }

  @Override
  public void MostrarCandidatosPorNome(Edital edital, ListaController lista, Candidato aux) {
    if (verificarVazia()) {
      System.out.println("Lista Vazia");
      return;
    }

    arrayCandidatos = new Candidato[qtdElementos];

    for (int i = 0; i < qtdElementos; i++) {
      arrayCandidatos[i] = aux;
      aux = aux.getProx();
    }

    quicksortNome(0, arrayCandidatos.length - 1);

    System.out.println("Lista Ordenada por nome");

    for (int i = arrayCandidatos.length - 1; i > ((arrayCandidatos.length - 1) - edital.getQtdVagas()); i--) {
      if (i < 0)
        return;

      String notaFormatada = new DecimalFormat("##.##").format(arrayCandidatos[i].getNota());

      String cpfFormatado = null;

      try {
        cpfFormatado = formatarString(arrayCandidatos[i].getCpf(), "###.###.###-##");
      } catch (ParseException e) {
        e.printStackTrace();
      }

      System.out.println("   { Nome: " + arrayCandidatos[i].getNome() + ", CPF: " + cpfFormatado
          + ", Ano de nascimento: " + arrayCandidatos[i].getAnoNascimento() + ", Nota: " + notaFormatada + " } ");
    }
  }

  public static String formatarString(String texto, String mascara) throws ParseException {
    MaskFormatter mf = new MaskFormatter(mascara);
    mf.setValueContainsLiteralCharacters(false);
    return mf.valueToString(texto);
  }

  private int particaoNota(int start, int end) {
    int i = start;

    for (int j = start; j < end; j++) {

      /* Elemento atual menor ou igual ao pivô? */
      if (arrayCandidatos[j].getNota() <= arrayCandidatos[end].getNota()) {
        swap(i++, j);
      }
    }
    swap(i, end);

    return i;
  }

  private int particaoNome(int start, int end) {
    int i = start;

    for (int j = start; j < end; j++) {

      /* Elemento atual menor ou igual ao pivô? */
      if (arrayCandidatos[j].getNome().compareTo(arrayCandidatos[end].getNome()) > 0) {
        swap(i++, j);
      }
    }
    swap(i, end);

    return i;
  }

  private void swap(int i, int j) {
    Candidato aux = arrayCandidatos[i];
    arrayCandidatos[i] = arrayCandidatos[j];
    arrayCandidatos[j] = aux;
  }

  private void quicksortNota(int start, int end) {
    if (start >= end)
      return;

    int pivot = particaoNota(start, end);

    quicksortNota(start, pivot - 1);
    quicksortNota(pivot + 1, end);
  }

  private void quicksortNome(int start, int end) {
    if (start >= end)
      return;

    int pivot = particaoNome(start, end);

    quicksortNome(start, pivot - 1);
    quicksortNome(pivot + 1, end);
  }

  public Candidato getInicio() {
    return inicio;
  }

  public Candidato getFim() {
    return fim;
  }

  public Candidato[] getArray() {
    return arrayCandidatos;
  }

}
