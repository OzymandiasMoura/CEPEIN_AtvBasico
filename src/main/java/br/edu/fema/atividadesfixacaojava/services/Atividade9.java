package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.utilities.ConvercaoDataString;

import java.time.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Atividade9 implements Atividade
{
    public Map<Boolean, List<Aluno>> alunoPorBeneficio(List<Aluno> aluno){
        return aluno.stream().collect(Collectors.groupingBy(Aluno::getPossuiAlgumTipoDeBeneficio));
    }
    public Map<Month, List<Aluno>> alunoPorMes(List<Aluno> aluno){
        return aluno.stream().collect(Collectors.groupingBy(a -> ConvercaoDataString.stringParaData(a.getDataNascimento()).getMonth()));
    }
    public Map<Year, List<Aluno>> alunoPorAno(List<Aluno> aluno){
        return aluno.stream().collect(Collectors.groupingBy(a -> Year.of(ConvercaoDataString.stringParaData(a.getDataNascimento()).getYear())));
    }
    public Map<YearMonth, List<Aluno>> alunoPorMesAno(List<Aluno> aluno){
        return aluno.stream().collect(Collectors.groupingBy(a -> YearMonth.from(ConvercaoDataString.stringParaData(a.getDataNascimento()))));
    }
    public Map<Boolean, List<Aluno>> alunoPorCurso(List<Aluno> aluno){
        return aluno.stream().collect(Collectors.groupingBy(a -> (a.getCurso() != null) ? true : false));
    }



    @Override
    public void executar()
    {
        var mapOrg = alunoPorBeneficio(AlunoRepository.findAll());
        System.out.println(mapOrg);

        var mapOrg2 = alunoPorMes(AlunoRepository.findAll());
        System.out.println(mapOrg2);

        var mapOrg3 = alunoPorAno(AlunoRepository.findAll());
        System.out.println(mapOrg3);

        var mapOrg4 = alunoPorMesAno(AlunoRepository.findAll());
        System.out.println(mapOrg4);

        var mapOrg5 = alunoPorCurso(AlunoRepository.findAll());
        System.out.println(mapOrg5);
    }

}
