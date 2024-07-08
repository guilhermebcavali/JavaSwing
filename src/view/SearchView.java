package src.view;

import java.awt.*;
import javax.swing.*;

public class SearchView extends JPanel {
  private JLabel searchSubjectLabel;
  private JTextField subjectNameField;
  private JButton navigateToResult;
  private JButton backButton;

  public SearchView() {
    this.setLayout(new BorderLayout());

    JPanel searchPanel = new JPanel();
    searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));

    this.searchSubjectLabel = new JLabel(
        "<html><div style='text-align: center;'>Digite o nome da disciplina que deseja <br>buscar, no campo abaixo.</html>");
    this.searchSubjectLabel.setAlignmentX(CENTER_ALIGNMENT);

    this.subjectNameField = new JTextField();
    this.subjectNameField.setMaximumSize(new Dimension(300, 30));
    this.subjectNameField.setAlignmentX(CENTER_ALIGNMENT);

    Dimension buttonSize = new Dimension(200, 50);
    this.navigateToResult = new JButton("PROCURAR");
    this.navigateToResult.setAlignmentX(CENTER_ALIGNMENT);
    this.navigateToResult.setPreferredSize(buttonSize);
    this.navigateToResult.setMaximumSize(buttonSize);

    this.backButton = new JButton("VOLTAR");
    this.backButton.setPreferredSize(buttonSize);
    this.backButton.setMaximumSize(buttonSize);

    searchPanel.add(searchSubjectLabel);
    searchPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    searchPanel.add(subjectNameField);
    searchPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    searchPanel.add(navigateToResult);

    // Painel intermediário para centralizar o helloTextPanel
    JPanel centerPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER;
    centerPanel.add(searchPanel, gbc);
    centerPanel.setOpaque(true); // Deixar o painel transparente

    Dimension centerPanelSize = new Dimension(350, 400); // Ajuste conforme necessário
    centerPanel.setPreferredSize(centerPanelSize);
    centerPanel.setMinimumSize(centerPanelSize);
    centerPanel.setMaximumSize(centerPanelSize);

    this.add(centerPanel, BorderLayout.CENTER);
    this.add(backButton, BorderLayout.SOUTH);
  }

  public JButton getBackButton() {
    return this.backButton;
  }

  public JButton getNavigateToResultButton() {
    return this.navigateToResult;
  }

  public String getSubjectNameField() {
    return this.subjectNameField.getText();
  }

  // retorna uma mensagem de erro, caso não exista disciplina cadastrada com o nome informado
  public void showError(String message) {
    JOptionPane.showMessageDialog(this, message, "Erro de Consulta", JOptionPane.ERROR_MESSAGE);
  }

  // limpa o campo do textfield
  public void clearFields() {
    this.subjectNameField.setText("");
  }
}
