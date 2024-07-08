package src.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchResultView extends JPanel {
  private JTable searchResultTable;
  private JLabel searchResultLabel;
  private DefaultTableModel tableModel;
  private JScrollPane searchResultScrollPane;
  private JButton backButton;

  public SearchResultView() {
    this.setLayout(new BorderLayout());

    // Criação da tabela de disciplinas
    String[] colunas = { "Código", "Nome", "Professor", "Créditos" };
    Object[][] dados = {};

    this.searchResultLabel = new JLabel(
        "<html><div style='text-align: center;'>Resultado da Pesquisa:</html>");
    this.searchResultLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
    this.searchResultLabel.setAlignmentX(CENTER_ALIGNMENT);

    this.tableModel = new DefaultTableModel(dados, colunas);
    this.searchResultTable = new JTable(tableModel);

    // Permitir rolagem horizontal e vertical
    this.searchResultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    // Criação do JScrollPane para a tabela
    this.searchResultScrollPane = new JScrollPane(this.searchResultTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    Dimension buttonSize = new Dimension(200, 50);
    this.backButton = new JButton("Voltar");
    this.backButton.setPreferredSize(buttonSize);
    this.backButton.setMaximumSize(buttonSize);

    this.add(searchResultLabel, BorderLayout.NORTH);
    this.add(searchResultScrollPane, BorderLayout.CENTER);
    this.add(backButton, BorderLayout.SOUTH);
  }

  public JButton getBackButton() {
    return this.backButton;
  }

  public void updateTableData(Object[][] data) {
    tableModel.setDataVector(data, new String[] { "Código", "Nome", "Professor", "Créditos" });
  }
}
