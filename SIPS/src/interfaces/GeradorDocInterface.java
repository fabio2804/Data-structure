package interfaces;

import controller.ListaController;
import model.Candidato;
import model.Edital;

public interface GeradorDocInterface {
  void gerarDoc(Edital edital, Candidato[] arrayCandidatos);
}
