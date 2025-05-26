package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import java.util.List;
import java.util.Set;

public interface AtividadeIV
{
    List<Aluno> alunosPos2001(List<Aluno> alunos);

    Set<Aluno> alunosCad18(List<Aluno> alunos);

    List<Aluno> alunosSemCurso(List<Aluno> alunos);

    List<Aluno> alunosComCurso(List<Aluno> alunos);
}
