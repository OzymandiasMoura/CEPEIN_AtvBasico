package br.edu.fema.atividadesfixacaojava.services;


import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.utilities.ConvercaoDataString;

import java.util.*;
import java.util.stream.Collectors;


public class Atividade6 implements Atividade
{
    public Set<String> aniversariosOrdenados(List<Aluno> alunos){
        return alunos.stream()
                  .map(a -> ConvercaoDataString.stringParaData(a.getDataNascimento()))
                  .sorted(Comparator.naturalOrder())
                  .map(a -> a.toString())
                  .collect(Collectors.toCollection(TreeSet::new));
    }



    @Override
    public void executar()
    {
        var ord = aniversariosOrdenados(AlunoRepository.findAll());
        ord.forEach(System.out::println);
    }
}
