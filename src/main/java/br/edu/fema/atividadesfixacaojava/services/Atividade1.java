package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Atividade1 implements Atividade
{
    public Set<Aluno> returnListaAlunos(List<Aluno> alunos)
    {
        Set<Aluno> alunosSet = new HashSet<Aluno>();

        alunos.forEach(a -> alunosSet.add(a));

        return alunosSet;
    }

    @Override
    public void executar()
    {
        AlunoRepository alunoRepository = new AlunoRepository();
        var alunosSet = returnListaAlunos(alunoRepository.findAll());

        alunosSet.forEach(System.out::println);
    }
}
