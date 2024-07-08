package src.model;

public class POO extends Disciplina {
    private String linguagem;

    public POO(String nome, int codigo, int creditos, int cargaHoraria, String linguagem) {
        super(nome, codigo, creditos);
        this.linguagem = linguagem;
    }

    public String getLinguagem() {
        return linguagem;
    }

    @Override
    public String toString() {
        return "POO: " + getNome() + " | Código: " + getCodigo() + " | Créditos: " + getCreditos() + " | Linguagem: "
                + linguagem;
    }
}
