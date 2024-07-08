package src.model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private int id;
    private List<Disciplina> disciplinas;
    private static int idCounter = 0;

    public Professor(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
        this.id = ++idCounter;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
            System.out.println(nome + " está ensinando " + disciplina.getNome());
        }
    }

    @Override
    public String toString() {
        return "Professor: " + nome + " | ID: " + id;
    }
}
