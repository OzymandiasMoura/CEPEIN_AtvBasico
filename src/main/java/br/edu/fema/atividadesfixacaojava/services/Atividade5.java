package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;


public class Atividade5 implements Atividade
{
    public Aluno ultimoAlunoCadastrado(List<Aluno> aluno)
    {
        TreeSet<Aluno> listaOrg = new TreeSet<>(Comparator.comparing(Aluno::getDataHoraCadastro));

        listaOrg.addAll(aluno);

        return listaOrg.last();
    }

    @Override
    public void executar()
    {
        System.out.println("Ultimo aluno cadastrado:");

        AlunoRepository alunoRepository = new AlunoRepository();

        var ultimoAlunoCadastrado = ultimoAlunoCadastrado(alunoRepository.findAll());

        System.out.println(ultimoAlunoCadastrado);

    }
}
