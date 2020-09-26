package controller;

import models.Temperatura;

import javax.swing.*;

public class ListaEncadeadaSimples {

  private Temperatura primeiroLista;
  private Temperatura ultimoLista;
  private int qtdTemperatura;

  //---------------------------- CONSTRUCTOR ----------------------------------------//
  public ListaEncadeadaSimples() {
    this.primeiroLista = null;
    this.ultimoLista = null;
    this.qtdTemperatura = 0;
  }

  //---------------------------- METHODS----------------------------------------//
  public boolean listaVazia() {
    return qtdTemperatura == 0;
  }

  public void adicionaInicio(float valorTemp) {
    if (listaVazia()) {
      Temperatura novaTemperaturaInicio = new Temperatura();
      novaTemperaturaInicio.setTemperatura(valorTemp);
      novaTemperaturaInicio.setProx(primeiroLista);
      this.primeiroLista = novaTemperaturaInicio;
      this.ultimoLista = novaTemperaturaInicio;
    } else {
      Temperatura novaTemperaturaInicio = new Temperatura();
      novaTemperaturaInicio.setTemperatura(valorTemp);
      novaTemperaturaInicio.setProx(primeiroLista);
      this.primeiroLista = novaTemperaturaInicio;
    }
    this.qtdTemperatura++;
  }

  public void adicionaFinal(float valorTemp) {
    Temperatura novaTemperaturaFinal = new Temperatura();
    novaTemperaturaFinal.setTemperatura(valorTemp);
    novaTemperaturaFinal.setProx(null);

    if (listaVazia()) {
      this.primeiroLista = novaTemperaturaFinal;
    } else {
      ultimoLista.setProx(novaTemperaturaFinal);
    }
    this.ultimoLista = novaTemperaturaFinal;
    this.qtdTemperatura++;
  }

  public void mostrarLista() {
    if (listaVazia()) System.out.println("[]");
    else {
      Temperatura aux = primeiroLista;
      System.out.print("[");
      for (int i = 0; i < (this.qtdTemperatura - 1); i++) {
        System.out.print(aux.getTemperatura() + ", ");
        aux = aux.getProx();
      }
      System.out.print(aux.getTemperatura() + "]");
      System.out.println();
    }
  }

  public void adicionaPosicao(int posicao, float valorTemp) {
    if (posicao == this.qtdTemperatura + 1) adicionaFinal(valorTemp);

    else if (posicao == 1) adicionaInicio(valorTemp);

    else if (posicao > (this.qtdTemperatura + 1) || posicao < 1) {
      JOptionPane.showMessageDialog(null, "Posição inválida!");
    } else {
      Temperatura novaTemperaturaPos = new Temperatura();
      Temperatura aux = this.primeiroLista;

      for (int i = 0; i < (posicao - 2); i++) {
        aux = aux.getProx();
      }
      novaTemperaturaPos.setTemperatura(valorTemp);
      novaTemperaturaPos.setProx(aux.getProx());
      aux.setProx(novaTemperaturaPos);
      this.qtdTemperatura++;
    }

  }

  public void removeInicio() {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
      return;
    }

    Temperatura aux = this.primeiroLista;
    this.primeiroLista = aux.getProx();
    this.qtdTemperatura--;
  }

  public void removePosicao(int posicao) {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
      return;
    }
    if (posicao > qtdTemperatura || posicao < 1) {
      JOptionPane.showMessageDialog(null, "Posição inválida!");
    } else if (posicao == 1) {
      removeInicio();
    } else if (posicao == this.qtdTemperatura) {
      removeFinal();
    } else {
      Temperatura aux = this.primeiroLista;
      Temperatura aux2;

      for (int i = 0; i < (posicao - 2); i++) {
        aux = aux.getProx();
      }
      aux2 = aux.getProx();
      aux.setProx(aux2.getProx());

      this.qtdTemperatura--;
    }
  }

  public void removeFinal() {
    if (listaVazia()) {
      JOptionPane.showMessageDialog(null, "A lista não possui elementos para ser excluído!");
      return;
    }
    Temperatura aux = new Temperatura();

    while (aux.getProx() != null) {
      aux = aux.getProx();
    }
    aux.setProx(null);

    this.qtdTemperatura--;
  }

  public void buscaPorPosicao(int pos) {
    if (listaVazia())
      JOptionPane.showMessageDialog(null, "Você deve preencher a lista primeiro");
    else if (pos < 1 || pos > this.qtdTemperatura)
      JOptionPane.showMessageDialog(null, "Posição inválida!");
    else {
      Temperatura aux = this.primeiroLista;
      for (int i = 0; i < (pos - 1); i++) {
        aux = aux.getProx();
      }

      System.out.println("O valor de temperatura referente à posição " + pos + " é igual a: " + aux.getTemperatura());
    }
  }


}
