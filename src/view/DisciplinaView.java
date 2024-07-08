package src.view;

import javax.swing.*;
import java.awt.*;

public class DisciplinaView extends JPanel {
    private JButton viewAllButton;
    private JButton searchButton;
    private JButton addButton;
    private JButton statsButton;
    private JTextArea displayArea;
    private JTextField searchField;
    private JComboBox<String> tipoDisciplinaCombo;
    private JTextField nomeField;
    private JTextField creditosField;
    private JTextField linguagemField; // Para POO
    private JCheckBox laboratorioCheckBox; // Para EstruturaDeDados
    private JTextField dificuldadeField; // Para LogicaParaProgramacao

    public DisciplinaView() {
        setLayout(new BorderLayout());

        viewAllButton = new JButton("Ver Todas");
        searchButton = new JButton("Buscar");
        addButton = new JButton("Adicionar");
        statsButton = new JButton("Estatísticas");

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        searchField = new JTextField(20);

        tipoDisciplinaCombo = new JComboBox<>(new String[]{"POO", "EstruturaDeDados", "LogicaParaProgramacao"});
        nomeField = new JTextField(20);
        creditosField = new JTextField(20);
        linguagemField = new JTextField(20);
        laboratorioCheckBox = new JCheckBox("Tem Laboratório");
        dificuldadeField = new JTextField(20);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2));
        inputPanel.add(new JLabel("Tipo:"));
        inputPanel.add(tipoDisciplinaCombo);
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Créditos:"));
        inputPanel.add(creditosField);
        inputPanel.add(new JLabel("Linguagem (POO):"));
        inputPanel.add(linguagemField);
        inputPanel.add(new JLabel("Tem Laboratório (ED):"));
        inputPanel.add(laboratorioCheckBox);
        inputPanel.add(new JLabel("Dificuldade (LP):"));
        inputPanel.add(dificuldadeField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewAllButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(addButton);
        buttonPanel.add(statsButton);

        add(scrollPane, BorderLayout.CENTER);
        add(searchField, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.EAST);
    }

    public JButton getViewAllButton() {
        return viewAllButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getStatsButton() {
        return statsButton;
    }

    public String getSearchQuery() {
        return searchField.getText();
    }

    public String getSelectedDisciplinaType() {
        return (String) tipoDisciplinaCombo.getSelectedItem();
    }

    public String getDisciplinaName() {
        return nomeField.getText();
    }

    public String getDisciplinaCredits() {
        return creditosField.getText();
    }

    public String getDisciplinaLinguagem() {
        return linguagemField.getText();
    }

    public boolean getDisciplinaTemLaboratorio() {
        return laboratorioCheckBox.isSelected();
    }

    public String getDisciplinaDificuldade() {
        return dificuldadeField.getText();
    }

    public void displayAll(String text) {
        displayArea.setText(text);
    }

    public void displayStats(String text) {
        displayArea.setText(text);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
