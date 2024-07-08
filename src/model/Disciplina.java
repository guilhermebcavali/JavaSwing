package src.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Disciplina {
    private String nome;
    private int codigo;
    private int creditos;
    private int cargaHoraria;
    private List<Aluno> alunosMatriculados;
    private Professor professor;

    public Disciplina(String nome, int codigo, int creditos, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.creditos = creditos;
        this.cargaHoraria = cargaHoraria;
        this.alunosMatriculados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void matricularAluno(Aluno aluno) {
        if (!alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
            aluno.matricular(this);
        }
    }

    @Override
    public String toString() {
        return nome + " | Código: " + codigo + " | Créditos: " + creditos + " | Professor: " +
                (professor != null ? professor.getNome() : "Nenhum");
    }
}
