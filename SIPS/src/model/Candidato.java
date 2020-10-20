package model;

import javax.swing.JOptionPane;

public class Candidato {
  private String nome;
  private String cpf;
  private int anoNascimento;
  private float nota;
  private Candidato prox;
  private Candidato anterior;

  public Candidato() {
  }

  public Candidato(String nome, String cpf, int anoNascimento) {
    this.nome = nome;
    this.cpf = cpf;
    this.anoNascimento = anoNascimento;
    this.prox = null;
    this.anterior = null;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public int getDataNascimento() {
    return anoNascimento;
  }

  public void setDataNascimento(int anoNascimento) {
    this.anoNascimento = anoNascimento;
  }

  public float getNota() {
    return nota;
  }

  public void setNota(float nota) {
    this.nota = nota;
  }

  public Candidato getProx() {
    return prox;
  }

  public void setProx(Candidato prox) {
    this.prox = prox;
  }

  public Candidato getAnterior() {
    return anterior;
  }

  public void setAnterior(Candidato anterior) {
    this.anterior = anterior;
  }

}
