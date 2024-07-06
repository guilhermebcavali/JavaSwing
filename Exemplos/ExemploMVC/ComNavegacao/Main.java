package ExemploMVC.ComNavegacao;

import ExemploMVC.ComNavegacao.controller.MainController;
import ExemploMVC.ComNavegacao.view.MainView;

public class Main {
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(() -> {
      MainView mainView = new MainView();
      new MainController(mainView);
    });
  }
}