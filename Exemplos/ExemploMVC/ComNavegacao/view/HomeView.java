package ExemploMVC.ComNavegacao.view;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel {
  private JButton navigateButton;

  public HomeView() {
    setLayout(new BorderLayout());
    navigateButton = new JButton("Go to Details");
    add(navigateButton, BorderLayout.CENTER);
  }

  public JButton getNavigateButton() {
    return navigateButton;
  }
}