package controller;

public class RecursividadeController {

  public RecursividadeController() {
    super();
  }

  public int fat(int base) {
    if (base == 0) return 1; //    Condição de parada, quando chegar a base 0

    return base * fat(base - 1); //    Retornar base - 1 para o calculo do fatorial
  }

  public String espelhar(String str, int len) {
    if (len == 0) return str.substring(0, 1); // quando chegar no primeiro caracter, sair da função

    StringBuilder string = new StringBuilder(str.substring(len, len + 1));
    return string.append(espelhar(str, len - 1)).toString(); // retorna posição string - 1 para concatenar
  }

  public int somar(int n) {
    if (n < 0) return 0;

    return n + somar(n - 1);
  }

  public int findN(int x, int y) {
    int aux = 0;

    if (x <= 0) return 0;

    if (x % 10 == y) aux = 1;

    return aux + findN((x/10), y);
  }

}
