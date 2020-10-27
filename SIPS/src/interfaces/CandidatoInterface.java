package interfaces;

import model.Candidato;

public interface CandidatoInterface {
  Candidato criarCandidato();

  Candidato gerarNotas(Candidato aux);
}
