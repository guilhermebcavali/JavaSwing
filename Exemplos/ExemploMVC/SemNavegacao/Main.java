package ExemploMVC.SemNavegacao;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {

        GerenciamentoDeContatos modelo = new GerenciamentoDeContatos(); // M
        ContatoView view = new ContatoView(); // V
        ContatoController controller = new ContatoController(modelo, view); // C

        view.setVisible(true);
      }
    });
  }
}