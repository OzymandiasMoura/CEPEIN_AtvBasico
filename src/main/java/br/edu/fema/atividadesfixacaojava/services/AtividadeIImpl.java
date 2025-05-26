package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AtividadeIImpl implements AtividadeI
{

    @Override
    public Set<Aluno> returnListaAlunos()
    {
        AlunoRepository alunoRepository = new AlunoRepository();
        List<Aluno> alunos = alunoRepository.findAll();
        Set<Aluno> alunosSet = new HashSet<Aluno>();

        alunos.forEach(a -> alunosSet.add(a));

        return alunosSet;
    }
}
