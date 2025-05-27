package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;


public class AtividadeVImpl implements AtividadeV
{
    public Aluno ultimoAlunoCadastrado(List<Aluno> aluno)
    {
        TreeSet<Aluno> listaOrg = new TreeSet<>(new Comparator<Aluno>()
        {
            @Override
            public int compare(Aluno o1, Aluno o2)
            {

                return o1.getDataHoraCadastro().compareTo(o2.getDataHoraCadastro());
            }
        });

        listaOrg.addAll(aluno);


        Aluno primeiroAluno = listaOrg.last();

        return primeiroAluno;
    }
}
