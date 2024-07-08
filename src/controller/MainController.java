package src.controller;

import java.util.*;
import src.model.*;
import src.view.MainFrame;

public class MainController {
    private GerenciadorDisciplina gerenciador;
    private MainFrame mainFrame;
    private String mockUsername;
    private String mockPassword;

    public MainController(GerenciadorDisciplina gerenciador, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.mockUsername = "usuario";
        this.mockPassword = "12345";
        this.gerenciador = gerenciador;
        this.initController();
        this.initSampleData(); // Adiciona disciplinas de exemplo
    }

    // Seta os listeners do app;
    private void initController() {

        // Quando o usuário clicar em "Entrar" (HelloView)
        this.mainFrame.getHelloView().getNavigateButton().addActionListener(e -> verifyAndNavigate());

        // Botões HomeView (Subjects, Search, Register, Stats)
        this.mainFrame.getHomeView().getBackButton().addActionListener(e -> navigateToHello());
        this.mainFrame.getHomeView().getNavigateToSubjectsButton().addActionListener(e -> navigateToSubjects());
        this.mainFrame.getHomeView().getNavigateToSearchButton().addActionListener(e -> navigateToSearch());
        this.mainFrame.getHomeView().getNavigateToRegisterButton().addActionListener(e -> navigateToRegister());
        this.mainFrame.getHomeView().getNavigateToStatsButton().addActionListener(e -> navigateToStats());

        // Botões SubjectsView
        this.mainFrame.getSubjectsView().getNavigateToSearchButton().addActionListener(e -> navigateToSearch());
        this.mainFrame.getSubjectsView().getNavigateToRegisterButton().addActionListener(e -> navigateToRegister());
        this.mainFrame.getSubjectsView().getFilterButton().addActionListener(e -> displayFilterSubjects());
        this.mainFrame.getSubjectsView().getBackButton().addActionListener(e -> navigateToHome());

        // Botões SearchView
        this.mainFrame.getSearchView().getBackButton().addActionListener(e -> navigateToHome());
        this.mainFrame.getSearchView().getNavigateToResultButton().addActionListener(e -> searchSubject());

        // Botoes SearchResultView
        this.mainFrame.getSearchResultView().getBackButton().addActionListener(e -> navigateToSearch());

        // Botões RegisterView
        this.mainFrame.getRegisterView().getBackButton().addActionListener(e -> navigateToHome());
        this.mainFrame.getRegisterView().getRegisterButton().addActionListener(e -> registerSubject());
        // Botão StatsView
        this.mainFrame.getStatsView().getBackButton().addActionListener(e -> navigateToHome());
    }

    private void initSampleData() {
        List<Disciplina> sampleDisciplinas = new ArrayList<>();
        Professor professor1 = new Professor("Sergio");
        Professor professor2 = new Professor("Paulo");

        Disciplina disciplina1 = new LogicaParaProgramacao("Disciplina1", 1, 2, 4, 5);
        disciplina1.setProfessor(professor1);

        Disciplina disciplina2 = new LogicaParaProgramacao("Disciplina2", 2, 3, 4, 5);
        disciplina2.setProfessor(professor1);

        Disciplina disciplina3 = new LogicaParaProgramacao("Disciplina3", 3, 4, 5, 6);
        disciplina3.setProfessor(professor2);

        Disciplina disciplina4 = new POO("Disciplina4", 1, 2, 3, "Java");
        disciplina4.setProfessor(professor2);

        Disciplina disciplina5 = new POO("Disciplina5", 1, 2, 3, "Swift");
        disciplina5.setProfessor(professor2);

        sampleDisciplinas.add(disciplina1);
        sampleDisciplinas.add(disciplina2);
        sampleDisciplinas.add(disciplina3);
        sampleDisciplinas.add(disciplina4);
        sampleDisciplinas.add(disciplina5);

        for (Disciplina d : sampleDisciplinas) {
            gerenciador.add(d);
        }
    }

    private void verifyAndNavigate() {
        String username = this.mainFrame.getHelloView().getUsername();
        String password = this.mainFrame.getHelloView().getPassword();

        if (username.equals(mockUsername) && password.equals(mockPassword)) {
            this.navigateToHome();
        } else {
            this.mainFrame.getHelloView().showError("Username ou password incorretos");
            this.mainFrame.getHelloView().clearFields();
        }
    }

    private void searchSubject() {
        String name = mainFrame.getSearchView().getSubjectNameField();
        List<Disciplina> disciplinas = gerenciador.searchByName(name);
        Object[][] data = new Object[disciplinas.size()][5];
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina d = disciplinas.get(i);
            data[i][0] = d.getCodigo();
            data[i][1] = d.getNome();
            data[i][2] = d.getProfessor().getNome();
            data[i][3] = d.getCreditos();
        }

        if (!disciplinas.isEmpty()) {
            this.mainFrame.getSearchResultView().updateTableData(data);
            this.mainFrame.getSearchView().clearFields();
            ;
            navigateToSearchResult();
        } else {
            this.mainFrame.getSearchView().showError("Disciplina não encontrada.");
            this.mainFrame.getSearchView().clearFields();
            ;
        }
    }

    private void registerSubject() {
        // Identificar a aba ativa usando o método getIndex ou algo similar fornecido
        // pelo MainFrame
        int selectedIndex = mainFrame.getRegisterView().getSelectedTabIndex();

        // Obter as informações comuns de todas as abas
        int codigo = Integer.parseInt(mainFrame.getRegisterView().getCodeField());
        String nome = mainFrame.getRegisterView().getNameField();
        String professorNome = mainFrame.getRegisterView().getTeacherField();
        int creditos = Integer.parseInt(mainFrame.getRegisterView().getCreditsField());
        Professor professor = new Professor(professorNome); // Assumindo que o professor é criado assim

        Disciplina novaDisciplina = null;

        // Dependendo do índice da aba, criar a disciplina apropriada
        switch (selectedIndex) {
            case 0: // POO
                String linguagem = mainFrame.getRegisterView().getLanguageField();
                novaDisciplina = new POO(nome, codigo, creditos, creditos, linguagem);
                break;
            case 1: // Algoritmos
                String lab = mainFrame.getRegisterView().getLabField();
                if (lab.equalsIgnoreCase("sim")) {
                    novaDisciplina = new Algoritmos(nome, codigo, creditos, creditos, true);
                } else {
                    novaDisciplina = new Algoritmos(nome, codigo, creditos, creditos, false);
                }
                break;
            case 2: // Lógica de Programação
                int dificuldade = Integer.parseInt(mainFrame.getRegisterView().getDifficultyField());
                novaDisciplina = new LogicaParaProgramacao(nome, selectedIndex, creditos,
                        creditos, dificuldade);
                break;
        }

        // Configurar o professor da disciplina
        if (novaDisciplina != null) {
            novaDisciplina.setProfessor(professor);
            gerenciador.add(novaDisciplina);
            // Atualizar a interface ou notificar o usuário
            mainFrame.getRegisterView().showSuccessMessage("Disciplina cadastrada com sucesso!");
        } else {
            mainFrame.getRegisterView().showErrorMessage("Erro ao cadastrar disciplina.");
        }
    }

    private void displayAllSubjects() {
        List<Disciplina> disciplinas = gerenciador.getAllDisciplinas();
        Object[][] data = new Object[disciplinas.size()][5];
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina d = disciplinas.get(i);
            data[i][0] = d.getCodigo();
            data[i][1] = d.getNome();
            data[i][2] = d.getProfessor().getNome();
            data[i][3] = d.getCreditos();
        }
        mainFrame.getSubjectsView().updateTableData(data);
    }

    private void displayFilterSubjects() {
        String name = mainFrame.getSubjectsView().getFilterText();
        List<Disciplina> disciplinas = gerenciador.filterByName(name);
        Object[][] data = new Object[disciplinas.size()][4];
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina d = disciplinas.get(i);
            data[i][0] = d.getCodigo();
            data[i][1] = d.getNome();
            data[i][2] = d.getProfessor().getNome();
            data[i][3] = d.getCreditos();
        }
        mainFrame.getSubjectsView().updateTableData(data);
    }

    private void displayStats() {
        StringBuilder sb = new StringBuilder();

        long total = gerenciador.getTotalCount(); // porque long?
        long pooCount = gerenciador.getCountByType(POO.class); // porque long?
        long edCount = gerenciador.getCountByType(Algoritmos.class); // porque long?
        long logicaCount = gerenciador.getCountByType(LogicaParaProgramacao.class); // porque long?
        int somaCreditos = gerenciador.getSumOfCredits();
        double mediaCreditos = gerenciador.getAverageCredits();

        sb.append("Total de Disciplinas: ").append(total).append("\n");
        sb.append("POO: ").append(pooCount).append("\n");
        sb.append("Algoritmos: ").append(edCount).append("\n");
        sb.append("Lógica para Programação: ").append(logicaCount).append("\n");
        sb.append("Soma de Créditos: ").append(somaCreditos).append("\n");
        sb.append("Média de Créditos: ").append(mediaCreditos).append("\n");

        mainFrame.getStatsView().showStats(sb.toString());
    }

    private void navigateToHome() {
        this.mainFrame.showCard("Home");
    }

    private void navigateToSubjects() {
        this.displayAllSubjects();
        this.mainFrame.showCard("Subjects");
        for (Disciplina d : gerenciador.getAllDisciplinas()) {
            System.out.println("Id do professor " + d.getProfessor().getNome() + ": " + d.getProfessor().getId()
                    + " | Disciplina: " + d.getNome());
        }
    }

    private void navigateToSearch() {
        this.mainFrame.showCard("Search");
    }

    private void navigateToSearchResult() {
        this.mainFrame.showCard("SearchResult");
    }

    private void navigateToRegister() {
        this.mainFrame.showCard("Register");
    }

    private void navigateToStats() {
        this.displayStats();
        this.mainFrame.showCard("Stats");
    }

    private void navigateToHello() {
        this.mainFrame.showCard("Hello!");
    }
}