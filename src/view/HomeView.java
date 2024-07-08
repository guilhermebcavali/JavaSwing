package src.view;

import java.awt.*;
import javax.swing.*;

public class HomeView extends JPanel {
  private JLabel userLabel;
  private JLabel optionsLabel;
  private JPanel homeOptionsPanel;
  private JButton navigateToSubjectsButton;
  private JButton navigateToSearchButton;
  private JButton navigateToRegisterButton;
  private JButton navigateToStatsButton;
  private JButton backButton;

  public HomeView() {
    this.setLayout(new BorderLayout());

    this.homeOptionsPanel = new JPanel();
    this.homeOptionsPanel.setLayout(new BoxLayout(homeOptionsPanel, BoxLayout.Y_AXIS));
    this.homeOptionsPanel.setOpaque(true); // Deixar o painel transparente

    this.userLabel = new JLabel("Olá, usuário!");
    this.userLabel.setFont(new Font("SansSerif", Font.BOLD, 14)); // Definir a fonte
    this.userLabel.setAlignmentX(CENTER_ALIGNMENT);

    this.optionsLabel = new JLabel("O que você deseja fazer?");
    this.optionsLabel.setAlignmentX(CENTER_ALIGNMENT);

    this.homeOptionsPanel.add(userLabel);
    this.homeOptionsPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espaçamento entre labels

    this.homeOptionsPanel.add(optionsLabel);
    this.homeOptionsPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento entre labels

    Dimension buttonSize = new Dimension(200, 40);
    this.navigateToSubjectsButton = new JButton("VER DISCIPLINAS");
    this.navigateToSubjectsButton.setPreferredSize(buttonSize);
    this.navigateToSubjectsButton.setMaximumSize(buttonSize);
    this.navigateToSubjectsButton.setAlignmentX(CENTER_ALIGNMENT);

    this.navigateToSearchButton = new JButton("PROCURAR DISCIPLINA");
    this.navigateToSearchButton.setPreferredSize(buttonSize);
    this.navigateToSearchButton.setMaximumSize(buttonSize);
    this.navigateToSearchButton.setAlignmentX(CENTER_ALIGNMENT);

    this.navigateToRegisterButton = new JButton("CADASTRAR DISCIPLINA");
    this.navigateToRegisterButton.setPreferredSize(buttonSize);
    this.navigateToRegisterButton.setMaximumSize(buttonSize);
    this.navigateToRegisterButton.setAlignmentX(CENTER_ALIGNMENT);

    this.navigateToStatsButton = new JButton("VER ESTATÍSTICAS");
    this.navigateToStatsButton.setPreferredSize(buttonSize);
    this.navigateToStatsButton.setMaximumSize(buttonSize);
    this.navigateToStatsButton.setAlignmentX(CENTER_ALIGNMENT);

    this.backButton = new JButton("VOLTAR");
    this.backButton.setPreferredSize(new Dimension(200, 50));

    this.homeOptionsPanel.add(navigateToSubjectsButton);
    this.homeOptionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre labels
    this.homeOptionsPanel.add(navigateToSearchButton);
    this.homeOptionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre labels
    this.homeOptionsPanel.add(navigateToRegisterButton);
    this.homeOptionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre labels
    this.homeOptionsPanel.add(navigateToStatsButton);

    // Painel intermediário para centralizar o homeOptionsPanel
    JPanel centerPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER;
    centerPanel.add(this.homeOptionsPanel, gbc);
    centerPanel.setOpaque(true); // Deixar o painel transparente

    // Adicionar componentes ao painel principal (HomeView)
    add(centerPanel, BorderLayout.CENTER);
    add(backButton, BorderLayout.SOUTH);
  }

  public JButton getNavigateToSubjectsButton() {
    return this.navigateToSubjectsButton;
  }

  public JButton getNavigateToSearchButton() {
    return this.navigateToSearchButton;
  }

  public JButton getNavigateToRegisterButton() {
    return this.navigateToRegisterButton;
  }

  public JButton getNavigateToStatsButton() {
    return this.navigateToStatsButton;
  }

  public JButton getBackButton() {
    return this.backButton;
  }
}
