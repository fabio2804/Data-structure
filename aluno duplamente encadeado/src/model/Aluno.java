package model;

public class Aluno {
  private int id;
  private String nome;
  private String curso;
  private Aluno prox;
  private Aluno anterior;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public Aluno getProx() {
    return prox;
  }

  public void setProx(Aluno prox) {
    this.prox = prox;
  }

  public Aluno getAnterior() {
    return anterior;
  }

  public void setAnterior(Aluno anterior) {
    this.anterior = anterior;
  }

  public Aluno() {
    this.prox = null;
    this.anterior = null;
  }
}
