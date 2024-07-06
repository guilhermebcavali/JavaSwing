package ExemploMVC.ComNavegacao.controller;

import ExemploMVC.ComNavegacao.model.User;
import ExemploMVC.ComNavegacao.view.MainView;

// Contém a lógica de exibição dos paineis na view
public class MainController {
    private MainView mainView;
    private User user;
    // gerenciador

    public MainController(MainView mainView) {
        this.mainView = mainView;
        this.user = new User("John Doe");

        this.initController();
    }

    // seta os listeners de navegação:
    private void initController() {
        // quando o usuário clicar em "Go to Details"
        this.mainView.getHomeView().getNavigateButton().addActionListener(e -> navigateToDetails());

        // quando o usuário clicar em "Back to Home"
        this.mainView.getDetailsView().getBackButton().addActionListener(e -> navigateToHome());
    }

    private void navigateToDetails() {
        this.mainView.getDetailsView().setUserName(user.getName());
        this.mainView.showCard("Details");
    }

    private void navigateToHome() {
        this.mainView.showCard("Home");
    }
}