package src.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SubjectsView extends JPanel {
  private JTable subjectsTable;
  private JScrollPane subjectsScrollPane;
  private JButton navigateToSearchButton;
  private JButton navigateToRegisterButton;
  private JButton backButton;
  private DefaultTableModel tableModel;
  private JLabel filterLabel;
  private JTextField filterTextField;
  private JButton filterButton;

  public SubjectsView() {
    this.setLayout(new BorderLayout());

    // Criação da tabela de disciplinas
    String[] colunas = { "Código", "Nome", "Professor", "ID Prof", "Créditos" };
    Object[][] dados = {};

    this.tableModel = new DefaultTableModel(dados, colunas);
    this.subjectsTable = new JTable(tableModel);

    // Permitir rolagem horizontal e vertical
    this.subjectsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    // Criação do JScrollPane para a tabela
    this.subjectsScrollPane = new JScrollPane(this.subjectsTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    this.navigateToSearchButton = new JButton("PROCURAR DISCIPLINA");
    this.navigateToSearchButton.setAlignmentX(CENTER_ALIGNMENT);

    this.navigateToRegisterButton = new JButton("CADASTRAR DISCIPLINA");
    this.navigateToRegisterButton.setAlignmentX(CENTER_ALIGNMENT);

    Dimension buttonSize = new Dimension(200, 50);
    this.backButton = new JButton("Voltar");
    this.backButton.setPreferredSize(buttonSize);
    this.backButton.setMaximumSize(buttonSize);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS)); // alinhados horizontalmente
    buttonPanel.add(Box.createHorizontalGlue());
    buttonPanel.add(this.navigateToSearchButton);
    buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
    buttonPanel.add(this.navigateToRegisterButton);
    buttonPanel.add(Box.createHorizontalGlue());

    // Painel para o filtro
    JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.filterLabel = new JLabel("Filtrar por nome:");
    this.filterTextField = new JTextField(20);
    filterPanel.add(filterLabel);
    filterPanel.add(filterTextField);

    Dimension buttonSize2 = new Dimension(100, 40);
    this.filterButton = new JButton("Filtrar");
    this.filterButton.setPreferredSize(buttonSize2);
    this.filterButton.setMaximumSize(buttonSize2);
    this.filterButton.setMinimumSize(buttonSize2);

    // Painel sul para conter o botão de voltar e o painel de filtro
    JPanel southPanel = new JPanel(new BorderLayout());
    southPanel.add(filterPanel, BorderLayout.NORTH);
    southPanel.add(filterButton, BorderLayout.CENTER);
    southPanel.add(this.backButton, BorderLayout.SOUTH);

    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(this.subjectsScrollPane, BorderLayout.CENTER);
    this.add(southPanel, BorderLayout.SOUTH);
  }

  public void updateTableData(Object[][] data) {
    tableModel.setDataVector(data, new String[] { "Código", "Nome", "Professor", "Créditos" });
  }

  public JButton getBackButton() {
    return this.backButton;
  }

  public JButton getNavigateToSearchButton() {
    return this.navigateToSearchButton;
  }

  public JButton getNavigateToRegisterButton() {
    return this.navigateToRegisterButton;
  }

  public JButton getFilterButton() {
    return this.filterButton;
  }

  public String getFilterText() {
    return this.filterTextField.getText();
  }

  public void setFilterText(String text) {
    this.filterTextField.setText(text);
  }
}