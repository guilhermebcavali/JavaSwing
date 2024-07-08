package src.view;

import java.awt.*;
import javax.swing.*;

public class StatsView extends JPanel {
  private JLabel generalStatsLabel;
  private JTextArea generalStatsText;
  private JButton backButton;

  public StatsView() {
    this.setLayout(new BorderLayout());

    JPanel statsPanel = new JPanel();
    statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));

    this.generalStatsLabel = new JLabel(
        "<html>Exibindo as estatísticas gerais do seu Gerenciador de <br>Disciplinas.</div></html>");
    this.generalStatsLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza a label

    this.generalStatsText = new JTextArea(10, 30);
    this.generalStatsText.setEditable(false);

    Dimension buttonSize = new Dimension(200, 50);
    this.backButton = new JButton("VOLTAR");
    this.backButton.setPreferredSize(buttonSize);
    this.backButton.setMaximumSize(buttonSize);

    statsPanel.add(generalStatsLabel);
    statsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    statsPanel.add(new JScrollPane(generalStatsText));

    // Painel intermediário para centralizar o statsPanel
    JPanel centerPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER;
    centerPanel.add(statsPanel, gbc);
    centerPanel.setOpaque(true); // Deixar o painel transparente

    // JScrollPane(JPanel)
    JScrollPane scrollPane = new JScrollPane(centerPanel);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

    this.add(scrollPane, BorderLayout.CENTER);
    this.add(backButton, BorderLayout.SOUTH);
  }

  public JButton getBackButton() {
    return this.backButton;
  }

  public void showStats(String stats) {
    this.generalStatsText.append(stats);
  }
}