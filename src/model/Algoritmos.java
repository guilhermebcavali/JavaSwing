package src.model;

public class Algoritmos extends Disciplina {
    private boolean temLaboratorio;

    public Algoritmos(String nome, int codigo, int creditos, int cargaHoraria, boolean temLaboratorio) {
        super(nome, codigo, creditos, cargaHoraria);
        this.temLaboratorio = temLaboratorio;
    }

    public boolean isTemLaboratorio() {
        return temLaboratorio;
    }

    @Override
    public String toString() {
        return "Algoritmos: " + getNome() + " | Código: " + getCodigo() + " | Créditos: " + getCreditos()
                + " | Tem Laboratório: " + temLaboratorio;
    }
}
