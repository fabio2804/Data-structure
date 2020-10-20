package model;

public class Edital {
  private String faculdade;
  private String curso;
  private int qtdVagas;

  public Edital(String faculdade, String curso, int qtdVagas) {
    this.faculdade = faculdade;
    this.curso = curso;
    this.qtdVagas = qtdVagas;
  }

  public String getFaculdade() {
    return faculdade;
  }

  public void setFaculdade(String faculdade) {
    this.faculdade = faculdade;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public int getQtdVagas() {
    return qtdVagas;
  }

  public void setQtdVagas(int qtdVagas) {
    this.qtdVagas = qtdVagas;
  }

}
