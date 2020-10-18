package listaLigada.model;

public class Curso {
  private int id;
  private String nome;
  private String area;
  private int qtdSemestre;
  private String periodo;
  private Curso prox;

  public Curso() {
    this.prox = null;
  }

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

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public int getQtdSemestre() {
    return qtdSemestre;
  }

  public void setQtdSemestre(int qtdSemestre) {
    this.qtdSemestre = qtdSemestre;
  }

  public String getPeriodo() {
    return periodo;
  }

  public void setPeriodo(String periodo) {
    this.periodo = periodo;
  }

  public Curso getProx() {
    return prox;
  }

  public void setProx(Curso prox) {
    this.prox = prox;
  }
}
