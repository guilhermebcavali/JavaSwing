package ExemploMVC.SemNavegacao;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoDeContatos {
  private List<Contato> contatos;

  public GerenciamentoDeContatos() {
    this.contatos = new ArrayList<>();
  }

  public void adicionarContato(Contato contato) {
    contatos.add(contato);
  }

  public List<Contato> getContatos() {
    return contatos;
  }
}
