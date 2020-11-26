package interfaces;

import controller.ListaController;
import model.Edital;

public interface GeradorDocInterface {
  void gerarDoc(Edital edital, ListaController listaController);
}
