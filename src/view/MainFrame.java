package src.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
  private CardLayout cardLayout; // Controla a exibição dos Paineis na view
  private JPanel cardPanel; // Painel atual que está sendo exibido na view
  private HelloView helloView; // Painel 1
  private HomeView homeView; // Painel 2
  private SubjectsView subjectsView; // Painel 3
  private SearchView searchView; // Painel 4
  private SearchResultView searchResultView; // Painel 5
  private RegisterView registerView; // Painel 6
  private StatsView statsView; // Painel 7

  public MainFrame() {
    this.setTitle("Gerenciador de Disciplinas");
    this.setSize(400, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    this.cardLayout = new CardLayout();
    this.cardPanel = new JPanel(cardLayout);

    this.helloView = new HelloView();
    this.homeView = new HomeView();
    this.subjectsView = new SubjectsView();
    this.searchView = new SearchView();
    this.searchResultView = new SearchResultView();
    this.registerView = new RegisterView();
    this.statsView = new StatsView();

    this.cardPanel.add(this.helloView, "Hello!");
    this.cardPanel.add(this.homeView, "Home");
    this.cardPanel.add(this.subjectsView, "Subjects");
    this.cardPanel.add(this.searchView, "Search");
    this.cardPanel.add(this.searchResultView, "SearchResult");
    this.cardPanel.add(this.registerView, "Register");
    this.cardPanel.add(this.statsView, "Stats");

    this.add(this.cardPanel);

    this.setVisible(true);
  }

  public HelloView getHelloView() {
    return this.helloView;
  }

  public HomeView getHomeView() {
    return this.homeView;
  }

  public SubjectsView getSubjectsView() {
    return this.subjectsView;
  }

  public SearchView getSearchView() {
    return this.searchView;
  }

  public SearchResultView getSearchResultView() {
    return this.searchResultView;
  }

  public RegisterView getRegisterView() {
    return this.registerView;
  }

  public StatsView getStatsView() {
    return this.statsView;
  }

  public void showCard(String cardName) {
    this.cardLayout.show(cardPanel, cardName);
  }
}
