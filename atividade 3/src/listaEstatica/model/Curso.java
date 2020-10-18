package listaEstatica.model;

public class Curso {
  private final int id;
  private final String nome;
  private final String area;
  private final int qtdSemestre;
  private final String periodo;

  public Curso(int id, String nome, String area, int qtdSemestre, String periodo) {
    this.id = id;
    this.nome = nome;
    this.area = area;
    this.qtdSemestre = qtdSemestre;
    this.periodo = periodo;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getArea() {
    return area;
  }

  public int getQtdSemestre() {
    return qtdSemestre;
  }

  public String getPeriodo() {
    return periodo;
  }

}
