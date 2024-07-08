package src.view;

import java.awt.*;
import javax.swing.*;
import src.auxiliar.LengthRestrictedDocumentFilter;
import src.auxiliar.NumericLengthRestrictedDocumentFilter;
import javax.swing.text.AbstractDocument;

// tela para identificacao do usuario
public class HelloView extends JPanel {
  private JLabel helloLabel;
  private JLabel loginLabel;
  private JPanel helloTextPanel;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JButton navigateButton;

  public HelloView() {
    this.setLayout(new BorderLayout());

    this.helloTextPanel = new JPanel();
    this.helloTextPanel.setLayout(new BoxLayout(helloTextPanel, BoxLayout.Y_AXIS));
    this.helloTextPanel.setOpaque(true); // Deixar o painel transparente

    this.helloLabel = new JLabel("Bem vindo ao Gerenciador de Disciplina!");
    this.helloLabel.setFont(new Font("Serif", Font.BOLD, 18)); // Definir a fonte
    this.helloLabel.setAlignmentX(CENTER_ALIGNMENT);

    this.loginLabel = new JLabel("Insira os seus dados abaixo e faça o seu login.");
    this.loginLabel.setAlignmentX(CENTER_ALIGNMENT);

    this.usernameField = new JTextField();
    this.usernameField.setMaximumSize(new Dimension(300, 30));
    this.usernameField.setAlignmentX(CENTER_ALIGNMENT);
    ((AbstractDocument) this.usernameField.getDocument()).setDocumentFilter(new LengthRestrictedDocumentFilter(10));

    this.passwordField = new JPasswordField();
    this.passwordField.setMaximumSize(new Dimension(300, 30));
    this.passwordField.setAlignmentX(CENTER_ALIGNMENT);
    ((AbstractDocument) this.passwordField.getDocument())
        .setDocumentFilter(new NumericLengthRestrictedDocumentFilter(10));

    this.helloTextPanel.add(helloLabel);
    this.helloTextPanel.add(Box.createRigidArea(new Dimension(0, 60))); // Espaçamento entre labels
    this.helloTextPanel.add(loginLabel);
    this.helloTextPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento entre labels
    this.helloTextPanel.add(usernameField);
    this.helloTextPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre labels
    this.helloTextPanel.add(passwordField);

    this.navigateButton = new JButton("Entrar");
    this.navigateButton.setPreferredSize(new Dimension(200, 50)); 

    // Painel intermediário para centralizar o helloTextPanel
    JPanel centerPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER;
    centerPanel.add(this.helloTextPanel, gbc);
    centerPanel.setOpaque(true); // Deixar o painel transparente

    add(centerPanel, BorderLayout.CENTER);
    add(navigateButton, BorderLayout.SOUTH);
  }

  public JButton getNavigateButton() {
    return navigateButton;
  }

  // retorna o username inserido
  public String getUsername() {
    return this.usernameField.getText();
  }

  // retorna a senha digitada
  public String getPassword() {
    char[] password = passwordField.getPassword();
    String passwordText = new String(password);
    return passwordText;
  }

  // retorna uma mensagem de erro, caso o login falhe.
  public void showError(String message) {
    JOptionPane.showMessageDialog(this, message, "Erro de Login", JOptionPane.ERROR_MESSAGE);
  }

  // limpa os campos dos textfields
  public void clearFields() {
    this.usernameField.setText("");
    this.passwordField.setText("");
  }
}
