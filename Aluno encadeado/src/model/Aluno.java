package model;

public class Aluno {
  private int ra;
  private String nome;
  private String turma;
  private String semestre;
  private Aluno prox;

  public Aluno() {
    this.prox = null;
  }

  public int getRa() {
    return ra;
  }

  public void setRa(int ra) {
    this.ra = ra;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTurma() {
    return turma;
  }

  public void setTurma(String turma) {
    this.turma = turma;
  }

  public String getSemestre() {
    return semestre;
  }

  public void setSemestre(String semestre) {
    this.semestre = semestre;
  }

  public Aluno getProx() {
    return prox;
  }

  public void setProx(Aluno prox) {
    this.prox = prox;
  }
}
