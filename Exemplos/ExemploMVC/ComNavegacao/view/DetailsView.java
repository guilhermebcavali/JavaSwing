package ExemploMVC.ComNavegacao.view;

import javax.swing.*;
import java.awt.*;

// JFRAME e JPANEL
public class DetailsView extends JPanel {
  private JLabel userLabel;
  private JButton backButton;

  public DetailsView() {
    this.setLayout(new BorderLayout());

    // this.userLabel = new JLabel("User: ");
    this.userLabel = new JLabel("User: ", SwingConstants.CENTER); // Centraliza horizontalmente
    this.userLabel.setVerticalAlignment(SwingConstants.CENTER); // Centraliza verticalmente
    this.backButton = new JButton("Back to Home");

    // painel para centralizar o JLabel (opcional)
    // JPanel centerPanel = new JPanel(new GridBagLayout());
    // centerPanel.add(this.userLabel);

    this.add(this.userLabel, BorderLayout.CENTER);
    this.add(this.backButton, BorderLayout.SOUTH);
  }

  // essa função será chamada pela Controller da MainView (MainController)
  public void setUserName(String name) {
    this.userLabel.setText("User: " + name);
  }

  public JButton getBackButton() {
    return this.backButton;
  }
}