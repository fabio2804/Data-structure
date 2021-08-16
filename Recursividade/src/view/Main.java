package view;

import controller.RecursividadeController;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    RecursividadeController recursividadeController = new RecursividadeController();

    int base = Integer.parseInt(JOptionPane.showInputDialog("Digite o número a ser calculado seu fatorial: "));
    JOptionPane.showMessageDialog(null, "O fatorial de " + base + " é igual a: " + recursividadeController.fat(base));

    String str = JOptionPane.showInputDialog("Digite uma palavra para espelhar: ");
    JOptionPane.showMessageDialog(null, recursividadeController.espelhar(str, str.length() - 1));

  }
}
