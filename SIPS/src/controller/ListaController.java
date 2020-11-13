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

    System.out.println("   { Nome: " + aux.getNome() + ", CPF: " + cpfFormatado + ", Ano de nascimento: " +
            aux.getAnoNascimento() + ", Nota: " + notaFormatada + " } ");

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

    String notaFormatada = new DecimalFormat("##.##").format(aux.getNota());

    String cpfFormatado = null;

    try {
      cpfFormatado = formatarString(aux.getCpf(), "###.###.###-##");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    if (cont <= vagas) {
      System.out.println("   { Nome: " + aux.getNome() + ", CPF: " + cpfFormatado + ", Ano de nascimento: " +
              aux.getAnoNascimento() + ", Nota: " + notaFormatada + " } ");
      cont++;
    }

    return mostrarCandidatosAprovados(aux.getProx(), cont, vagas);
  }

  @Override
  public void ordenarPorNome() {
  }

  @Override
  public Candidato ordenarPorNota(Edital edital, ListaController lista, Candidato aux) {
    return aux;
  }

  @Override
  public Boolean cpfJaExiste(String cpf, ListaController lista) {
    Candidato candidatoAux = lista.getInicio();

    while (candidatoAux != null) {
      if (candidatoAux.getCpf().equals(cpf)) return true;

      candidatoAux = candidatoAux.getProx();
    }

    return false;
  }

  public static String formatarString(String texto, String mascara) throws ParseException {
    MaskFormatter mf = new MaskFormatter(mascara);
    mf.setValueContainsLiteralCharacters(false);
    return mf.valueToString(texto);
  }

  public Candidato getInicio() {
    return inicio;
  }

  public Candidato getFim() {
    return fim;
  }

}
