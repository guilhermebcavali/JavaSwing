package ExemploMVC.SemNavegacao;

import javax.swing.*;
import java.awt.*;

public class ContatoView extends JFrame {
  private JTextField nomeField;
  private JTextField telefoneField;
  private JButton adicionarButton;
  private JTextArea listaContatosArea;

  public ContatoView() {
    this.setTitle("Gerenciador de Contatos");
    this.setSize(800, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout()); // define o layout da View Principal do programa.

    // uma boa prática seria criar esses Paineis Internos (componentes) em arquivos
    // separados, caso existissem muitos mais JPanels() na view atual.

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridLayout(3, 2)); // rows: nome; telefone; botao

    inputPanel.add(new JLabel("Nome:"));
    this.nomeField = new JTextField(); // coluna 1
    inputPanel.add(nomeField);

    inputPanel.add(new JLabel("Telefone:"));
    this.telefoneField = new JTextField(); // coluna 2
    inputPanel.add(telefoneField);

    adicionarButton = new JButton("Adicionar Contato");
    inputPanel.add(adicionarButton);

    this.add(inputPanel, BorderLayout.NORTH); // add painel de input à view

    // area onde serão listados os contatos já existentes, por meio do método
    // declarado abaixo:
    // listaContatosArea.append(contato + "\n");
    listaContatosArea = new JTextArea(); // componente grafico
    listaContatosArea.setEditable(false);

    // JPane(JTextArea)
    this.add(new JScrollPane(listaContatosArea), BorderLayout.CENTER);
  }

  public String getNome() {
    return nomeField.getText();
  }

  public String getTelefone() {
    return telefoneField.getText();
  }

  public JButton getAdicionarButton() {
    return adicionarButton;
  }

  public void adicionarContatoNaLista(String contato) {
    listaContatosArea.append(contato + "\n");
  }
}