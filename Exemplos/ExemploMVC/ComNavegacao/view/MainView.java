package ExemploMVC.ComNavegacao.view;

import javax.swing.*;

import java.awt.*;

public class MainView extends JFrame {
  private CardLayout cardLayout; // Controla a exibição dos Paineis na view
  private JPanel cardPanel; // Painel atual que está sendo exibido na view
  private HomeView homeView; // Painel 1
  private DetailsView detailsView; // Painel 2

  public MainView() {
    this.setTitle("MVC Navigation Example");
    this.setSize(400, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    this.cardLayout = new CardLayout();
    this.cardPanel = new JPanel(cardLayout);

    this.homeView = new HomeView();
    this.detailsView = new DetailsView();

    this.cardPanel.add(homeView, "Home");
    this.cardPanel.add(detailsView, "Details");

    this.add(cardPanel);

    this.setVisible(true);
  }

  public HomeView getHomeView() {
    return homeView;
  }

  public DetailsView getDetailsView() {
    return detailsView;
  }

  public void showCard(String cardName) {
    cardLayout.show(cardPanel, cardName);
  }
}