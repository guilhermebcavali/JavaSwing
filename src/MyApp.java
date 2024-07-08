package src;

import src.controller.MainController;
import src.model.GerenciadorDisciplina;
import src.view.MainFrame;

public class MyApp {
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(() -> {
      GerenciadorDisciplina gerenciador = new GerenciadorDisciplina();
      MainFrame mainFrame = new MainFrame();
      new MainController(gerenciador, mainFrame);
    });
  }
}