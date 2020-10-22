package interfaces;

import model.Edital;

public interface EditalInterface {
  Edital criarEdital();

  boolean verificarEditalVazio(Edital edital);
}
