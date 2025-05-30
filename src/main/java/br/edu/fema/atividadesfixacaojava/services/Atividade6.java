package br.edu.fema.atividadesfixacaojava.services;


import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.utilities.ConvercaoDataString;

import java.util.*;
import java.util.stream.Collectors;


public class Atividade6 implements Atividade
{
    ConvercaoDataString convercao = new ConvercaoDataString();

    public Set<String> aniversariosOrdenados(List<Aluno> alunos){
        TreeSet<String> listOrd = alunos.stream()
                  .map(a -> convercao.stringParaData(a.getDataNascimento()))
                  .sorted(Comparator.naturalOrder())
                  .map(a -> a.toString())
                  .collect(Collectors.toCollection(TreeSet::new));

        return listOrd;
    }



    @Override
    public void executar()
    {
        AlunoRepository alunoRepository = new AlunoRepository();
        var ord = aniversariosOrdenados(alunoRepository.findAll());
        ord.forEach(System.out::println);
    }
}
