package ExemploMVC.SemNavegacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContatoController {
  private GerenciamentoDeContatos gerenciador;
  private ContatoView view;

  public ContatoController(GerenciamentoDeContatos modelo, ContatoView view) {
    this.gerenciador = modelo;
    this.view = view;

    // ActionListener: observa os eventos lançados pelo botao da view, em tempo de
    // execucao.
    // os textfields armazenam o que está sendo escrito em uma variavel interna
    // textFiel.getText() retorna esse valor;
    this.view.getAdicionarButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nome = view.getNome();
        String telefone = view.getTelefone();
        Contato contato = new Contato(nome, telefone);

        gerenciador.adicionarContato(contato);
        view.adicionarContatoNaLista(contato.toString());
      }
    });
  }
}