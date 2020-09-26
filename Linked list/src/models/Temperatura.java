package models;

public class Temperatura {
  private float temperatura;
  private Temperatura prox;

  public Temperatura() {}

  public float getTemperatura() {
    return temperatura;
  }

  public void setTemperatura(float temperatura) {
    this.temperatura = temperatura;
  }

  public Temperatura getProx() {
    return prox;
  }

  public void setProx(Temperatura prox) {
    this.prox = prox;
  }
}
