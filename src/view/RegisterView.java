package src.view;

import java.awt.*;
import javax.swing.*;

import src.auxiliar.NumericLengthRestrictedDocumentFilter;
import javax.swing.text.AbstractDocument;

public class RegisterView extends JPanel {
  private JTabbedPane tabbedPane;
  private JButton registerButton, backButton;

  // Campos de texto como atributos da classe
  private JTextField subjectCodeField;
  private JTextField subjectNameField;
  private JTextField subjectTeacherField;
  private JTextField subjectCreditsField;
  private JTextField subjectLanguageField;
  private JTextField subjectLabField;
  private JTextField subjectDifficultyField;

  public RegisterView() {
    setLayout(new BorderLayout());
    tabbedPane = new JTabbedPane();

    // Criar painéis específicos
    JPanel pooPanel = createSpecificPanel("POO");
    JPanel algoritmosPanel = createSpecificPanel("Algoritmos");
    JPanel logicaPanel = createSpecificPanel("Lógica de Programação");

    // Adiciona os painéis ao tabbedPane
    tabbedPane.addTab("POO", pooPanel);
    tabbedPane.addTab("Algoritmos", algoritmosPanel);
    tabbedPane.addTab("Lógica de Programação", logicaPanel);

    // Botões de registro e voltar
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
    registerButton = new JButton("CADASTRAR");
    backButton = new JButton("VOLTAR");

    // Ajustar o tamanho dos botões
    registerButton.setPreferredSize(new Dimension(150, 40));
    backButton.setPreferredSize(new Dimension(150, 40));

    buttonPanel.add(registerButton);
    buttonPanel.add(backButton);

    add(tabbedPane, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
  }

  private JPanel createCommonPanel() {
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridwidth = 2;
    gbc.gridy = 0;
    gbc.insets = new Insets(10, 0, 10, 0);

    subjectCodeField = new JTextField();
    subjectNameField = new JTextField();
    subjectTeacherField = new JTextField();
    subjectCreditsField = new JTextField();
    ((AbstractDocument) this.subjectCreditsField.getDocument())
    .setDocumentFilter(new NumericLengthRestrictedDocumentFilter(10));

    // Adicionando labels e campos de texto comuns
    addLabelAndTextField(panel, gbc, "Código da Disciplina", subjectCodeField);
    addLabelAndTextField(panel, gbc, "Nome da Disciplina", subjectNameField);
    addLabelAndTextField(panel, gbc, "Nome do Professor", subjectTeacherField);
    addLabelAndTextField(panel, gbc, "Créditos da Disciplina", subjectCreditsField);

    return panel;
  }

  private void addLabelAndTextField(JPanel panel, GridBagConstraints gbc, String labelText, JTextField textField) {
    JLabel label = new JLabel(labelText);

    gbc.gridy++;
    gbc.anchor = GridBagConstraints.LINE_START;
    panel.add(label, gbc);

    gbc.gridy++;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.insets = new Insets(2, 0, 10, 0); // Ajuste para reduzir o espaço entre o label e o campo
    panel.add(textField, gbc);
    gbc.insets = new Insets(10, 0, 10, 0); // Restaurar o espaçamento padrão para os próximos componentes
  }

  private JPanel createSpecificPanel(String type) {
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(createCommonPanel(), BorderLayout.NORTH);

    JPanel specificPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridwidth = 2;
    gbc.gridy = 4;
    gbc.insets = new Insets(5, 0, 20, 0);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    switch (type) {
      case "POO":
        subjectLanguageField = new JTextField();
        addLabelAndTextField(specificPanel, gbc, "Linguagem da Disciplina", subjectLanguageField);
        break;
      case "Algoritmos":
        subjectLabField = new JTextField();
        addLabelAndTextField(specificPanel, gbc, "Tem Laboratório? (SIM/NÃO)", subjectLabField);
        break;
      case "Lógica de Programação":
        subjectDifficultyField = new JTextField();
        addLabelAndTextField(specificPanel, gbc, "Dificuldade da Disciplina (1-10)", subjectDifficultyField);
        break;
    }

    panel.add(specificPanel, BorderLayout.CENTER);
    return panel;
  }

  public JButton getBackButton() {
    return this.backButton;
  }

  public JButton getRegisterButton() {
    return this.registerButton;
  }

  public String getCodeField() {
    return subjectCodeField.getText();
  }

  public String getNameField() {
    return subjectNameField.getText();
  }

  public String getTeacherField() {
    return subjectTeacherField.getText();
  }

  public String getCreditsField() {
    return subjectCreditsField.getText();
  }

  public String getLanguageField() {
    return subjectLanguageField.getText();
  }

  public String getLabField() {
    return subjectLabField.getText();
  }

  public String getDifficultyField() {
    return subjectDifficultyField.getText();
  }

  // Método para determinar qual aba está ativa
  public int getSelectedTabIndex() {
    return tabbedPane.getSelectedIndex();
  }

  // Métodos para exibir mensagens de sucesso e erro
  public void showSuccessMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
  }

  public void showErrorMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Erro", JOptionPane.ERROR_MESSAGE);
  }
}