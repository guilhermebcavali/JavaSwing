package src.model;

public class LogicaParaProgramacao extends Disciplina {
    private int dificuldade;

    public LogicaParaProgramacao(String nome, int codigo, int creditos, int cargaHoraria, int dificuldade) {
        super(nome, codigo, creditos);
        this.dificuldade = dificuldade;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    @Override
    public String toString() {
        return "Lógica para Programação: " + getNome() + " | Código: " + getCodigo() + "| Créditos: " + getCreditos()
                + " | Dificuldade: " + dificuldade;
    }
}
