package src.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorDisciplina {
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();

    public GerenciadorDisciplina() {
        disciplinas = new ArrayList<>();
    }

    public void add(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void addProfessor(Professor professor) {
        professores.add(professor);
    }

    public List<Disciplina> getAllDisciplinas() {
        return new ArrayList<>(disciplinas);
    }

    public List<Aluno> getAllAlunos() {
        return alunos;
    }

    public List<Professor> getAllProfessores() {
        return professores;
    }

    public void matricularAluno(String matricula, int codigoDisciplina) {
        Aluno aluno = alunos.stream()
                .filter(a -> a.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.getCodigo() == codigoDisciplina)
                .findFirst()
                .orElse(null);

        if (aluno != null && disciplina != null) {
            disciplina.matricularAluno(aluno);
        }
    }

    public void associarProfessor(int id, int codigoDisciplina) {
        Professor professor = professores.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.getCodigo() == codigoDisciplina)
                .findFirst()
                .orElse(null);

        if (professor != null && disciplina != null) {
            disciplina.setProfessor(professor);
            professor.adicionarDisciplina(disciplina);
        }
    }

    public List<Disciplina> searchByName(String name) {
        return disciplinas.stream()
                .filter(d -> d.getNome().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public long getTotalCount() { // porque long?
        return disciplinas.size();
    }

    public long getCountByType(Class<?> type) { // porque long?
        return disciplinas.stream()
                .filter(type::isInstance)
                .count();
    }

    public int getSumOfCredits() {
        return disciplinas.stream()
                .mapToInt(Disciplina::getCreditos)
                .sum();
    }

    public double getAverageCredits() {
        return disciplinas.stream()
                .mapToInt(Disciplina::getCreditos)
                .average()
                .orElse(0);
    }

}
