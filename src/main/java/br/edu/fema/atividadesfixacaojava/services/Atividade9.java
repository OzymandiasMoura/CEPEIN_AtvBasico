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
    ConvercaoDataString convercao = new ConvercaoDataString();
    public Map<Boolean, List<Aluno>> alunoPorBeneficio(List<Aluno> aluno){
        return aluno.stream().collect(Collectors.groupingBy(a -> a.getPossuiAlgumTipoDeBeneficio()));
    }
    public Map<Month, List<Aluno>> alunoPorMes(List<Aluno> aluno){
        return aluno.stream().collect(Collectors.groupingBy(a -> convercao.stringParaData(a.getDataNascimento()).getMonth()));
    }
    public Map<Year, List<Aluno>> alunoPorAno(List<Aluno> aluno){
        return aluno.stream().collect(Collectors.groupingBy(a -> Year.of(convercao.stringParaData(a.getDataNascimento()).getYear())));
    }
    public Map<YearMonth, List<Aluno>> alunoPorMesAno(List<Aluno> aluno){
        return aluno.stream().collect(Collectors.groupingBy(a -> YearMonth.from(convercao.stringParaData(a.getDataNascimento()))));
    }
    public Map<Boolean, List<Aluno>> alunoPorCurso(List<Aluno> aluno){
        return aluno.stream().collect(Collectors.groupingBy(a -> (a.getCurso() != null) ? true : false));
    }



    @Override
    public void executar()
    {
        AlunoRepository alunoRepository = new AlunoRepository();


        var mapOrg = alunoPorBeneficio(alunoRepository.findAll());
        System.out.println(mapOrg);

        var mapOrg2 = alunoPorMes(alunoRepository.findAll());
        System.out.println(mapOrg2);

        var mapOrg3 = alunoPorAno(alunoRepository.findAll());
        System.out.println(mapOrg3);

        var mapOrg4 = alunoPorMesAno(alunoRepository.findAll());
        System.out.println(mapOrg4);

        var mapOrg5 = alunoPorCurso(alunoRepository.findAll());
        System.out.println(mapOrg5);
    }

}
